package LibrarySystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class loginPage {
		
	public static void main(String[] args) {
		System.out.println(getTitle());
		System.out.println("Untitled Version 0.1 Date: " + getDate());
		System.out.println(getLine());
		
		
	}
	private void login()
	{
		
	}
	private void logout()
	{
		
	}
	private void browse()
	{
		
	}
	private void viewFee()
	{
		
	}
	private void payFee()
	{
		
	}
	//public static user getCurrentUser()
	//{
		
	//}
	private void viewHolds()
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
	private void viewWishList()
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
			choiceDialogue = i + ". " + choiceDialogue + choices[i] + "\n";
		}
		return choiceDialogue;
	}
}