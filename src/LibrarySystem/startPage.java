/*
 * This class is the main class of the library system. 
 * Finds out what the user wants to do, then calls that class.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Tyson Medlin,
 * Date: 10/24/2019
 */
package LibrarySystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

import org.joda.time.DateTime;



public class startPage {
	static baseUser currentUser = null;	
	static boolean feesAppliedThisUser = false;
	static boolean checkedForAvailableHolds = false;
	public static void main(String[] args) {
		itemDatabase iDatabase  = itemDatabase.getInstance();
		iDatabase.loadDatabase();
		userDatabase.getInstance();
		Scanner key = new Scanner(System.in);
		boolean exitProgram = false;
		
		updateAccountTypes();
		String[] choices = {"Login or create account","Logout","Browse available items","View fees","Pay fees","Return item","View holds","View wishlist","View checked out items"};
		//for testing admin functionalities
		//currentUser = new userLibrarian("librarian", 0, "a", "a", "a", 0, 0, "a");
		//userDatabase.database.add(new userPatron("John", 0, "a", "a", "a", 0, 0, "a"));
		//
		if(currentUser != null && (currentUser.getType().equalsIgnoreCase("Admin")))
		{
			choices = Stream.concat(Arrays.stream(choices), Arrays.stream(adminControls.adminChoicesArray())).toArray(String[]::new);
		}
		if(currentUser != null && (currentUser.getType().equalsIgnoreCase("Librarian")))
		{
			choices = Stream.concat(Arrays.stream(choices), Arrays.stream(librarianControls.librarianChoicesArray())).toArray(String[]::new);
		}
		//The home screen
		while( exitProgram == false ) //infinite menu loop
		{
			//if(currentUser != null) {  }
			System.out.println(userDatabase.database.size());
			applyFees();
			checkForHolds();
			//
			//The below line of code tests the "alert user when item on hold is available feature. Instructions: 1: enable code. 2: put an item on hold. 3: check out any item 4: leave home menu then return. 5: see proof that the hold system works.
			//if(currentUser != null) { if(currentUser.checkedOutList.size() != 0) { for(int i = 0; i < itemDatabase.database.size(); i++) { itemDatabase.database.get(i).setNumCopies(100);checkedForAvailableHolds = false;} } }
			//
			System.out.println(getTitle());
			System.out.println("Untitled Version 1.0 Date: " + getDate());
			if(isUserLoggedIn() == false) { System.out.println("Not currently logged in."); } else { System.out.println("Welcome, "+currentUser.getName()+ "!"); }
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
	public static int getUserChoiceAndPrintSpecial(String[] choices, int availableChoices, String[] special)
	{
		String userChoice = "0";
		Scanner key = new Scanner(System.in);
		//Ensures we get an actual choice from the user and not anything else.
		while (userChoice.matches("-?\\d+") == false || userChoice.matches("-?\\d+") == true && Integer.valueOf(userChoice) > availableChoices || userChoice.matches("-?\\d+") == true && Integer.valueOf(userChoice) < 1){
			System.out.println(getLine());
			System.out.println(choiceSetupAndPrintSpecial(choices, special));
			userChoice = key.nextLine();
		}
		return Integer.valueOf(userChoice);
	}
	/* Gives this class's appropriate response given the users choice
	 * @param the users choice in integer format
	 * @returns none
	 */
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
			case 9:
				currentUser.viewCheckedOutList();
				return;
			case 10:
				 System.out.println("Please enter the information for the user you would like to create");loginPage.createNewUser(); 
				return;
			case 11:
				removeUser();
				return;
			case 12:
				addAnItem();
				return;
			case 13:
				viewUserAcctInfo();
				return;
			case 14:
				flagUser();
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
		currentUser = null;
		makeUserLookAtThisMessageLoop("You are now logged out.");
	}
	private static void browse()
	{
		//makeUserLookAtThisMessageLoop("This feature will be added once databases are ready"); //forces user to read the message before continuing.
		browsePage browse = new browsePage();
		browse.browse();
	}
	private static void viewFee()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
		String fees = String.valueOf(currentUser.getFeeTotal());
		if(Double.valueOf(fees) == 0)
			fees = "None";
		else
			fees = "$ " + fees;
		makeUserLookAtThisMessageLoop("Fee Amount: "+ fees);
	}
	private static void returnItem()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{  return; }
		if(currentUser.checkedOutList.isEmpty())
		{
			makeUserLookAtThisMessageLoop(currentUser.getName() + " has no currently checked out items ");
		}
		else
		{
			System.out.println("Please select the item being returned");
			int choice;
			String[] choiceArray = new String[currentUser.checkedOutList.size()];
			for(int i = 0; i < currentUser.checkedOutList.size(); i++)
			{
				choiceArray[i] = currentUser.checkedOutList.get(i).getTitle();
			}
			choice = startPage.getUserChoice(choiceArray, choiceArray.length);
			for(int i = 0; i < itemDatabase.database.size(); i++)
			{
				if(itemDatabase.database.get(i).getTitle().equalsIgnoreCase(choiceArray[choice-1]))
				{
					itemDatabase.database.get(i).setNumCopies(itemDatabase.database.get(i).getNumCopies() + 1);
					
				}
			}
			currentUser.checkedOutList.remove(choice-1);
			makeUserLookAtThisMessageLoop("Successfully returned " + choiceArray[choice-1] + "!");
		}
		

		
	}
	private static void payFee()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
		Scanner key = new Scanner(System.in);
		String fees = String.valueOf(currentUser.getFeeTotal());
		if(Double.valueOf(fees) == 0)
			System.out.println("Fee Amount: "+ "None");	
		else
			System.out.println("Fee Amount: $"+ fees );
		if(Double.valueOf(fees) == 0)
		{
			makeUserLookAtThisMessageLoop("There are no fees to be paid.");
			return;
		}
		else
		{
			String payThisMuch = "";
			System.out.println("How much would you like to pay?");
			payThisMuch = key.nextLine();
			while (payThisMuch.matches("-?\\d+") == false)
			{
				System.out.println("Please enter a number for how much you would like to pay");
				payThisMuch = key.nextLine();
			}
			while ((Double.valueOf(payThisMuch) > Double.valueOf(fees))==true)
			{
				System.out.println("You can not pay off more than what you owe\nPlease enter a number for how much you would like to pay");
				payThisMuch = key.nextLine();
			}
			Double resultingFee = Double.valueOf(Double.valueOf(fees) - Double.valueOf(payThisMuch));
			System.out.println("$"+ payThisMuch + " payed off.\nAmount left: " + resultingFee);
			makeUserLookAtThisMessageLoop("");
			currentUser.setFeeTotal(resultingFee);
		}
	}
	private static void viewHolds()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
		boolean foundOne = false;
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getHolds().contains(currentUser))
			{
				System.out.println(itemDatabase.database.get(i).toString());
				makeUserLookAtThisMessageLoop("");
				foundOne = true;
			}
			else if(i == itemDatabase.database.size()-1 && foundOne == false)
			{
				makeUserLookAtThisMessageLoop("There are no holds currently for " + currentUser.getName());
			}
		}
	}
	private static void viewWishlist()
	{
		if( isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{ return; }
		if(currentUser.wishList.size() == 0)
		{
			makeUserLookAtThisMessageLoop("There are no items on " + currentUser.getName() + "'s wishlist");
			return;
		}
		for(int i = 0; i < currentUser.wishList.size(); i++)
		{
			makeUserLookAtThisMessageLoop(currentUser.wishList.get(i).toString());
		}
	}
	public static void applyFees()
	{
		if(feesAppliedThisUser == false && currentUser != null)
		{
			DateTime dateTime = new DateTime();
			for(int i = 0; i < currentUser.checkedOutList.size(); i++)
			{
				if(dateTime.isAfter(Long.valueOf(currentUser.checkedOutList.get(i).getDueDate())))
				{
					currentUser.addToFeeTotal(0.01);
				}
			}
			
			feesAppliedThisUser = true;
		}
	
	}
	public static void checkForHolds()
	{
		if(checkedForAvailableHolds == false && currentUser != null)
		{
			for(int i = 0; i < itemDatabase.database.size(); i++)
			{
				
				if(itemDatabase.database.get(i).getHolds().isEmpty() == false && itemDatabase.database.get(i).getHolds().peek().getName().equalsIgnoreCase(currentUser.getName()) && itemDatabase.database.get(i).getNumCopies() > 0) // if we are on hold for this item
				{
						
					makeUserLookAtThisMessageLoop(itemDatabase.database.get(i).getTitle() + " is now available for checkout!"); //alert the user, once only
				}
				
			}
			checkedForAvailableHolds = true;
		}
	}
	public static void updateAccountTypes()
	{
		for( int i = 0; i < userDatabase.database.size(); i++)
		{
			if(userDatabase.database.get(i).getAge() >= 16)
			{
				baseUser oldChild = userDatabase.database.get(i);
				userDatabase.database.remove(userDatabase.database.get(i));
				userDatabase.getInstance().createUser(oldChild.getName(), oldChild.getAge(), oldChild.getPhoneNum(), oldChild.getAddress(), oldChild.getEmail(), oldChild.getPassword());
	
			}
		}
	}
	public static void addAnItem()
	{
		
		System.out.println("Please choose which item to add a copy to");
		String[] allItems = new String[itemDatabase.database.size()];
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			allItems[i] = itemDatabase.database.get(i).getTitle();
		}
		int userChoice = getUserChoice(allItems, allItems.length);
		itemDatabase.database.get(userChoice-1).addCopy();
		makeUserLookAtThisMessageLoop("Successfully added a copy to " + itemDatabase.database.get(userChoice-1).getTitle());
	}
	public static void removeUser()
	{
		if(userDatabase.database.size() == 0) { makeUserLookAtThisMessageLoop("The user database is empty\nNo users to remove"); return;}
		System.out.println("Please choose the account to remove");
		String[] allItems = new String[userDatabase.database.size()];
		for(int i = 0; i < userDatabase.database.size(); i++)
		{
			allItems[i] = userDatabase.database.get(i).getName();
		}
		int userChoice = getUserChoice(allItems, allItems.length);	
		makeUserLookAtThisMessageLoop("Successfully removed " + userDatabase.database.get(userChoice-1).getName() + "!");
		userDatabase.database.remove(userDatabase.database.get(userChoice-1));
	}
	public static void viewUserAcctInfo()
	{
		if(userDatabase.database.size() == 0) { makeUserLookAtThisMessageLoop("The user database is empty\nNo users to view"); return;}
		System.out.println("Please choose the account to view");
		String[] allItems = new String[userDatabase.database.size()];
		for(int i = 0; i < userDatabase.database.size(); i++)
		{
			allItems[i] = userDatabase.database.get(i).getName();
		}
		int userChoice = getUserChoice(allItems, allItems.length);
		userDatabase.database.get(userChoice-1).display();
		makeUserLookAtThisMessageLoop("");
	}
	public static void flagUser()
	{
		if(userDatabase.database.size() == 0) { makeUserLookAtThisMessageLoop("The user database is empty\nNo users to flag"); return;}
		System.out.println("Please choose the account to flag");
		String[] allItems = new String[userDatabase.database.size()];
		for(int i = 0; i < userDatabase.database.size(); i++)
		{
			allItems[i] = userDatabase.database.get(i).getName();
		}
		int userChoice = getUserChoice(allItems, allItems.length);
		userDatabase.database.get(userChoice-1).display();
		userDatabase.database.get(userChoice-1).setFlagged(true);
		makeUserLookAtThisMessageLoop(userDatabase.database.get(userChoice-1).getName() + " has been flagged");
	}
	//Helper Methods ----------------------------------------------------------------------------
	//these are static so feel free to use these where ever they would help!
	
	/* Returns date in String in this format: yyyy/dd/MM HH:mm:ss
	 * @param none
	 * @returns the current date in this format: yyyy/dd/MM HH:mm:ss
	 */
	public static String getDate()
	{
		DateTime dateTime = new DateTime();
		String date = dateTime.getYear() + "/" + dateTime.getMonthOfYear() + "/" + dateTime.getDayOfMonth();
		return date;
	}
	public static String getDueDate(baseItem thisItem)
	{
		DateTime dateTime = new DateTime();
	    String DueDate = "";

	    if(thisItem.getType().equalsIgnoreCase("itemDVD"))
	    {
	    	dateTime = dateTime.plusDays(7);
	    	DueDate = (dateTime.getYear() + "/" + dateTime.getMonthOfYear() + "/" + dateTime.getDayOfMonth());
	    }
	    else 
	    {
	    	dateTime = dateTime.plusDays(30);
	    	DueDate = (dateTime.getYear() + "/" + dateTime.getMonthOfYear() + "/" + dateTime.getDayOfMonth());
	    }
	    //System.out.println(dateTime);
	    return DueDate;
	}
	/* Gives the current name of the library system in same format.
	 * @param none
	 * @returns the current name of the library system with upper and lower brackets
	 */
	public static String getTitle()
	{
		String title = "---------------------\nUntitled Library System\n---------------------";
		return title;
	}
	/* Prints a line of the same size each time.
	 * @param none
	 * @returns none
	 */
	public static String getLine()
	{
		String line = "\n---------------------";
		return line;
	}
	/* displays a set of choices in a easy to read format 
	 * @param an array of strings (choices for the user to pick from)
	 * @returns the users integer choice
	 */
	public static String choiceSetup(String[] choices)
	{
		String choiceDialogue = "Please select a choice\n\n";
		for(int i = 0; i < choices.length; i++)
		{
			choiceDialogue =  choiceDialogue + (i+1) + ". " + choices[i] + "\n";
		}
		return choiceDialogue;
	}
	public static String choiceSetupAndPrintSpecial(String[] choices, String[] special)
	{
		String choiceDialogue = "Please select a choice\n\n";
		for(int i = 0; i < choices.length; i++)
		{
			choiceDialogue =  choiceDialogue + (i+1) + ". " + choices[i] + "\n   " + special[i] + "\n";
		}
		return choiceDialogue;
	}
	
	public static void changeToCurrentUser(baseUser thisUser)
	{
		currentUser = thisUser;
	}
	/* Checks if the user is logged in. 
	 * @param none
	 * @returns true if user is logged in, false if otherwise
	 */
	public static boolean isUserLoggedIn()
	{
		if(currentUser == null)
			return false;
		else
			return true;
	}
	/* Prevents an action from being performed if user is not logged in
	 * @param none
	 * @returns true if user is logged in, false if otherwise
	 */
	public static boolean isUserLoggedInLoop()
	{
		if( isUserLoggedIn() == false ) 
		{
			makeUserLookAtThisMessageLoop("Cannot perform this action without being logged in.");
			
		  return false;
		}
		return true;
	}
	/* Forces a user to acknowledge that they have read a message 
	 * @param a message to display to the user
	 * @returns none
	 */
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
