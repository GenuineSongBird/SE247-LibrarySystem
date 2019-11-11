package LibrarySystem;
/**
 * Item of type Magazine.
 * @author Nick Bautista
 *
 */
public class itemMagazine extends baseItem {
	private String publisher;
	private int volume;
	private int issue;
	/**
	 * Constructor for the magazine.
	 * @param aTitle
	 * @param aGenre
	 * @param aDate
	 * @param aNum
	 * @param isNew
	 * @param aPublisher
	 * @param aVol
	 * @param anIssue
	 */
	public itemMagazine(String aTitle, String aGenre, int aDate, int aNum, boolean isNew, String aPublisher, int aVol, int anIssue) {
		super(aTitle, aGenre, aDate, aNum, isNew);
		this.setPublisher(aPublisher);
		this.setVolume(aVol);
		this.setIssue(anIssue);
	}
	/**
	 * Returns all relevant information of the magazine.
	 */
	public String toString() {
		return super.toString() + "\nPublisher: " + this.publisher;
	}
	/**
	 * Setter for the publisher of the magazine.
	 * @param aPublisher
	 */
	private void setPublisher(String aPublisher) {
		this.publisher = aPublisher;
	}
	/**
	 * Setter for the volume of the magazine.
	 * @param aVol
	 */
	private void setVolume(int aVol) {
		if(aVol >= 0) 
			this.volume = aVol;
	}
	/**
	 * Setter for the issue of the magazine.
	 * @param anIssue
	 */
	private void setIssue(int anIssue) {
		if(anIssue >= 0) 
			this.issue = anIssue;
	}
	/**
	 * Getter for the type of the item.
	 */
	public String getType() {
		return "itemMagazine";
	}
}
