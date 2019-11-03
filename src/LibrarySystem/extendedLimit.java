/*
 * This class inherits from checkoutLimitBehavior and is called by user classes
 * to define the classes checkoutLimit, extendedLimit is implemented by Teacher
 *
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


public class extendedLimit implements checkoutLimitBehavior{
	
public int checkoutLimit() {
		return 30;
	}
	
}
