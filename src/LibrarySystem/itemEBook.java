package LibrarySystem;

public class itemEBook extends baseItem {
	private String author;
	
	public itemEBook(String aTitle, String aDescription, int aDate, String anAuthor) {
		super(String aTitle, String aDescription, int aDate);
		this.setAuthor(anAuthor);
	}
	
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author;
	}

	private void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}
	public String getType() {
		return "itemEBook";
	}
}
