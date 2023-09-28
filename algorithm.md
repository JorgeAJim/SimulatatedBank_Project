Jorge Jimenez
CSCI24000 - Andrew Harris
3/8/2022
A7 - Bank on it

Goal - To create an ATM program that allows users to login into their personal accounts using login credentials. The user will either be a customer that will have a savings and checking account, or the user will be an admin that can manage customers and the interest rate of the bank.

Input - Customers will be allowed to input how much they wish to withdraw or deposit into their accounts. Admins will be allow to input which users to add or delete from the system. Admins can also set the interest rate and unit of time for the interest.

Output - Customers will be allow to see thier balance in their accounts. Admins will be able to see a complete list of customers.

Steps:
  Atm.java:
    Possible requirements: access to all other classes, which should be in the same directory. Access to the users information file, where all the user information is located.

    Goal - Main.Java will create or load the Admin from the data file. Then allow the admin or customer to loggin

    Login():
      Goal - to decide which type of user is entering the atm
      Input - the user account number and pin
      Output - Open a corresponding while loop that will open the correct menu and allow the customer or admin to use all their corresponding methods. And save all the changes to Admin when the program ends.


  Customer.java:
    Goal: to store the account number and pin of the customer. As well as, instances of Checking and Savings classes so that the customer can have access to those class methods. The Customer will need to have access to deposit and withdraw from the appropiate bank accounts.
    
    Customer():
     Goal: construct a Customer instance with given account number and pin.
     Input: the user wil provide the desired account number and pin for the new user
     Output: the customer attributes for account number and pin of the class

    getAccountNum():
      Goal: to return the account number

    getPin():
      Goal: to return the pin

    getChecking():
      return the balance of the Checking balance

    getSaving():
      return the balance of Saving account after calculating the interest rate

    depositChecking():
      Goal: to increase the amount of money in the checking balance
      Input: a float parameter is given
      Goal: the checking balance is updated
      Steps: the float parameter is added to the overall balance

    depositSaving():
      Same as depositChecking(), however the goal is to increase the amount of the saving balance
     
    withdrawChecking():
      Goal: to remove from the checking balance and to make sure the user can not remove more than the overall balance
      Input: a float parameter is given
      Ouput: the overall balance should decrease by the amount set
      Steps: the overall balance should decrease by the float parameter. If the overall balance is less than zero, then the float parameter is added back to the balance since you can not withdraw more than the overall balance.

    withdrawSaving():
      The same as withdrawChecking, but it affects the saving

    customerMenu():
      Goal: give the user a menu of all the possible things the customer class can do
      Input: the user will give a string input corresponding to the menu options
      Output: the string input will be returned
      Steps: use a simple scanner that will take in a string input

  Admin.java:
    Goal: the admin should have direct acess to a list of all the users. As well as, the ability to delete or add more users to the system. Another main job of the Admin is to apply the interest rate and time unit for calcualting interest, with both values being stored in the whole system. The entire class should be serializable so that it can be saved to a text file.
    
    getAccount();
      return account number

    getPin():
      return pin

    addUser():
      Goal: to add a new customer to the customer arraylist
      Input: take a parameter for the account number and pin for the new customer
      Output: the arraylist should hold a new customer

    deleteUser():
      Goal: to remove a customer from the arraylist
      Input: the account number and pin of the customer that will be deleted are given as parameters
      Output: the customer should be removed from the arraylist
      Steps: A for loop will iterate through the entire arraylist and compare the account numbers and pins with the inputed account number and pin. When there is a match for both, the saving and checking balance of the user are checked to be zero. If there is money in either the checking or savings then the customer can not be removed from the arraylist.

    listAllUsers():
      Goal: to print all the customers in the arraylist
      Input: no user input is required
      Output: the program should print the account number and pin for each customer
      Steps: use a for loop to iterate through the entire arraylist. Then use the getAccountNum() and getPin() methods for each customer

     applyInterstPeriod():
       Goal: to apply a universal interest period to all the customers inside the arraylist
       Input: a interest period, in months, must be provided
       Output: the setInterestPeriod() for each customer should update the saving account interest period

     adminMenu():
      Goal: to allow the user to select a menu option of all the Admin class can do 
      Input: a string input of the choice the user made
      Output: return the string inputted vlaue
      Steps: use a simple string scanner to take the user input
   

  Checking.java:
    Goal: to hold a balance of money, and to have ways to deposit into or withdraw from that balance, and a way to check the overall balance.
     
     deposit():
       Goal: Deposit() should increase the overall balance the account has, by adding the inputed amount to the already exising balance.
       
       Input: Deposit() should take a float/int input from the user.
       Output: Deposit() will update the balance attribute to incoporate the new amount of inputed wealth into the overall account balance.
       
     withdraw():
       Goal: withdraw() should decrease the overall balance of the account, by subtracting the amount the user wishes to take out.

       Input: withdraw() should take an inputed float/int from the user. However, this inputed amount can not be more than the current balance of the account.

       Output: withdraw() should update the balance attribute of the class.

     checkBalance():
       Goal: checkBalance() should return the current balance of the account.
       Input: the user is expected to have no input on this method
       Output: the checkBalance() method should print the return the int/float balance value. Maybe, directly to the terminal.

  Saving.java:
    Goal: to do the same as the Checking account, but also calculate the interest using a given interest period to the overall balance.
      
      calculateInterest():
        Goal: to calculate the overall interest by using the interst rate and the appropriate unit of time for the calculation.
          
        Input: the Admin.class will update the interest period
        Output: the calculated interest will be added to the saving balance.
    
      setInterestPeriod():
	Goal: to update the interest period attribute
        Input: the user will put a number into as a parameter
        Output: the interest period should be updated.
    
