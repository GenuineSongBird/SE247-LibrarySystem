package LibrarySystem;
/**
 * Item of type eBook.
 * @author Nick Bautista
 *
 */
public class itemEBook extends baseItem {
	private String author;
	/**
	 * Constructor for the eBook item.
	 * @param aTitle
	 * @param aGenre
	 * @param aDate
	 * @param aNum
	 * @param isNew
	 * @param anAuthor
	 */
	public itemEBook(String aTitle, String aGenre, int aDate, int aNum, boolean isNew, String anAuthor) {
		super(aTitle, aGenre, aDate, aNum, isNew);
		this.setAuthor(anAuthor);
	}
	/**
	 * Returns the relevant information of the eBook.
	 */
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author;
	}
	/**
	 * Sets the author of the eBook.
	 * @param anAuthor
	 */
	private void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}
	/**
	 * Getter for the type of the item.
	 */
	public String getType() {
		return "itemEBook";
	}
}
