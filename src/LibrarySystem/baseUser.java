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
	
	public void checkoutLimit() {
		CheckoutLimitBehavior.checkoutLimit();
	}
	
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
		System.out.println("Name:		"+ this.name +
					"\nAge:			  "+ this.age +
					"\nPhone Number:   "+ this.phoneNum +
					"\nAddress		  "+ this.address +
					"\nEmail:		  "+ this.email +
					"\nAccount Number: "+ this.accNum +
					"\nFee Total:	  "+ this.feeTotal);
	}
	
	public double viewFees() {
		if(feeTotal >= 100) { feeTotal = 100;}
		return this.feeTotal;
	}
	
	//Accessors and Mutators for each method
	
	//Name 
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	//Age
	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}

	//Phone Number
	public String getPhoneNum() {
		return phoneNum;
	}

	private void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	//Address
	public String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	//Email
	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	//Account Number
	public int getAccNum() {
		return accNum;
	}
	public String getPassword() {
		return password;
	}
	private void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	//Fee Total
	public double getFeeTotal() {
		if(feeTotal >= 100) { feeTotal = 100;}
		return feeTotal;
		
	}

	public void setFeeTotal(double feeTotal) {
		this.feeTotal = feeTotal;
		if(feeTotal >= 100) { feeTotal = 100;}
	}
	public void addToWishList(baseItem thisItem)
	{
		wishList.add(thisItem);
	}
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
	public void addToCheckedOutList(baseItem thisItem)
	{
		checkedOutList.add(thisItem);
	}
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
	public String getType()
	{
		return "";
	}
	
}
