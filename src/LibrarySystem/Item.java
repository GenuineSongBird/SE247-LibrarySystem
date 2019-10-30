package LibrarySystem;

public abstract class Item {
	private String title;
	private String description;
	private double rating;
	private int date;
	private String genre;
	private boolean isNew;
	private int numCopies;
	
	public Item(String aTitle) {
		this.title = aTitle;
	}
	
	public String display() {
		String everything = "";
		return everything;
	}
}
