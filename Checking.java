//Checking.java

import java.util.*;
import java.io.*;

public class Checking implements Serializable {
  
  //class attributes
  protected float balance = 0f;

  //create main
  public static void main(String[] args){
    Checking checking = new Checking();

    checking.deposit(15.5f);
    System.out.println("Balance: " + checking.checkBalance());
    checking.withdraw(17f);
    System.out.println("Balance: " + checking.checkBalance());
    checking.withdraw(10.3f);
    System.out.println("Balance: " + checking.checkBalance());
  }//end main

  public void deposit(float balance){
    this.balance += balance;
  }//end deposit

  public void withdraw(float balance){
    this.balance -= balance;

    //a customer can't withdraw more than what they have
    if(this.balance < 0){
      System.out.println("Can't withdraw more than what you have.");
      this.balance += balance;
    }//end if

  }//end withdraw

  public float checkBalance(){
    return this.balance;
  }//end checkBalance

}//end class def
