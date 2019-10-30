/*
 * This class is the base user class which all user objects inherit from
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


import java.util.ArrayList;

public abstract class baseUser {
	protected String name;
	protected int age;
	protected String phoneNum;
	protected String address;
	protected String email;
	protected int accNum;
	protected double feeTotal;
	protected ArrayList<Item> wishlist;
	protected String password;
	checkoutLimitBehavior CheckoutLimitBehavior;
	
	/**
	 * Base constructor for Library Users
	 * 
	 * @param aName
	 * @param anAge
	 * @param aPhoneNum
	 * @param anAddress
	 * @param anEmail
	 * @param anAccNum
	 * @param aFeeTotal
	 * @param aPassword
	 */
	public baseUser(String aName, int anAge, String aPhoneNum,
			String anAddress, String anEmail, int anAccNum, double aFeeTotal,
			String aPassword)	{
		this.name = aName;
		this.age = anAge;
		this.phoneNum = aPhoneNum;
		this.address = anAddress;
		this.email = anEmail;
		this.accNum = anAccNum;
		this.feeTotal = aFeeTotal;
		this.password = aPassword;
	}
	
	public void checkoutLimit() {
		CheckoutLimitBehavior.checkoutLimit();
	}
	
	public double addToFeeTotal(double fee) {
		this.feeTotal += fee;
		return this.feeTotal;
	}
	
	/**
	 * Sets the Checkout Limit Behavior equal to inputed behavior
	 * @param clb
	 */
	public void setCheckoutLimit(checkoutLimitBehavior clb) {
		CheckoutLimitBehavior = clb;
	}
	
	/**
	 * Displays user information aside from password
	 */
	public void display() {
		System.out.println("Name:			  "+ this.name +
					"\nAge:			  "+ this.age +
					"\nPhone Number:   "+ this.phoneNum +
					"\nAddress		  "+ this.address +
					"\nEmail:		  "+ this.email +
					"\nAccount Number: "+ this.accNum +
					"\nFee Total:	  "+ this.feeTotal);
	}
	
	public double viewFees() {
		return this.feeTotal;
	}
	
}
