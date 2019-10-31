package LibrarySystem;

public class itemMagazine extends baseItem {
private String publisher;
	
	public itemMagazine(String aTitle, String aDescription, int aDate {
		super(aTitle, aDescription, aDate);
		this.setPublisher(aPublisher);
	}
	
	public String toString() {
		return super.toString() + "\nPublisher: " + this.publisher;
	}

	private void setPublisher(String aPublisher) {
		this.publisher = aPublisher;
	}
}
