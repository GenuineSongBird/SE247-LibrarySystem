package LibrarySystem;


import java.util.ArrayList;

public abstract class baseUser {
	protected String name;
	protected int age;
	protected int phoneNum;
	protected String address;
	protected String email;
	protected int accNum;
	protected double feeTotal;
	protected ArrayList<Item> wishlist;
	private String password;
	checkoutLimitBehavior CheckoutLimitBehavior;
	
	
	public baseUser(String aName, int anAge, int aPhoneNum,
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
		
	}
	
	public void setCheckoutLimit(checkoutLimitBehavior clb) {
		
	}
	
	public void display() {
		
	}
	
	public double viewFees() {
		
	}
	
}
