package com.ba.validate;

import com.ba.dao.BankDAO;
import com.ba.exep.UserValidationException;


public class UserInputValidation {

	static BankDAO bankDAO=new BankDAO();
	
	public static boolean checkName(String name) throws UserValidationException{
	
		int n = name.length();
		char[] ch = name.toCharArray();
		for (int i = 0; i < n; i++) {
			try {
				if (ch[i] > 64 && ch[i] < 122 && ch[0]>63 && ch[0]<90) {
					return true;
				} else {
					throw new UserValidationException("Invalid Name");
				}
			} 
			catch (UserValidationException E) {
				System.out.println(E);
				return false;
			}
	}
		return false;
	}
	
	
	public static boolean checkPhoneNumber(String number)
	{
		if(number.matches("[0-9]+") && number.length()==10)
		{
			return true;
		}
		else
		{
			System.out.println("Invalid Phone Number");
			return false;
		}
	}
	
	public static boolean checkPIN(String pin)
	{
		if(pin.matches("[0-9]+") && pin.length()==10)
		{
			return true;
		}
		else
		{
			System.out.println("Invalid PIN");
			return false;
		}
	}
	
	public static boolean checkAccNo(double accountNumber)
	{
		if(bankDAO.checkAccNo(accountNumber))
		return true;
		else
		{
			System.out.println("INVALID ACCOUNT NUMBER");
		return false;
		}
     }
}
