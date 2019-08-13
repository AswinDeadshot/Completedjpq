package com.ba.ui;

import java.util.Scanner;

import com.ba.exep.UserValidationException;
import com.ba.pojo.Bank;
import com.ba.service.BankService;
import com.ba.validate.UserInputValidation;

public class BankUserUI {

	public static void main(String args[])
	{
		Bank bank; 
		BankService bankService=new BankService();
		UserInputValidation userValidation=new UserInputValidation();
		Scanner scanner = new Scanner(System.in);
		 int choice;
		 while(true)
		 {
			 	System.out.println("Welcome to xyz bank wallet");
	            System.out.println("Choose any of these options from one to seven");
	            System.out.println("1.Create an Account");
	            System.out.println("2.Check your Balance");
	            System.out.println("3.Deposit Money");
	            System.out.println("4.Withdraw Money");
	            System.out.println("5.Transfer Money");
	            System.out.println("6.View Transaction");
	            System.out.println("7.Exit");
	            choice = scanner.nextInt();
	            switch(choice)
	            {
	            case 1:
	            {
	            	 System.out.println("ENTER YOUR NAME:");
	                 String name=scanner.next();
	 				try {
						while (!UserInputValidation.checkName(name)) {

							System.out.print("    Enter your name : ");
							name = scanner.next();
							name += scanner.nextLine();
						}
					} catch (UserValidationException e) {
						
						e.printStackTrace();
					}
	                 System.out.println("ENTER YOUR DATE OF BIRTH IN DD/MM/YYYY");
	                 String dob=scanner.next();
	                 System.out.println("ENTER YOUR PHONE NUMBER ( MUST CONTAIN ONLY TEN DIGITS )");
	                 String phno=scanner.next();
	                 while(!UserInputValidation.checkPhoneNumber(phno))
	                 {
	                	 System.out.print("Enter your phone number : ");
	                	 phno=scanner.next();
	                 }
	                 System.out.println("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
	                 long amt=scanner.nextLong();
	                 double acno = (Math.random()%100)*1457863;
	                 System.out.println(acno);
	                 bank=new Bank(acno,name,dob,phno,amt,"\n Account created Successfully.");
	                 bankService.addAccount(bank);
                   break;
	            }
	            case 2:
	            {
	            	System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
	            	double accountNumber=scanner.nextDouble();
	            	while(!UserInputValidation.checkAccNo(accountNumber))
	            	{
	                	 System.out.print("Enter your account number : ");
	                	 accountNumber=scanner.nextDouble();
	            	}
	            	
	            	bank=bankService.checkBalance(accountNumber);
	            	System.out.println("Your Account has a balance of Rs."+bank.getBalance());
                   break;
	            }
	            case 3:
	            {
	            	System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
	            	double accountNumber=scanner.nextDouble();
	            	while(!UserInputValidation.checkAccNo(accountNumber))
	            	{
	                	 System.out.print("Enter your account number : ");
	                	 accountNumber=scanner.nextDouble();
	            	}
	            	System.out.println("ENTER THE AMOUNT YOU NEED TO DEPOSIT : ");
	            	long amount=scanner.nextLong();
	            	bank=bankService.depositMoney(accountNumber,amount,"\n Amount of RS."+amount+" was added to your account");
	            	System.out.println("Your Account was credited with Rs."+amount);
	            	System.out.println("Your Account new account balance of Rs."+bank.getBalance());
                   break;
	            }
//                   1078446.0136515994
               case 4:
               {
            		System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
	            	double accNumber=scanner.nextDouble();
	            	while(!UserInputValidation.checkAccNo(accNumber))
	            	{
	                	 System.out.print("Enter your account number : ");
	                	 accNumber=scanner.nextDouble();
	            	}
	            	System.out.println("ENTER THE AMOUNT YOU NEED TO withdraw : ");
	            	long amnt=scanner.nextLong();
	            	bank=bankService.withdrawMoney(accNumber,amnt,"\n An amount of Rs."+amnt+" was withdrawn from your account");
	            	System.out.println("Your Account was debited with Rs."+amnt);
	            	System.out.println("Your Account new account balance of Rs."+bank.getBalance());
                   break;
               }
               case 5:
               {
            	    System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
	            	double accNumber1=scanner.nextDouble();
	            	while(!UserInputValidation.checkAccNo(accNumber1))
	            	{
	                	 System.out.print("Enter your account number : ");
	                	 accNumber1=scanner.nextDouble();
	            	}	            	
	            	System.out.println("ENTER THE AMOUNT YOU NEED TO Transfer : ");
	            	long amnt=scanner.nextLong();
	            	System.out.println("ENTER YOUR ACCOUNT NUMBER TO WHICH YOU NEED TO SEND : ");
	            	double accNumber2=scanner.nextDouble();
	            	while(!UserInputValidation.checkAccNo(accNumber2))
	            	{
	                	 System.out.print("Enter your account number : ");
	                	 accNumber2=scanner.nextDouble();
	            	}	            	
	            	bank=bankService.withdrawMoney(accNumber1,amnt,"An amount of Rs."+amnt+" was debited from your Account");
	            	System.out.println(bank.getBalance());
	            	bank=bankService.depositMoney(accNumber2, amnt,"An amount of RS."+amnt+" was credited to your Acoount");
	            	System.out.println(bank.getBalance());
	            	break;  
               }  
               case 6:
               {
            	   System.out.println("ENTER YOUR ACCOUNT NUMBER : ");
            	   double accNumber=scanner.nextDouble();
            	   while(!UserInputValidation.checkAccNo(accNumber))
	            	{
	                	 System.out.print("Enter your account number : ");
	                	 accNumber=scanner.nextDouble();
	            	}	            	
            	   String trans=bankService.getTransactionDetails(accNumber);
            	   System.out.println(trans);
                   break;
               }
               case 7:
            	   System.out.println("Thank you for using our services");
            	   scanner.close();
                   System.exit(0);
                   break;
               default: 
                   System.out.println("You must enter the valid option ( i.e. between one and seven )");
                   break;
	            }
		 }
	}
	
}
