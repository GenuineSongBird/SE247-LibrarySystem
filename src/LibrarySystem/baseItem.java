package LibrarySystem;

import java.util.LinkedList;
import java.util.Queue;

public abstract class baseItem {
		private String title;
		private String description = "No Description";
		private double rating;
		private int releaseDate;
		private String genre;
		private boolean isNew;
		private int numCopies;
		private int ratingAmount;
		private LinkedList<String> ratingComments = new LinkedList<String>();
		private Queue<baseUser> holds = new LinkedList<>();
		private String dueDate;
		
		public String getDueDate() {
			return dueDate;
		}

		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}

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
		public void addRatingAmount()
		{
			ratingAmount = ratingAmount + 1;
		}
		public int getRatingAmount()
		{
			return ratingAmount;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getRating() {
			return rating;
		}
		public Queue<baseUser> getHolds() {
			return holds;
		}
		public void setHolds(baseUser user) {
			holds.add(user);
		}
		public void setRating(double rating) {
			this.rating = rating;
		}

		public boolean isNew() {
			return isNew;
		}

		public void setNew(boolean isNew) {
			this.isNew = isNew;
		}

		public LinkedList<String> getRatingComments() {
			return ratingComments;
		}

		public void setRatingComments(LinkedList<String> ratingComments) {
			this.ratingComments = ratingComments;
		}

		public String getTitle() {
			return title;
		}

		public int getReleaseDate() {
			return releaseDate;
		}

		public String getGenre() {
			return genre;
		}

		public int getNumCopies() {
			return numCopies;
		}
		public abstract String getType();
}