/*
 * This class inherits from baseUser class and uses the
 * extended checkout behavior as their checkout length
 *
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;


public class userTeacher extends baseUser {
	
	public userTeacher(String name, int age, String phoneNum,
			String address, String email, int accNum, double feeTotal,
			String password) {
		super(name, age, phoneNum, address, email, accNum, feeTotal, password);
		CheckoutLimitBehavior = new extendedLimit();
		
	}
	
	public void display() {
		System.out.println(this.name+" is a Teacher");
		super.display();
	}
	public String getType()
	{
		return "Teacher";
	}
}
