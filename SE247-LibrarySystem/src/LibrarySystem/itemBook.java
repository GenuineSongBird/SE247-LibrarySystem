package LibrarySystem;
/**
 * Book item type.
 * @author Nick Bautista
 *
 */
public class itemBook extends baseItem {
	private String author;
	/**
	 * Constructor for AudioBook item type.
	 * @param aTitle
	 * @param aGenre
	 * @param aDate
	 * @param aNum
	 * @param isNew
	 * @param anAuthor
	 * @param aReader
	 */
	public itemBook(String aTitle, String aGenre, int aDate, int aNum, boolean isNew, String anAuthor) {
		super(aTitle, aGenre, aDate, aNum, isNew);
		this.setAuthor(anAuthor);
	}
	/**
	 * Gets information of book.
	 */
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author;
	}
	/**
	 * Used for constructor only. Sets the author of the book.
	 * @param anAuthor
	 */
	private void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}
	
	/**
	 * Getter for the item's type.
	 */
	public String getType() {
		return "itemBook";
	}

	
}
