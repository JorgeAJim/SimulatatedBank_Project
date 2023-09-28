//Admin.java

import java.util.*;
import java.io.*;

public class Admin implements Serializable{

  //Scanner input = new Scanner(System.in);

  //class attributes
  protected int accountNum;
  protected int pin;
  protected ArrayList<Customer> customers = new ArrayList<Customer>();
  
  private static final long serialVersionUID = 1L;

  public static void main(String[] args){
    Admin admin = new Admin(00000, 12345);
         
    Scanner input = new Scanner(System.in);

    //experiment with the menu
    boolean keepGoing = true;
    while(keepGoing){
      String response = admin.adminMenu();

      if(response.equals("1")){
        System.out.println("New Customer Account Number");
        int account = input.nextInt();
        System.out.println("New Customer Pin");
        int pin = input.nextInt();
        admin.addUser(account, pin);
      } else if(response.equals("2")){
        System.out.println("Account Number");
        int account = input.nextInt();
        System.out.println("pin");
        int pin = input.nextInt();
        admin.deleteUser(account, pin);
      } else if(response.equals("3")){
        admin.listAllUsers();
      } else if(response.equals("4")){
        System.out.println("Choose the interest period in months");
        Float period = input.nextFloat();
        admin.applyInterestPeriod(period);
      } else if(response.equals("0")){
        System.out.println("Goodbye");
        keepGoing = false;
      } else {
        System.out.println("I didn't understand. Please choose an appropiate choice");
      }//end if
    }//end while
  }//end main

  public Admin(int accountNum, int pin){
    this.accountNum = accountNum;
    this.pin = pin;
  }//end constructor

  public int getPin(){
    return this.pin;
  }//end getPin

  public int getAccountNum(){
    return this.accountNum;
  }//end getAccountNum

  public ArrayList<Customer> getArrayList(){
    return customers;
  }//end getArrayList

  public void setArrayList(ArrayList<Customer> customers){
    this.customers = customers;
  }//end setArrayList

  public void addUser(int accountNum, int pin){
    Customer newCustomer = new Customer(accountNum, pin);
    customers.add(newCustomer);
  }//end addUser


  public void deleteUser(int accountNum, int pin){
    for(int i = 0; i < customers.size(); i++){
      int currentAccountNumber = customers.get(i).getAccountNum();
      int currentAccountPin = customers.get(i).getPin();
      float currentAccountChecking = customers.get(i).getChecking();
      float currentAccountSaving = customers.get(i).getSaving();
      if(currentAccountNumber == accountNum){
        if(currentAccountPin == pin){
	  if(currentAccountChecking == 0){
            if(currentAccountSaving == 0){
              customers.remove(i);
            } else {
              System.out.println("There is still money in the saving account");
            }
          } else {
            System.out.println("There is still money in the checking account");
          }
	} else {
          System.out.println("Pin didn't match any existing account numbers");
        }
      } else{
        System.out.println("Inputted account number doesn't exist");
      }//end if
    }//end for
  }//end deleteUser

  public void listAllUsers(){
    for(int i = 0; i < customers.size(); i++){
      System.out.println("Account Number: " + customers.get(i).getAccountNum() + " " + "Pin: " + customers.get(i).getPin()); 
    }//end for
  }//end listAllUsers

  public void applyInterestPeriod(float period){
    for(int i = 0; i < customers.size(); i++){
      customers.get(i).setInterestPeriod(period);
    }//end
  }//end applyInterestRate

  public String adminMenu(){
    Scanner input = new Scanner(System.in);    


    System.out.println("Select an option");
    System.out.println("0) Quit");
    System.out.println("1) Add a Customer");
    System.out.println("2) Delete a Customer");
    System.out.println("3) List all Customers");
    System.out.println("4) Apply an Interest period");

    //take in user input
    String response = input.nextLine();
    return response;
  }//end adminMenu

}//end class def
