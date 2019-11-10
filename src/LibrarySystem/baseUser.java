/*
 * This class is the base user class which all user objects inherit from
 * 
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


import java.util.LinkedList;

public abstract class baseUser {
	
	/**
	 * Attributes associated with all users
	 */
	private String name;
	private int age;
	private String phoneNum;
	private String address;
	private String email;
	private int accNum;
	private double feeTotal;
	LinkedList<baseItem> wishList = new LinkedList<baseItem>();
	LinkedList<baseItem> checkedOutList = new LinkedList<baseItem>();
	private String password;
	private boolean flagged = false;
	
	checkoutLimitBehavior CheckoutLimitBehavior;

	private boolean feeTotalExceeded = false;
	
	
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
	
	/**
	 * Strategy Design Pattern method 
	 */
	public void checkoutLimit() {
		CheckoutLimitBehavior.checkoutLimit();
	}
	
	/**
	 * Sets the Checkout Limit Behavior equal to inputed behavior
	 * @param clb
	 */
	public void setCheckoutLimit(checkoutLimitBehavior clb) {
		CheckoutLimitBehavior = clb;
	}
	
	/**
	 * Adds to users feeTotal
	 * Checks if fee total has exceeded
	 * @param fee
	 * @return
	 */
	public double addToFeeTotal(double fee) {
		if(this.feeTotalExceeded == true)
		{
			//TO-DO
			System.out.println("");
			return this.feeTotal;
		}
		
		this.feeTotal += fee;
		if(this.feeTotal >= 100)
		{
			this.feeTotalExceeded = true;
			System.out.println("Fee Total has now exceeded the limit");
		}
		if(this.feeTotal >= 100) { this.feeTotal = 100;}
		return this.feeTotal;
	}
	
	/**
	 * Fee totals may not exceed 100
	 * Returns account Total fee accumulated
	 * @return
	 */
	public double viewFees() {
		if(feeTotal >= 100) {
			feeTotal = 100;
		}
		return this.feeTotal;
	}
	
	/**
	 * Called by startPage when user is paying fees
	 * @param feeTotal
	 */
	public void setFeeTotal(double feeTotal) {
		this.feeTotal = feeTotal;
		if(feeTotal >= 100) { 
			feeTotal = 100;
			}
	}
	
	/**
	 * Public Accessors for class attributes
	 * @return
	 */
	//Name
	public String getName() {
		return name;
	}
	//Age
	public int getAge() {
		return age;
	}
	//Phone Number
	public String getPhoneNum() {
		return phoneNum;
	}
	//Address
	public String getAddress() {
		return address;
	}
	//Email
	public String getEmail() {
		return email;
	}
	//Account Number
	public int getAccNum() {
		return accNum;
	}
	//Account Password
	public String getPassword() {
		return password;
	}
	//Fee Total
	public double getFeeTotal() {
		if(feeTotal >= 100) { 
			feeTotal = 100;
		}
		return feeTotal;
		
	}
	
	/**
	 * Takes in item to add to users personal wishlist
	 * @param thisItem
	 */
	public void addToWishList(baseItem thisItem)
	{
		wishList.add(thisItem);
	}
	
	/**
	 * Allows for viewers wish list to be viewed
	 * Prints message for no items, for loop for wishlist to print
	 */
	public void viewWishList()
	{
		if(wishList.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("Currently no items in wishlist for " + startPage.currentUser.getName());
			return;
		}
		for(int i = 0; i < wishList.size();i++)
		{
			System.out.println(wishList.get(i).getTitle());
			
		}startPage.makeUserLookAtThisMessageLoop("");
	}
	
	/**
	 * Takes in an item to add to user check out list
	 * @param thisItem
	 */
	public void addToCheckedOutList(baseItem thisItem)
	{
		checkedOutList.add(thisItem);
	}
	
	/**
	 * Prints out Users Personal checked out list as well as due dates
	 * takes in method from startPage, to print no items checked out
	 */
	public void viewCheckedOutList()
	{
		if(checkedOutList.size() == 0)
		{
			startPage.makeUserLookAtThisMessageLoop("Currently no items checked out by " + startPage.currentUser.getName());
			return;
		}
		for(int i = 0; i < checkedOutList.size();i++)
		{
			System.out.println(checkedOutList.get(i).getTitle() + "\nDue Date: " + checkedOutList.get(i).getDueDate() + "\n");
		}startPage.makeUserLookAtThisMessageLoop("");
	}
	
	/**
	 * Called by start page, set in the children classes
	 * @return
	 */
	public String getType()
	{
		return "";
	}
	
	/**
	 * Returns whether a user account is flagged
	 * @return
	 */
	
	public boolean isFlagged() {
		return flagged;
	}
	
	/**
	 * User account flagged status set by startpage
	 * flagged status determines checkout ability
	 * @param flagged
	 */
	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
	
	/**
	 * Displays user information aside from password
	 */
	public void display() {
		System.out.println("Name:		"+ this.name +
					"\nAge:			  "+ this.age +
					"\nPhone Number:   "+ this.phoneNum +
					"\nAddress		  "+ this.address +
					"\nEmail:		  "+ this.email +
					"\nAccount Number: "+ this.accNum +
					"\nFee Total:	  "+ this.feeTotal);
	}
	
}
