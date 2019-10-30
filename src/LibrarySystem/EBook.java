package LibrarySystem;

public class EBook extends Item {
	private String author;
	
	public EBook(String aTitle, String aDescription, int aDate, String anAuthor) {
		super(String aTitle, String aDescription, int aDate);
		this.setAuthor(anAuthor);
	}
	
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author;
	}

	private void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}
}
