/*
 * This class inherits from checkoutLimitBehavior and is called by user classes
 * to define the classes checkoutLimit, extendedLimit is implemented by Patron, Admin, Librarian
 *
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


public class standardLimit implements checkoutLimitBehavior{
	
	/**
	 * Returns the checkout standard for the user
	 * 10 is the standard limit defined by the library
	 */
	public int checkoutLimit() {
		return 10;
	}
	
}
