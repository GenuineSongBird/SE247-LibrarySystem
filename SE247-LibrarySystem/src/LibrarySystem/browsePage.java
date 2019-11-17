/*
 * This class allows the user to browse through the item database through a variety of search methods.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Tyson Medlin
 * Date: 10/24/2019
 */
package LibrarySystem;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class browsePage {
	public browsePage() {}
	/* Displays to the user the choices they are offered for browsing items in this system.
	 * @param none
	 * @returns none
	 */
	public void browse()
	{
		int choice = 0;
		startPage.getLine();
		String[] choices = {"View new releases", "Search by title","Search by rating","Search by year","Search by genre","Search by description","Request an item to be added","Return to home"};
		choice = startPage.getUserChoice(choices, choices.length);
		getResponseForChoice(choice);
	}
	/* Gets the appropriate response matching the user's desired response.
	 * @param The users choice of response.
	 * @returns none
	 */
	private void getResponseForChoice(int usersChoice)
	{
		Scanner key = new Scanner(System.in);
		switch(usersChoice) {
			case 1:
				viewNewReleases();
				return;
			case 2:
				searchByTitle(gatherSearchByInfo( "title" ));
				return;
			case 3:
				searchByRating(gatherSearchByInfo( "rating" ));
				return;
			case 4:
				searchByYear(gatherSearchByInfo( "year" ));
				return;
			case 5:
				searchByGenre(gatherSearchByInfo( "genre" ));
				return;
			case 6:
				searchByDescription(gatherSearchByInfo( "description" ));
				return;
			case 7:
				addToRequestList();
				return;
		}
		
	}
	/* Searches through the item database for the users desired items.
	 * @param The string information the user would like to search the item database with.
	 * @returns the string items in the item database matching the users desires.
	 */
	private String gatherSearchByInfo( String thisInfo )
	{
		Scanner key = new Scanner(System.in);
		String gatheredInfo = "";
		System.out.println("Please enter the " + thisInfo + " you would like to search with\n\n" +thisInfo + ":");
		gatheredInfo = key.nextLine();
		if(thisInfo.equalsIgnoreCase("rating") || thisInfo.equalsIgnoreCase("year"))
			gatheredInfo = ensureInfoCorrectType(gatheredInfo, thisInfo);
		return gatheredInfo;
	}
	/* If the user searches through the item database anything number related, ensures the user only uses numbers to search with.
	 * @param The string information the user would like to search the item database with.
	 * @returns the string items in the item database matching the users desires.
	 */
	private String ensureInfoCorrectType(String gatheredInfo, String thisInfo)
	{
		Scanner key = new Scanner(System.in);
		while(( thisInfo.equalsIgnoreCase("year")) && gatheredInfo.matches("-?\\d+") == false)
		{
			System.out.println("The "+thisInfo + " to search by must be a number\nPlease enter the " + thisInfo + " you would like to search with\n\n" +thisInfo + ":");
			gatheredInfo = key.nextLine();
		}
		while((thisInfo.equalsIgnoreCase("rating")) && ((gatheredInfo.matches("[0-5].[0-9][0-9]") == false && gatheredInfo.matches("[0-5].[0-9]") == false && gatheredInfo.matches("[0-5]") == false)))
		{
			System.out.println("The "+thisInfo + " to search by must be a number in this range ( 0 - 5 )\nPlease enter the " + thisInfo + " you would like to search with\n\n" +thisInfo + ":");
			gatheredInfo = key.nextLine();
		}
		return gatheredInfo;
	}
	/* Displays to the user the items in item database labeled new releases
	 * @param none
	 * @returns none
	 */
	public void viewNewReleases()
	{	
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).isNew() == true)
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No new releases found");
			return;
		}
		String[] resultsTitle = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
		}
		choice = startPage.getUserChoice(resultsTitle, results.size());
		itemDetailPage itemDetailPage = new itemDetailPage();
		itemDetailPage.getDetails(results.get(choice - 1));
		
	}
	/* Searches through the item database for results matching the users entered title, displays appropriate results.
	 * @param String of the title the user would like to search with
	 * @returns none
	 */
	public String searchByTitle( String title )
	{
		itemDatabase.getInstance();
		
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getTitle().toLowerCase().contains(title.toLowerCase()))
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No results found with title of " + title);
			return "";
		}
		String[] resultsTitle = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
		}
		choice = startPage.getUserChoice(resultsTitle, results.size());
		itemDetailPage itemDetailPage = new itemDetailPage();
		itemDetailPage.getDetails(results.get(choice - 1));
		return results.get(choice - 1).toString();
	}
	/* Searches through the item database for results matching the users entered rating, displays appropriate results.
	 * @param String of the rating the user would like to search with
	 * @returns none
	 */
	public String searchByRating( String rating )
	{
		itemDatabase.getInstance();
		
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getRating() == Double.valueOf(rating))
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No results found with rating of " + rating);
			return "";
		}
		String[] resultsTitle = new String[results.size()];
		String[] resultsRating = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
			resultsRating[i] = String.valueOf(results.get(i).getRating());
		}
		choice = startPage.getUserChoiceAndPrintSpecial(resultsTitle, results.size(), resultsRating);
		itemDetailPage itemDetailPage = new itemDetailPage();
		itemDetailPage.getDetails(results.get(choice-1));
		return results.get(choice-1).toString();
	}
	/* Searches through the item database for results matching the users entered year of release, displays appropriate results.
	 * @param String of the year the user would like to search with
	 * @returns none
	 */
	public String searchByYear( String year )
	{
		itemDatabase.getInstance();
		
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getReleaseDate() == Double.valueOf(year))
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No results found with release date of " + year);
			return "";
		}
		String[] resultsTitle = new String[results.size()];
		String[] resultsYear = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
			resultsYear[i] = String.valueOf(results.get(i).getReleaseDate());
		}
		choice = startPage.getUserChoiceAndPrintSpecial(resultsTitle, results.size(), resultsYear);
		itemDetailPage itemDetailPage = new itemDetailPage();
		itemDetailPage.getDetails(results.get(choice-1));
		return results.get(choice-1).toString();
	}
	/* Searches through the item database for results matching the users entered genre, displays appropriate results.
	 * @param String of the genre the user would like to search with
	 * @returns none
	 */
	public String searchByGenre( String genre )
	{
		itemDatabase.getInstance();
		
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getGenre().toLowerCase().contains(genre.toLowerCase()))
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No results found with genre of " + genre);
			return "";
		}
		String[] resultsTitle = new String[results.size()];
		String[] resultsGenre = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
			resultsGenre[i] = String.valueOf(results.get(i).getGenre());
		}
		choice = startPage.getUserChoiceAndPrintSpecial(resultsTitle, results.size(), resultsGenre);
		itemDetailPage itemDetailPage = new itemDetailPage();
		itemDetailPage.getDetails(results.get(choice-1));
		return results.get(choice-1).toString();
	}
	/* Searches through the item database for results matching the users entered description, displays appropriate results. Works through comparison of description text.
	 * @param String of the description the user would like to search with
	 * @returns none
	 */
	public String searchByDescription( String Description )
	{
		itemDatabase.getInstance();
		
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getDescription().toLowerCase().contains(Description.toLowerCase()))
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No results found with a description containing " + Description);
			return "";
		}
		String[] resultsTitle = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
		}
		choice = startPage.getUserChoice(resultsTitle, results.size());
		itemDetailPage itemDetailPage = new itemDetailPage();
		itemDetailPage.getDetails(results.get(choice-1));
		return results.get(choice-1).toString();
	}
	/* Allows the user to add a recommendation of their choice to a saved list of recommendations
	 * @param none
	 * @returns none
	 */
	public void addToRequestList() 
	{
		if( startPage.isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{  return; }
		Scanner key = new Scanner(System.in);
		System.out.println("Please enter the title and year of the item you would like to add\n\nTitle:");
		String title = key.nextLine();
		System.out.println("\nYear:");
		String year = key.nextLine();
		ensureInfoCorrectType(year, "year");
		PrintWriter writer;
		try {
			writer = new PrintWriter("ItemRequests.txt", "UTF-8");
			writer.println(startPage.currentUser.getName() + " wants...");
			writer.println(title);
			writer.println(year);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		startPage.makeUserLookAtThisMessageLoop("Your request has been added for consideration.\nThank you");
	}
}
