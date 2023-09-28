//Customer.java

import java.util.*;
import java.io.*;

public class Customer implements Serializable{

  //Scanner input = new Scanner(System.in);

  //class attributes
  protected int accountNum;
  protected int pin;
  protected Saving saving = new Saving();
  protected Checking checking = new Checking();

  public static void main(String[] args){
    Customer a = new Customer(00001, 12345);
    
    Scanner input = new Scanner(System.in);

    //create a loop so that the customer can remain in the menu
    boolean keepGoing = true;
    while(keepGoing){
      String response = a.customerMenu();

      if(response.equals("1")){
        System.out.println("Checking Balance: " + a.getChecking());
      } else if(response.equals("2")){
        System.out.println("Saving Balance: " + a.getSaving());
      } else if(response.equals("3")){
        System.out.println("How much will you deposit?");
	//boolean correct = false;
	//while(!correct){
        try{
	  //correct = true;
          Float number = input.nextFloat();
          a.depositChecking(number);
          System.out.println("New Checking Balance: " + a.getChecking());
        } catch(Exception e){
          System.out.println(e.getMessage());
	  //correct = false;
        }//end try
	//}//end while
      } else if(response.equals("4")){
        System.out.println("How much will you deposit?");
        //boolean correct = false;
	//while(!correct){
        try{
	  //correct = true;
          Float number = input.nextFloat();
          a.depositSaving(number);
          System.out.println("New Saving Balance: " + a.getSaving());
        } catch(Exception e){
          System.out.println(e.getMessage());
	  //correct = false;
        }//end try
	//}//end while
      } else if(response.equals("5")){
        System.out.println("How much do you wish to withdraw?");
        //boolean correct = false;
	//while(!correct){
        try{
	  //correct = true;
          Float number = input.nextFloat();
          a.withdrawChecking(number);
          System.out.println("New Checking Balance: " + a.getChecking());
        } catch(Exception e){
          System.out.println(e.getMessage());
	  //correct = false;
        }//end try
	//}//end while
      } else if(response.equals("6")){
        System.out.println("How much do you wish to withdraw?");
	//boolean correct = false;
	//while(!correct){
        try{
	  //correct = true;
          Float number = input.nextFloat();
          a.withdrawSaving(number);
          System.out.println("New Saving Balance: " + a.getSaving());
        } catch(Exception e){
          System.out.println(e.getMessage());
	  //correct = false;
        }//end try
	//}//end while
      } else if(response.equals("0")){
        System.out.println("Goodbye");
        keepGoing = false;
      } else {
        System.out.println("I didn't understand. Try a listed option");
      }//end if

    }//end while  
    
  }//end main

  public Customer(int accountNum, int pin){
    this.accountNum = accountNum;
    this.pin = pin;
  }//end constructor

  public int getAccountNum(){
    return this.accountNum;
  }//end getAccountNum

  public int getPin(){
    return this.pin;
  }//end getPin

  public float getChecking(){
    return checking.checkBalance();
  }//end getChecking

  public float getSaving(){
    //setInterestTime() will be used by the admin to set all the customers' interestTime
    //saving.calculateInterest();
    return saving.checkBalance();
  }//end getSaving

  public void depositChecking(float balance){
    checking.deposit(balance);
  }//end depositChecking

  public void depositSaving(float balance){
    saving.deposit(balance);
    saving.calculateInterest();
  }//end depositSaving

  public void withdrawChecking(float balance){
    checking.withdraw(balance);
  }//end withdrawChecking

  public void withdrawSaving(float balance){
    saving.withdraw(balance);
  }//end withdrawSaving

  public void setInterestPeriod(float period){
    saving.setInterestPeriod(period);
  }//end setInterestPeriod

  public String customerMenu(){
    Scanner input = new Scanner(System.in);

    //create the customer Menu
    System.out.println("Select an option");
    System.out.println("0) Quit");
    System.out.println("1) View Checking Balance");
    System.out.println("2) View Saving Balance");
    System.out.println("3) Deposit to Checking");
    System.out.println("4) Deposit to Saving");
    System.out.println("5) Withdraw from Checking");
    System.out.println("6) Withdraw from Saving");

    //take in user input
    String response = input.nextLine();
    return response;
  }//end customerMenu
  

}//end class def
