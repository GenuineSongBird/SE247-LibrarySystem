/*
 * This class instructs the user on how to make an account, then, if successful, puts that account in the userDatabase.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Tyson Medlin, 
 * Date: 10/24/2019
 */
package LibrarySystem;

import java.util.Scanner;

public class userCreationPage {
	//This class instructs the user on how to make an account, then, if successful, puts that account in the userDatabase.
	public boolean createAccount()
	{
		startPage.getLine();
		Scanner key = new Scanner(System.in);
		String name;
		String password;
		String address;
		String phoneNumber;
		String email;
		String age;
		System.out.println("Please enter your name");
		name = key.nextLine();
		System.out.println("Please enter your password for this account");
		password = key.nextLine();
		System.out.println("Please enter your address");
		address = key.nextLine();
		System.out.println("Please enter your phone number");
		phoneNumber = key.nextLine();
		System.out.println("Please enter your email");
		email = key.nextLine();
		System.out.println("Please enter your age");
		age = key.nextLine();
		while (age.matches("-?\\d+") == false)
		{
			System.out.println("Age must be a number\nPlease enter your age");
			age = key.nextLine();
		}
		baseUser thisUser = userDatabase.getInstance().createUser(name, Integer.valueOf(age), phoneNumber, address, email, password);
		startPage.changeToCurrentUser(thisUser); //The user is logged in after creating their account.
		return true;
	}
}
