/*
 * This class inherits from baseUser and is a librarian user class
 * it has access to different commands than a base user but base checkout behavior
 *
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


public class userLibrarian extends baseUser{
	
	public userLibrarian(String name, int age, String phoneNum,
			String address, String email, int accNum, double feeTotal,
			String password) {
		super(name, age, phoneNum, address, email, accNum, feeTotal, password);
		CheckoutLimitBehavior = new standardLimit();
		
	}
	
	public void display() {
		System.out.println(this.getName()+" is a librarian");
		super.display();
	}
	public String getType()
	{
		return "Librarian";
	}
	
}
