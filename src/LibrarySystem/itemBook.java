package LibrarySystem;

public class itemBook extends baseItem {
	private String author;
	
	public itemBook(String aTitle, String aDescription, int aDate, String anAuthor) {
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
