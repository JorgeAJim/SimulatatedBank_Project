//Saving.java

import java.io.*;

public class Saving extends Checking implements Serializable{
  protected float interestPeriod = 0;

  public static void main(String[] args){
    Saving saving = new Saving();

    saving.deposit(100f);
    saving.setInterestPeriod(12f);
    saving.calculateInterest();
    System.out.println("Balance: " + saving.checkBalance());
    
  }//end main

  public void setInterestPeriod(float period){
    this.interestPeriod = period;
  }//end setInterestTime

  public void calculateInterest(){
    this.balance = this.balance*(1 + 0.06f*this.interestPeriod);
  }//end calculateInterest


}//end class def
