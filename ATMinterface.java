import java.util.ArrayList;
import java.util.Scanner;

class BankAccount{
private double balance;
private ArrayList<String>history=new ArrayList<>();

public BankAccount(double balance){
this.balance=balance;
}
public void deposit(double amount){
balance += amount;
history.add("Deposited ₹"+ amount);
System.out.println("Successfully Deposited ₹"+amount);
}

public void withdraw(double amount){
if(amount <= balance){
balance -= amount;
history.add("withdraw ₹"+amount);
System.out.println("Successfully Withdrawn ₹"+amount);
}else{
System.out.println("Insufficient Balance!");
}
}
public void transfer(String accountNumber,double amount){
if(amount <=balance){
balance -= amount;
history.add("Transferred ₹"+ amount+"to account no."+accountNumber);
System.out.println("Transfer Successful");
}else{
System.out.println("Insufficient Balance!");
}
}
public void showBalance(){
System.out.println("Current Balance:₹"+balance);
}
public void showHistory(){
if(history.isEmpty()){
System.out.println("\n Transaction Histry:");
for(String transaction:history){
System.out.println(transaction);
}
}
}
}
public class ATMinterface{
public static void main(String[] args){

Scanner sc=new Scanner(System.in);
BankAccount account=new BankAccount(10000);

int correctPin =1234;
int attempts=3;

while(attempts>0){
System.out.println("Enter ATM PIN:");
int pin=sc.nextInt();
if(pin==correctPin){
System.out.println("Login successful!\n");
break;
}else{
attempts--;
System.out.println("Wrong PIN! Attempts Left:"+attempts);
}
if(attempts==0){
System.out.println("Car Blocked!");
sc.close();
return;
}
}
int choice;

do{
System.out.println("\n====ATM MENU====");
System.out.println("1.Check balance");
System.out.println("2.Deposit");
System.out.println("3.Withdraw");
System.out.println("4.Transfer");
System.out.println("5.Transaction History");
System.out.println("6.Exit");
System.out.println("Enter Choice:");

choice=sc.nextInt();

switch(choice){
case 1:
account.showBalance();
break;

case 2:
System.out.println("Enter deposit Amount:");
double depositAmount=sc.nextDouble();
account.deposit(depositAmount);
break;

case 3:
System.out.println("Enter Withdraw Amount:");
double withdrawAmount=sc.nextDouble();
account.withdraw(withdrawAmount);
break;

case 4:
System.out.println("Thank you for Using ATM!");
break;

default:
System.out.println("Invalid Choice!");
}
}while(choice !=4);
sc.close();
}
}