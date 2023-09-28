Atm.class: Atm.java
	javac -g Atm.java

Admin.class: Admin.java
	javac -g Admin.java

Customer.class: Customer.java
	javac -g Customer.java

Saving.class: Saving.java Checking.class
	javac -g Saving.java

Checking.class: Checking.java
	javac -g Checking.java

clean:
	rm *.class

run: Atm.class
	java Atm

debug: Atm.class
	jdb Atm

