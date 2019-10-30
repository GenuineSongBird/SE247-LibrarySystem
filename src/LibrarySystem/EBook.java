package LibrarySystem;

public class EBook extends Item {
	private String author;
	
	public EBook(String title) {
		super(title);
	}
	
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author;
	}
}
