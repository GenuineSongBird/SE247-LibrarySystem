package LibrarySystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class startPage {
		
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		
		//get if user is signed in
		
		//The home screen
		int usersChoice = getUserChoice();
		getResponseForChoice(usersChoice);
		
	}
	private static int getUserChoice()
	{
		int userChoice = 0;
		int availableChoices = 1;
		Scanner key = new Scanner(System.in);
		while (userChoice > availableChoices || userChoice < 1){
			System.out.println(getTitle());
			System.out.println("Untitled Version 0.1 Date: " + getDate());
			System.out.println(getLine());
			String[] choices = {"Login or create account","Logout","Browse available items","View fees","Pay fees","Return item","View holds","View wishlist"};
			System.out.println(choiceSetup(choices));
			userChoice = key.nextInt();
			availableChoices = choices.length;
		}
		return userChoice;
	}
	private static void getResponseForChoice(int usersChoice)
	{
		switch(usersChoice) {
			case 1:
				login();
			case 2:
				logout();
			case 3:
				browse();
			case 4:
				viewFee();
			case 5:
				payFee();
			case 6:
				returnItem();
			case 7:
				viewHolds();
			case 8:
				viewWishlist();
		}
		
	}
	private static void login()
	{
		System.out.println("test");
	}
	private static void logout()
	{
		
	}
	private static void browse()
	{
		
	}
	private static void viewFee()
	{
		
	}
	private static void returnItem()
	{
		
	}
	private static void payFee()
	{
		
	}
	//public static user getCurrentUser()
	//{
		
	//}
	private static void viewHolds()
	{
		
	}
	//Returns date in String in this format: yyyy/dd/MM HH:mm:ss
	public static String getDate()
	{
		String date = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM HH:mm:ss");
		Date Date = new Date();
		date = (String)dateFormat.format(Date);
		return date;
	}
	private static void viewWishlist()
	{
		
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
}