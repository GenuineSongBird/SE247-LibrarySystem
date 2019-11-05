package LibrarySystem;

public class itemMagazine extends baseItem {
	private String publisher;
	private int volume;
	private int issue;
	
	public itemMagazine(String aTitle, String aGenre, int aDate, int aNum, boolean isNew, String aPublisher, int aVol, int anIssue) {
		super(aTitle, aGenre, aDate, aNum, isNew);
		this.setPublisher(aPublisher);
		this.setVolume(aVol);
		this.setIssue(anIssue);
	}
	
	public String toString() {
		return super.toString() + "\nPublisher: " + this.publisher;
	}

	private void setPublisher(String aPublisher) {
		this.publisher = aPublisher;
	}
	
	private void setVolume(int aVol) {
		if(aVol >= 0) 
			this.volume = aVol;
	}
	
	private void setIssue(int anIssue) {
		if(anIssue >= 0) 
			this.issue = anIssue;
	}
	public String getType() {
		return "itemMagazine";
	}
}
