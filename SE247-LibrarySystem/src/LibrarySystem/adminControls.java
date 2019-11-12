/*
 * Offers higher responsibility options for the user to choose, if the user is of admin type.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Tyson Medlin
 * Date: 10/24/2019
 */
package LibrarySystem;

public class adminControls {
	/* Returns the admin-exclusive choice set for the home page upon.
	 * @param none
	 * @returns String array of the admin-exclusive choices of action.
	 */
	public static String[] adminChoicesArray()
	{
		String[] choices = {"Add a user", "Remove a User","Add an item","View a user account's info","Flag a user account","Change a user account's type"};
		return choices;
	}
}
