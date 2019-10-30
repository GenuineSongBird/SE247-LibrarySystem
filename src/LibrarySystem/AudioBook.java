package LibrarySystem;

public class AudioBook extends Item {
	private String author;
	private String reader;
	
	public AudioBook(String title) {
		super(title);
	}
	
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author 
		+ "\nReader: " + this.reader;
	}
}
