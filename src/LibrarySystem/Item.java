package LibrarySystem;

public abstract class Item {
	private String title;
	private String description;
	private double rating;
	private int releaseDate;
	private String genre;
	private boolean isNew;
	private int numCopies;
	
	public Item(String aTitle, String aDescription, int aDate) {
		this.title = aTitle;
		this.description = aDescription;
		this.releaseDate = aDate
		this.numCopies = 0;
	}
	
	public String toString() {
		return "Title: " + this.title 
		+ "\nDescription: " + this.description 
		+ "\nRating: " + this.rating 
		+ "\nRelease Date: " + this.releaseDate
		+ "\nGenre: "
		+ "\nAvailable Copies: " + this.numCopies;
	}

	public void addCopy() {
		this.numCopies++;
	}

	public void subtractCopy() {
		this.numCopies--:
	}

	public void setNumCopies(int aNumCopies) {
		if(aNumCopies >= 0)
			this.numCopies = aNumCopies;
	}




}
