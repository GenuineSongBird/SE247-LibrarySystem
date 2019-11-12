package LibrarySystem;
/*
 * Offers higher responsibility options for the user to choose, if the user is of librarian type type.
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Tyson Medlin
 * Date: 10/24/2019
 */
public class librarianControls {
	/* Returns the librarian-exclusive choice set for the home page upon.
	 * @param none
	 * @returns String array of the librarian-exclusive choices of action.
	 */
	public static String[] librarianChoicesArray()
	{
		String[] choices = {"Add a user", "Remove a User","Add an item","View a user account's info","Flag a user account"};
		return choices;
	}
}
