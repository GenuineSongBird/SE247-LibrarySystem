package LibrarySystem;

public class itemBook extends baseItem {
	private String author;
	
	public itemBook(String aTitle, String aGenre, int aDate, int aNum, boolean isNew, String anAuthor) {
		super(aTitle, aGenre, aDate, aNum, isNew);
		this.setAuthor(anAuthor);
	}
	
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author;
	}

	private void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}
	
}
