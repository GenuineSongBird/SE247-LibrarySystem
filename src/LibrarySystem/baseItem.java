package LibrarySystem;

public abstract class baseItem {
	private String title;
	private String description;
	private double rating;
	private int releaseDate;
	private String genre;
	private boolean isNew;
	private int numCopies;
	
	public baseItem(String aTitle, String aDescription, int aDate) {
		this.title = aTitle;
		this.description = aDescription;
		this.releaseDate = aDate;
		this.numCopies = 0;
	}
	
	public String display() {
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
		this.numCopies--;
	}

	public void setNumCopies(int aNumCopies) {
		if(aNumCopies >= 0)
			this.numCopies = aNumCopies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public int getNumCopies() {
		return numCopies;
	}
	



}
