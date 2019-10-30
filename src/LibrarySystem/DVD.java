package LibrarySystem;

public class DVD extends Item {
	private String studio;
	
	public DVD(String aTitle, String aDescription, int aDate, String aStudio) {
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
