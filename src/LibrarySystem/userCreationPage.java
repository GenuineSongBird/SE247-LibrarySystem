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
		int accountNumber;
		System.out.println("Please enter your name");
		name = key.nextLine();
		System.out.println("Please enter your password for this account");
		name = key.nextLine();
		System.out.println("Please enter your address");
		name = key.nextLine();
		System.out.println("Please enter your phone number");
		name = key.nextLine();
		System.out.println("Please enter your email");
		name = key.nextLine();
		System.out.println("Please enter the age");
		name = key.nextLine();
		//accountNumber = database.getFreshAccountNumber();
		//database.addUser(...);
		return true;
	}
}
