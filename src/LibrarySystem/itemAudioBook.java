package LibrarySystem;

/**
 * AudioBook item type.
 * @author Nick Bautista
 *
 */
public class itemAudioBook extends baseItem {
	private String author;
	private String reader;
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
	public itemAudioBook(String aTitle, String aGenre, int aDate, int aNum, boolean isNew, String anAuthor, String aReader) {
		super(aTitle, aGenre, aDate, aNum, isNew);
		this.setAuthor(anAuthor);
		this.setReader(aReader);
	}
	/**
	 * Displays information of audio book.
	 */
	public String toString() {
		return super.toString() + "\nAuthor: " + this.author 
		+ "\nReader: " + this.reader;
	}
	/**
	 * Setter for author
	 * @param anAuthor
	 */
	private void setAuthor(String anAuthor) {
		this.author = anAuthor;
	}
	/**
	 * Setter for reader
	 * @param aReader
	 */
	private void setReader(String aReader) {
		this.reader = aReader;
	}
	/**
	 * Getter for the type.
	 */
	public String getType() {
		return "itemAudioBook";
	}
}
