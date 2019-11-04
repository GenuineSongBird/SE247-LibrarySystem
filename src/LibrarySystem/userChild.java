/*
 * This class inherits from baseUser and is a child user class
 * it has base user properties but has a limited checkoutBehavior
 *
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


public class userChild extends baseUser {
	
	public userChild(String name, int age, String phoneNum,
			String address, String email, int accNum, double feeTotal,
			String password) {
		super(name, age, phoneNum, address, email, accNum, feeTotal, password);
		CheckoutLimitBehavior = new restrictedLimit();
		
	}
	
	public void display() {
		System.out.println(this.getName+" is a child");
		super.display();
	}
	public String getType()
	{
		return "Child";
	}
}
