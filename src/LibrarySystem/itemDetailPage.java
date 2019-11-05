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
		if(startPage.currentUser.getFeeTotal() >= 100)
		{
			startPage.makeUserLookAtThisMessageLoop("The unpaid fees for " + startPage.currentUser.getName() + " are above the library limit of $100\n Please pay your fees to checkout additional books");
			return;
		}
		if(startPage.currentUser.checkedOutList.size() >= startPage.currentUser.CheckoutLimitBehavior.checkoutLimit())
		{
			startPage.makeUserLookAtThisMessageLoop("Cannot checkout\nThe checkout limit for " + startPage.currentUser.getName() + " is " + startPage.currentUser.CheckoutLimitBehavior.checkoutLimit() + " items at a time.\nPlease return items to continue checking out");
			return;
		}
		if(thisItem.getHolds().isEmpty() == false)
		{
			startPage.makeUserLookAtThisMessageLoop("Cannot checkout\n" + thisItem.getTitle() + " is already on hold for another user.");
			return;
		}
		else
		{
			startPage.getLine();
			itemDatabase.database.remove(thisItem);
			thisItem.setNumCopies(thisItem.getNumCopies() - 1);
			startPage.makeUserLookAtThisMessageLoop(thisItem.toString() + "\n\nSuccessfully checkedout " + thisItem.getTitle() + "!");
			itemDatabase.database.add(thisItem);
			thisItem.setNumCopies(1);
			thisItem.setDueDate(startPage.getDueDate(thisItem));
			startPage.currentUser.addToCheckedOutList(thisItem);
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
	public void leaveComments(baseItem thisItem)
	{
		if( startPage.isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{  return; }
		Scanner key = new Scanner(System.in);
		System.out.println("Please enter your comment for " + thisItem.getTitle());
		String comment = key.nextLine();
		itemDatabase.database.remove(thisItem);
		thisItem.getRatingComments().add(startPage.currentUser.getName() + " says: \"" + comment + "\"");
		itemDatabase.database.add(thisItem);
		startPage.makeUserLookAtThisMessageLoop("Successfully added " + startPage.currentUser.getName() + "'s comment to " + thisItem.getTitle() + "!");
		return;
	}
	public void leaveRating(baseItem thisItem)
	{
		if( startPage.isUserLoggedInLoop() == false) //If user is not logged in, make the acknowledge that, then return to home.
		{  return; }
		Scanner key = new Scanner(System.in);
		System.out.println("Please enter your rating for " + thisItem.getTitle());
		String rating = key.nextLine();
		while(rating.matches("-?\\d+") == false || rating.matches("-?\\d+") == true && Integer.valueOf(rating) < 0 || rating.matches("-?\\d+") == true && Integer.valueOf(rating) > 5) 
		{ 
			System.out.println("Rating must be a number between 0 and 5"); 
			System.out.println("Please enter your rating for " + thisItem.getTitle());
			rating = key.nextLine(); 
			}
		itemDatabase.database.remove(thisItem);
		thisItem.addRatingAmount();
		double ratingDouble = (Double.valueOf(thisItem.getRating()) + Double.valueOf(rating))/thisItem.getRatingAmount();
		thisItem.setRating(ratingDouble);
		itemDatabase.database.add(thisItem);
		startPage.makeUserLookAtThisMessageLoop("Successfully added " + startPage.currentUser.getName() + "'s rating to " + thisItem.getTitle() + "!");
		return;
	}
	public void viewComments(baseItem thisItem)
	{
		if(thisItem.getRatingComments().isEmpty() )
		{
			startPage.makeUserLookAtThisMessageLoop("No comments available for " + thisItem.getTitle());
			return;
		}
		else
		{
			System.out.println("Rating: " + thisItem.getRating() + "\n");
			for(int i = 0; i < thisItem.getRatingComments().size(); i++)
				System.out.println(thisItem.getRatingComments().get(i).toString());
			startPage.makeUserLookAtThisMessageLoop("");
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
		String[] choices = {"Checkout", "Put on hold","View hold list","Add to wish list","View comments", "Leave a comment","Leave a rating","Return to home menu"};
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
			case 5:
				viewComments(thisItem);
				return;
			case 6:
				leaveComments(thisItem);
				return;
			case 7:
				leaveRating(thisItem);
				return;
		}
	}
}
