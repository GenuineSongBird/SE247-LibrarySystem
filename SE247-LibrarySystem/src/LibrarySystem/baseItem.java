package LibrarySystem;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Parent class for the different types of items in the library. Made abstract because generic item is not intended to be initializable.
 * @author Nick Bautista
 *
 */
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
		/**
		 * Getter for due date of the item.
		 * @return
		 */
		public String getDueDate() {
			return dueDate;
		}
		/**
		 * Setter for the due date
		 * @param dueDate
		 */
		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}
/**
 * Parent constructor for the different item types.
 * @param aTitle
 * @param aGenre
 * @param aDate
 * @param aNum
 * @param isNew
 */
		public baseItem(String aTitle, String aGenre, int aDate, int aNum, boolean isNew) {
			this.setTitle(aTitle);
			this.setGenre(aGenre);
			this.setReleaseDate(aDate);
			this.setNumCopies(aNum);
			this.setNewStatus(isNew);
		}
		/**
		 * Displays item information
		 */
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
		/**
		 * Getter for rating amount.
		 * @return
		 */
		public int getRatingAmount()
		{
			return ratingAmount;
		}
		/**
		 * +1 to an item's copies available.
		 */
		public void addCopy() {
			this.numCopies++;
		}

		/**
		 * -1 to an item's copies available.
		 */
		public void subtractCopy() {
			if(numCopies > 0)
				this.numCopies--;
		}
		
		/**
		 * If ever the amount of available copies are needed to be manually set, the method can be used.
		 * @param aNumCopies
		 */
		public void setNumCopies(int aNumCopies) {
			if(aNumCopies >= 0)
				this.numCopies = aNumCopies;
		}
		/**
		 * Setter for the year of release.
		 * @param aDate
		 */
		private void setReleaseDate(int aDate) {
			this.releaseDate = aDate;
		}
		/**
		 * Setter for the title.
		 * @param aTitle
		 */
		private void setTitle(String aTitle) {
			this.title = aTitle;
		}
		/**
		 * Setter for the genre.
		 * @param aGenre
		 */
		private void setGenre(String aGenre) {
			this.genre = aGenre;
		}
		/**
		 * Sets whether or not an item is newly arrived or not.
		 * @param status
		 */
		public void setNewStatus(boolean status) {
			this.isNew = status;
		}
		/**
		 * Getter for an item's description
		 * @return
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * Sets the description of an item.
		 * @param description
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		/**
		 * Gets the rating of an item.
		 * @return
		 */
		public double getRating() {
			return rating;
		}
		
		/**
		 * Gets the hold list queue.
		 * @return
		 */
		public Queue<baseUser> getHolds() {
			return holds;
		}
		
		/**
		 * Adds a user to the item's hold list.
		 * @param user
		 */
		public void setHolds(baseUser user) {
			holds.add(user);
		}
		/**
		 * Sets rating of the item.
		 * @param rating
		 */
		public void setRating(double rating) {
			this.rating = rating;
		}
		
		/**
		 * Gets the newly arrived status of an item.
		 * @return
		 */
		public boolean isNew() {
			return isNew;
		}

		public void setNew(boolean isNew) {
			this.isNew = isNew;
		}
		/**
		 * Gets the comments given to the item
		 * @return
		 */
		public LinkedList<String> getRatingComments() {
			return ratingComments;
		}

		public void setRatingComments(LinkedList<String> ratingComments) {
			this.ratingComments = ratingComments;
		}
		
		/**
		 * Getter for title
		 * @return
		 */
		public String getTitle() {
			return title;
		}
		
		/**
		 * Getter for year of release of the item
		 * @return
		 */
		public int getReleaseDate() {
			return releaseDate;
		}
		/**
		 * Getter for genre of the item
		 * @return
		 */
		public String getGenre() {
			return genre;
		}
		/**
		 * Getter for number of copies available.
		 * @return
		 */
		public int getNumCopies() {
			return numCopies;
		}
		public abstract String getType();
}