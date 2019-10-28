package LibrarySystem;


public class userChild extends baseUser {
	
	public userChild(String name, int age, int phoneNum,
			String address, String email, int accNum, double feeTotal,
			String password) {
		super(name, age, phoneNum, address, email, accNum, feeTotal, password);
		CheckoutLimitBehavior = new standardLimit();
		
	}
	
	public void display() {
		
	}
	
}
