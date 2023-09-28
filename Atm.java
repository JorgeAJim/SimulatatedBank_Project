//Atm.java

import java.io.*;
import java.util.*;
import java.text.*;

public class Atm {

  Scanner input = new Scanner(System.in);

  public static void main(String[] args){
    new Atm();
  }//end main

  public Atm(){
    Scanner input = new Scanner(System.in);
    DecimalFormat rounding = new DecimalFormat("0.00");

    //check if an admin instance already exist or
    //create and save an instance of admin to the "users.txt" file
    Admin newAdmin = null;
    try{
      FileInputStream fIn = new FileInputStream("users.txt");
      ObjectInputStream obIn = new ObjectInputStream(fIn);
      newAdmin = (Admin)obIn.readObject();
      fIn.close();
      obIn.close();
    } catch (IOException i){
      System.out.println(i.getMessage());
     newAdmin = new Admin(00000, 12345);
      try{
        FileOutputStream fileOut = new FileOutputStream("users.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(newAdmin);
        fileOut.close();
        objectOut.close();
      } catch(Exception ex){
        System.out.println(ex.getMessage());
      }//end try
    }catch(ClassNotFoundException c){
      System.out.println(c.getMessage());
      
      newAdmin = new Admin(00000, 12345);
      try{
        FileOutputStream fo = new FileOutputStream("users.txt");
        ObjectOutputStream obOut = new ObjectOutputStream(fo);
        obOut.writeObject(newAdmin);
        fo.close();
        obOut.close();
      } catch(IOException e){
        System.out.println(e.getMessage());
      }//end try

    }catch(Exception e){
      System.out.println(e.getMessage());
    }//end try

    ArrayList<Customer> customers = newAdmin.getArrayList();

    boolean keepGoing = true;
    while(keepGoing){

      String loginResponse = menu();
      if(loginResponse.equals("1")){
        //ask the users to give their log in credentials
        System.out.println("Please input the user's account number");
        int adminAccountNumber = input.nextInt();
        System.out.println("Please input the user's pin");
        int adminPin = input.nextInt();
        
	

        //check if the user is trying to log in as the admin
        if(newAdmin.getAccountNum() == adminAccountNumber){
          if(newAdmin.getPin() == adminPin){
            //allow the admin to use all the Admin methods
            //with exeption handeling
            boolean keepGoing2 = true;
            while(keepGoing2){
              String response = newAdmin.adminMenu();
             
              if(response.equals("1")){
		try{
                  System.out.println("New Customer Account Number");
                  int account = input.nextInt();
                  System.out.println("New Customer Pin");
                  int pin = input.nextInt();
                  newAdmin.addUser(account, pin);
		} catch(Exception e){
		  System.out.println(e.getMessage());
		}//end try
              } else if(response.equals("2")){
		try{
                  System.out.println("Account Number");
                  int account = input.nextInt();
                  System.out.println("Pin");
                  int pin = input.nextInt();
                  newAdmin.deleteUser(account, pin);
		} catch(Exception e){
 		  System.out.println(e.getMessage());
		}//end try
              } else if(response.equals("3")){
                newAdmin.listAllUsers();
              } else if(response.equals("4")){
		try{
                System.out.println("Choose the interest period in months");
		String givenPeriod = input.nextLine();
                Float period = Float.parseFloat(givenPeriod);
		period = Float.valueOf(rounding.format(period));
                newAdmin.applyInterestPeriod(period);
		} catch(Exception e){
                  System.out.println(e.getMessage());
  		}//end try
              } else if(response.equals("0")){
                System.out.println("Goodbye");
                keepGoing2 = false;
                newAdmin.setArrayList(customers);
              } else {
                System.out.println("I didn't understand. Please choose an appropiate choice");
              }//end if
            }//end whilei
          } else {
            System.out.println("Pin didn't match the Admin pin");
          }
        } else {
          System.out.println("Given Account Number and Pin don't match admin");
        }//end Admin login
      } else if(loginResponse.equals("2")){
          System.out.println("Customer Account Number");
          int customerAccountNumber = input.nextInt();
          System.out.println("Customer Pin");
          int customerPin = input.nextInt();


        //check if the user is trying to login as a customer
        for(int i = 0; i < customers.size(); i++){
          if(customers.get(i).getAccountNum() == customerAccountNumber){
            if(customers.get(i).getPin() == customerPin){
              boolean keepGoing3 = true;
              while(keepGoing3){
                String response = customers.get(i).customerMenu();
                input = new Scanner(System.in);


                if(response.equals("1")){
                  System.out.println("Checking Balance: " + customers.get(i).getChecking());
                } else if(response.equals("2")){
                  System.out.println("Saving Balance: " + customers.get(i).getSaving());
                } else if(response.equals("3")){
                  System.out.println("How much will you deposit?");
	          try{
		    String userDeposit = input.nextLine();
	            float deposit = Float.parseFloat(userDeposit);
                    //DecimalFormat rounding = new DecimalFormat("0.00");
                    deposit = Float.valueOf(rounding.format(deposit));
	            (customers.get(i)).depositChecking(deposit);
	            System.out.println("New Checking Balance: " + customers.get(i).getChecking());
	          } catch(Exception e){
		    System.out.println(e.getMessage());
	          }//end try
	        } else if(response.equals("4")){
     	          System.out.println("How much will you deposit?");
	          try{
		    String userDeposit = input.nextLine();
      	            float deposit = Float.parseFloat(userDeposit);
                    deposit = Float.parseFloat(rounding.format(deposit));
		    (customers.get(i)).depositSaving(deposit);
		    System.out.println("New Saving Balance: " + customers.get(i).getSaving());
	          } catch(Exception e) { 
         	      System.out.println(e.getMessage());
                  }//end try
	        } else if(response.equals("5")){
	          System.out.println("How much do you wish to withdraw?");
	          try{
		    String userWithdraw = input.nextLine();
		    float withdraw = Float.parseFloat(userWithdraw);
                    withdraw = Float.valueOf(rounding.format(withdraw));
        	    (customers.get(i)).withdrawChecking(withdraw);
        	    System.out.println("New Checking Balance: " + customers.get(i).getChecking());
    	          } catch(Exception e){
	            System.out.println(e.getMessage());
	          }//end try
	        } else if(response.equals("6")){
	          System.out.println("How much do you wish to withdraw?");
	          try{
		    String userWithdraw = input.nextLine();
		    float withdraw = Float.parseFloat(userWithdraw);
                    withdraw = Float.valueOf(rounding.format(withdraw));
		    (customers.get(i)).withdrawSaving(withdraw);
		    System.out.println("New Saving Balance: " + customers.get(i).getSaving());
                  } catch(Exception e){
		      System.out.println(e.getMessage());
	          }//end try
	        } else if(response.equals("0")){
                  System.out.println("Goodbye");
	          keepGoing3 = false;
                  newAdmin.setArrayList(customers);
	        } else {
	          System.out.println("I didn't understand. Try a listed option");
	        }//end if
	      }//end while
            } else {
                System.out.println("Pin doesn't match any existing accounts");
            }//end if
          } else{
            System.out.println("Account number doesn't match any existing accounts");
          }//end if
        }//end for

      } else if(loginResponse.equals("0")){    
        keepGoing = false;
        newAdmin.setArrayList(customers);
        //end by saving all changes to admin to users.txt
        try{
          FileOutputStream fOut = new FileOutputStream("users.txt");
          ObjectOutputStream out = new ObjectOutputStream(fOut);
          out.writeObject(newAdmin);
          fOut.close();
          out.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
        }//end try
      } else {
        System.out.println("Sorry, pick a listed option");
      }//end if
    }//end login menu
  }//end constructor  

  public String menu(){
    System.out.println("Select an option");
    System.out.println("1) Login as Admin");
    System.out.println("2) Login as Customer");
    System.out.println("0) quit");
    String response = input.nextLine();
    return response;
  }
  

}//end class def
