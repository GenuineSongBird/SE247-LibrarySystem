/*
 * This class inherits from the baseUser class and is the base user
 * with standard checkout length as their behavior
 *
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


public class userPatron extends baseUser {
	
	public userPatron(String name, int age, String phoneNum,
			String address, String email, int accNum, double feeTotal,
			String password) {
		super(name, age, phoneNum, address, email, accNum, feeTotal, password);
		CheckoutLimitBehavior = new standardLimit();
		
	}
	
	public void display() {
		System.out.println(this.name+" is a patron");
		super.display();
	}
	
}
