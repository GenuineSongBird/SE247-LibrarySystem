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
	
	/**
	 * Constructor for userPatron, calls super for baseUser class
	 * Calls Standard Limit
	 * @param name
	 * @param age
	 * @param phoneNum
	 * @param address
	 * @param email
	 * @param accNum
	 * @param feeTotal
	 * @param password
	 */
	public userPatron(String name, int age, String phoneNum,
			String address, String email, int accNum, double feeTotal,
			String password) {
		super(name, age, phoneNum, address, email, accNum, feeTotal, password);
		CheckoutLimitBehavior = new standardLimit();
		
	}
	
	/**
	 * Displays user information from parent class
	 * States User type when displaying user information
	 */
	public void display() {
		System.out.println(this.getName()+" is a patron");
		super.display();
	}
	
	/**
	 * sets the account type that is called by startPage
	 */
	public String getType()
	{
		return "Patron";
	}
}
