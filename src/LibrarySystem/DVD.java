package LibrarySystem;

public class DVD extends Item {
	private String studio;
	
	public DVD(String title) {
		super(title);
	}
	
	public String toString() {
		return super.toString() + "\nStudio: " + this.studio;
}
