package LibrarySystem;

import java.util.LinkedList;
/**
 * Item of type DVD.
 * @author Nick Bautista
 *
 */
public class itemDVD extends baseItem {
	private String studio;
	private String director;
	private LinkedList<String> actors;
	/**
	 * Constructor of DVD item.
	 * @param aTitle
	 * @param aGenre
	 * @param aDate
	 * @param aNum
	 * @param isNew
	 * @param aDirector
	 */
	public itemDVD(String aTitle, String aGenre, int aDate, int aNum, boolean isNew, String aDirector) {
		super(aTitle, aGenre, aDate, aNum, isNew);
		this.setDirector(aDirector);
		this.actors = new LinkedList<String>();
	}
	/**
	 * Displays the information of the dvd.
	 */
	public String toString() {
		String actorString = "";
		for(int i = 0; i < actors.size(); i++) {
			if(i != actors.size()-1)
				actorString = actorString + actors.get(i) +", ";
			else
				actorString = actorString + actors.get(i);
		}
		return super.toString() + "\nDirector: " + this.director 
				+ "\nActors: " + actorString;
	}
	/**
	 * Setter for studio.
	 * @param aStudio
	 */
	private void setStudio(String aStudio) {
		this.studio = aStudio;
	}
	
	/**
	 * Setter for director.
	 * @param aDirector
	 */
	private void setDirector(String aDirector) {
		this.director = aDirector;
	}
	
	/**
	 * Adds an actor to the actor list.
	 * @param anActor
	 */
	public void addActor(String anActor) {
		actors.add(anActor);}

	/**
	 * Getter for the type of the item.
	 */
	public String getType() {
		return "itemDVD";
	}
}