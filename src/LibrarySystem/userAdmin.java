package LibrarySystem;


public class userAdmin extends baseUser {
	
	public userAdmin(String name, int age, int phoneNum,
			String address, String email, int accNum, double feeTotal,
			String password) {
		super(name, age, phoneNum, address, email, accNum, feeTotal, password);
		CheckoutLimitBehavior = new standardLimit();
		
	}
	
	public void display() {
		
	}
	
}
