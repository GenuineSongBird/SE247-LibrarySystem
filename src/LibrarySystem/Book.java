package LibrarySystem;

public class Book extends Item {
	private String author;
	
	public Book(String aTitle, String aDescription, int aDate, String anAuthor) {
		super(aTitle, aDescription, aDate);
		this.setAuthor(anAuthor);
	}
	
	public void setCheckoutLength(CheckoutLengthBehavior clb) {
		
	}
	
	public String toString() {
		return super.toString() + "Author: " + this.author;
	}

	private void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}
}
