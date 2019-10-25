/*
 * This class is the main class of the library system. 
 * Finds out what the user wants to do, then calls that class.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer of this class: Tyson Medlin
 * Date: 10/24/2019
 */
package LibrarySystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class startPage {
		
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		boolean exitProgram = false;
		String[] choices = {"Login or create account","Logout","Browse available items","View fees","Pay fees","Return item","View holds","View wishlist"};
		//get if user is signed in
		
		//The home screen
		while( exitProgram == false ) //infinite menu loop
		{
			System.out.println(getTitle());
			System.out.println("Untitled Version 0.1 Date: " + getDate());
			if(isUserLoggedIn() == false) { System.out.println("Not currently logged in."); } else { System.out.println("Welcome, "); }
			int usersChoice = getUserChoice(choices, choices.length);
			getResponseForChoice(usersChoice);
		}
		System.exit(0);
	}
	/* display a set of choices in a string array with matching numbers, with ease.
	 * @param choices: the string array of all the choices you want given and  availableChoices: The amount of choices in that array just mentioned.
	 * @returns the realistic user choice.
	 */
	public static int getUserChoice(String[] choices, int availableChoices)
	{
		String userChoice = "0";
		Scanner key = new Scanner(System.in);
		//Ensures we get an actual choice from the user and not anything else.
		while (userChoice.matches("-?\\d+") == false || userChoice.matches("-?\\d+") == true && Integer.valueOf(userChoice) > availableChoices || userChoice.matches("-?\\d+") == true && Integer.valueOf(userChoice) < 1){
			System.out.println(getLine());
			System.out.println(choiceSetup(choices));
			userChoice = key.nextLine();
		}
		return Integer.valueOf(userChoice);
	}
	private static void getResponseForChoice(int usersChoice)
	{
		switch(usersChoice) {
			case 1:
				login();
				return;
			case 2:
				logout();
				return;
			case 3:
				browse();
				return;
			case 4:
				viewFee();
				return;
			case 5:
				payFee();
				return;
			case 6:
				returnItem();
				return;
			case 7:
				viewHolds();
				return;
			case 8:
				viewWishlist();
				return;
		}
		
	}
	
	//Main Choice Methods ----------------------------------------------------------------------------
	private static void login()
	{
		loginPage login = new loginPage();
	}
	private static void logout()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
	}
	private static void browse()
	{
		makeUserLookAtThisMessageLoop("This feature will be added once databases are ready"); //forces user to read the message before continuing.
	}
	private static void viewFee()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
	}
	private static void returnItem()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{  return; }
	}
	private static void payFee()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
	}
	private static void viewHolds()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
	}
	private static void viewWishlist()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
	}
	
	
	//Helper Methods ----------------------------------------------------------------------------
	//public static user getCurrentUser()
	//{
		
	//}
	
	//Returns date in String in this format: yyyy/dd/MM HH:mm:ss
	public static String getDate()
	{
		String date = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
		Date Date = new Date();
		date = (String)dateFormat.format(Date);
		return date;
	}
	public static String getTitle()
	{
		String title = "---------------------\nUntitled Library System\n---------------------";
		return title;
	}
	public static String getLine()
	{
		String line = "---------------------";
		return line;
	}
	public static String choiceSetup(String[] choices)
	{
		String choiceDialogue = "Please select a choice\n";
		for(int i = 0; i < choices.length; i++)
		{
			choiceDialogue =  choiceDialogue + (i+1) + ". " + choices[i] + "\n";
		}
		return choiceDialogue;
	}
	public static boolean isUserLoggedIn()
	{
		return false;
	}
	public static boolean isUserLoggedInLoop()
	{
		if( isUserLoggedIn() == false ) 
		{
			makeUserLookAtThisMessageLoop("Cannot perform this action without being logged in.");
			
		  return false;
		}
		return true;
	}
	public static void makeUserLookAtThisMessageLoop( String message )
	{
		Scanner key = new Scanner(System.in);
		String choice = "2";
		while(choice.equalsIgnoreCase("1") == false) {
			System.out.println(message);
			System.out.println("Return to main menu?. \n1. Yes\n2. No");
		choice = key.nextLine();
		}
	}
}