/*
 * This class allows the user to browse through the item database through a variety of search methods.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: 
 * Date: 10/24/2019
 */
package LibrarySystem;
import java.util.Scanner;
import java.util.LinkedList;

public class browsePage {
	public browsePage()
	{
		int choice = 0;
		startPage.getLine();
		String[] choices = {"View new releases", "Search by title","Search by rating","Search by year","Search by genre","Search by description","Request an item to be added","Return to home"};
		choice = startPage.getUserChoice(choices, choices.length);
		getResponseForChoice(choice);
	}
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
	public void viewNewReleases()
	{
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
		//Itemdatabase.searchByTime(startPage.getTwoWeeksFromNow())
	}
	public void searchByTitle( String title )
	{
		//startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
		itemDatabase.getInstance();
		
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getTitle().equalsIgnoreCase(title))
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No results found with title of " + title);
		}
		String[] resultsTitle = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
		}
		choice = startPage.getUserChoice(resultsTitle, results.size());
		itemDetailPage.getDetails(results.get(choice));
	}
	public void searchByRating( String rating )
	{
		//startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
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
		}
		String[] resultsTitle = new String[results.size()];
		String[] resultsRating = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
			resultsRating[i] = String.valueOf(results.get(i).getRating());
		}
		choice = startPage.getUserChoiceAndPrintSpecial(resultsTitle, results.size(), resultsRating);
		itemDetailPage.getDetails(results.get(choice));


	}
	public void searchByYear( String year )
	{
		//startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
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
		}
		String[] resultsTitle = new String[results.size()];
		String[] resultsYear = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
			resultsYear[i] = String.valueOf(results.get(i).getReleaseDate());
		}
		choice = startPage.getUserChoiceAndPrintSpecial(resultsTitle, results.size(), resultsYear);
		itemDetailPage.getDetails(results.get(choice));
	}
	public void searchByGenre( String genre )
	{
		//startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
		itemDatabase.getInstance();
		
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getGenre().equalsIgnoreCase(genre))
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No results found with genre of " + genre);
		}
		String[] resultsTitle = new String[results.size()];
		String[] resultsGenre = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
			resultsGenre[i] = String.valueOf(results.get(i).getGenre());
		}
		choice = startPage.getUserChoiceAndPrintSpecial(resultsTitle, results.size(), resultsGenre);
		itemDetailPage.getDetails(results.get(choice));
	}
	public void searchByDescription( String Description )
	{
		//startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
		itemDatabase.getInstance();
		
		int choice = 0;
		LinkedList<baseItem> results = new LinkedList<baseItem>();
		for(int i = 0; i < itemDatabase.database.size(); i++)
		{
			if(itemDatabase.database.get(i).getDescription().contains(Description))
			{
				results.add(itemDatabase.database.get(i));
			}
		}
		if(results.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("No results found with a description containing " + Description);
		}
		String[] resultsTitle = new String[results.size()];
		for(int i = 0; i < results.size(); i++) 
		{ 
			resultsTitle[i] = results.get(i).getTitle();
		}
		choice = startPage.getUserChoice(resultsTitle, results.size());
		itemDetailPage.getDetails(results.get(choice));
	}
	public void addToRequestList()
	{
		Scanner key = new Scanner(System.in);
		System.out.println("Please enter the title and year of the item you would like to add\n\nTitle:");
		String title = key.nextLine();
		System.out.println("\nYear:");
		String year = key.nextLine();
		ensureInfoCorrectType(year, "year");
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
	}
	
}
