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
	public void checkout(baseItem thisItem)
	{
		if( startPage.isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{  return; }
		if(thisItem.getNumCopies() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("There are no available copies of " + thisItem.getTitle() + " currently\nYou can put this item on hold for when a copy is available");
			return;
		}
		else
		{
			startPage.getLine();
			itemDatabase.database.remove(thisItem);
			thisItem.setNumCopies(thisItem.getNumCopies() - 1);
			startPage.makeUserLookAtThisMessageLoop(thisItem.toString() + "\n\nSuccessfully checkedout " + thisItem.getTitle() + "!");
			itemDatabase.database.add(thisItem);
		}
		
	}
	public void putOnHold(baseItem thisItem)
	{
		if( startPage.isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{  return; }
		if((thisItem.getNumCopies() == 0) == false)
		{
			startPage.makeUserLookAtThisMessageLoop("There are  available copies of " + thisItem.getTitle() + " currently\nYou can checkout this Item");
			return;
		}
		else
		{
			startPage.getLine();
			itemDatabase.database.remove(thisItem);
			thisItem.setHolds(startPage.currentUser);
			startPage.makeUserLookAtThisMessageLoop("Successfully put " + startPage.currentUser.getName() + " on hold queue for " + thisItem.getTitle() + "!");
			itemDatabase.database.add(thisItem);
			return;
		}
	}
	public void viewHoldList(baseItem thisItem)
	{
		if(thisItem.getHolds().isEmpty())
		{
			startPage.makeUserLookAtThisMessageLoop(thisItem.getTitle() + " has no holds currently.");
		}
		else
			startPage.makeUserLookAtThisMessageLoop("Next in the hold queue for " + thisItem.getTitle() + " is " + thisItem.getHolds().peek().getName());
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
				checkout(thisItem);
				return;
			case 2:
				putOnHold(thisItem);
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
