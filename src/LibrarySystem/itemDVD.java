package LibrarySystem;

public class itemDVD extends baseItem {
	private String studio;
	
	public itemDVD(String aTitle, String aDescription, int aDate, String aStudio) {
		super(String aTitle, String aDescription, int aDate);
		this.setStudio(aStudio);
	}
	
	public String toString() {
		return super.toString() + "\nStudio: " + this.studio;
	}

	private void setStudio(String aStudio) {
		this.studio = aStudio;
	}
}
