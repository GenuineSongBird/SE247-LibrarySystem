/*
 * This class should display the item info in detail and offer specific options for this specific item
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: 
 * Date: 10/24/2019
 */
package LibrarySystem;
import java.util.Scanner;

public class itemDetailPage {
	public itemDetailPage() //this is the constructor, display the info here.
	{

	}
	public void checkout()
	{
		
	}
	public void putOnHold()
	{
		
	}
	public void viewHoldList()
	{
		//item.displayHoldList
	}
	public void addToWishList()
	{
		//user.addToWishList(item);
	}
	public  void getDetails(baseItem thisItem)
	{
		int choice;
		startPage.getLine();
		System.out.println(thisItem.toString());
		String[] choices = {"Checkout", "Put on hold","View hold list","Add to wish list", "Return to home menu"};
		choice = startPage.getUserChoice(choices, choices.length);
		getResponseForChoice(choice);
	}
	public  void getDetailsReturn(baseItem thisItem)
	{
		startPage.getLine();
		startPage.makeUserLookAtThisMessageLoop(thisItem.toString() + "\n\nSuccessfully returned " + thisItem.getTitle() + "!");
		itemDatabase.database.remove(thisItem);
		thisItem.setNumCopies(thisItem.getNumCopies() + 1);
		itemDatabase.database.add(thisItem);
	}
	private  void getResponseForChoice(int usersChoice)
	{
		Scanner key = new Scanner(System.in);
		switch(usersChoice) {
			case 1:
				checkout();
				return;
			case 2:
				putOnHold();
				return;
			case 3:
				viewHoldList();
				return;
			case 4:
				addToWishList();
				return;
		}
	}
}
