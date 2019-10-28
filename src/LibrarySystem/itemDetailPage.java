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
		//item.displayInfo
		//system.out.println("/n");
		int choice = 0;
		startPage.getLine();
		String[] choices = {"Checkout", "Put on hold","View hold list","Add to wish list"};
		choice = startPage.getUserChoice(choices, choices.length);
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
}
