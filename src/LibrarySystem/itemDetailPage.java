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
	public void viewHoldList(baseItem thisItem)
	{
		if(thisItem.getHolds().isEmpty())
		{
			System.out.println(thisItem.getTitle() + " has no holds currently.");
		}
		else
			System.out.println(thisItem.getHolds().peek().getName());
	}
	public void addToWishList(baseItem thisItem)
	{
		startPage.currentUser.wishList.add(thisItem);
		startPage.makeUserLookAtThisMessageLoop("Successfully added " + thisItem.getTitle() + " to " + startPage.currentUser.getName() + "'s wishlist!");
	}
	public  void getDetails(baseItem thisItem)
	{
		int choice;
		startPage.getLine();
		System.out.println(thisItem.toString());
		if( startPage.isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{  return; }
		String[] choices = {"Checkout", "Put on hold","View hold list","Add to wish list", "Return to home menu"};
		choice = startPage.getUserChoice(choices, choices.length);
		getResponseForChoice(choice, thisItem);
	}
	public  void getDetailsReturn(baseItem thisItem)
	{
		startPage.getLine();
		itemDatabase.database.remove(thisItem);
		thisItem.setNumCopies(thisItem.getNumCopies() + 1);
		startPage.makeUserLookAtThisMessageLoop(thisItem.toString() + "\n\nSuccessfully returned " + thisItem.getTitle() + "!");
		itemDatabase.database.add(thisItem);
	}
	private  void getResponseForChoice(int usersChoice, baseItem thisItem)
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
				viewHoldList(thisItem);
				return;
			case 4:
				addToWishList(thisItem);
				return;
		}
	}
}
