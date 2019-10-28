/*
 * This class allows the user to browse through the item database through a variety of search methods.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: 
 * Date: 10/24/2019
 */
package LibrarySystem;
import java.util.Scanner;

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
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
		//itemDatabase.getInstance
		
		//idea 2:
		//int choice = 0;
		//item[] choices
		//if(itemDatabase.getIterator.getTitle(title).equalsIgnoreCase(title)) 
			//choices[] = choices[].add(thisItem)
			//choice = startPage.getUserChoice(choices, choices.length);
	}
	public void searchByRating( String rating )
	{
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
	}
	public void searchByYear( String year )
	{
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
	}
	public void searchByGenre( String genre )
	{
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
	}
	public void searchByDescription( String Description )
	{
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
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
