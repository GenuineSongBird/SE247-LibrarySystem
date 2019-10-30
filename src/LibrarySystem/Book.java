package LibrarySystem;

public class Book extends Item {
	private String author;
	
	public Book(String title) {
		super(title);
	}
	
	public void setCheckoutLength(CheckoutLengthBehavior clb) {
		
	}
	
	public String display() {
		String everything = "";
		return everything;
	}
}
