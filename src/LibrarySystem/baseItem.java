package LibrarySystem;

import java.util.LinkedList;

public abstract class baseItem {
		private String title;
		private String description;
		private double rating;
		private int releaseDate;
		private String genre;
		private boolean isNew;
		private int numCopies;
		private LinkedList<String> ratingComments = new LinkedList<String>();
		
		public baseItem(String aTitle, String aGenre, int aDate, int aNum, boolean isNew) {
			this.setTitle(aTitle);
			this.setGenre(aGenre);
			this.setReleaseDate(aDate);
			this.setNumCopies(aNum);
			this.setNewStatus(isNew);
		}
		
		public String toString() {
			return "Title: " + this.title 
			+ "\nDescription: " + this.description 
			+ "\nRating: " + this.rating 
			+ "\nRelease Date: " + this.releaseDate
			+ "\nGenre: " + this.genre 
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
		
		private void setReleaseDate(int aDate) {
			this.releaseDate = aDate;
		}
		
		private void setTitle(String aTitle) {
			this.title = aTitle;
		}

		private void setGenre(String aGenre) {
			this.genre = aGenre;
		}

		public void setNewStatus(boolean status) {
			this.isNew = status;
		}
}