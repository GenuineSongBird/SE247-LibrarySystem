/*
 * This class inherits from checkoutLimitBehavior and is called by user classes
 * to define the classes checkoutLimit, extendedLimit is implemented by userChild
 *
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


public class restrictedLimit implements checkoutLimitBehavior{
	
	/**
	 * Returns the checkout standard for the user
	 * 3 is the restricted limit defined by the library
	 */
	public int checkoutLimit() {
		return 3;
	}
}
