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
		
	}
	
	public double addToFeeTotal(double fee) {
		return this.feeTotal;
	}
	
	public void setCheckoutLimit(checkoutLimitBehavior clb) {
		
	}
	
	public void display() {
		
	}
	
	public double viewFees() {
		return this.feeTotal;
	}
	
}
