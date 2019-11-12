/*
 * This class inherits from baseUser and is an admin user class
 * it has different properties an access to different commands than
 * a base user
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


public class userAdmin extends baseUser {
	
	/**
	 * Constructor for userAdmin, calls super for baseUser class
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
	public userAdmin(String name, int age, String phoneNum,
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
		System.out.println(this.getName()+" is an admin");
		super.display();
	}
	
	/**
	 * sets the account type that is called by startPage
	 */
	public String getType()
	{
		return "Admin";
	}
	
}
