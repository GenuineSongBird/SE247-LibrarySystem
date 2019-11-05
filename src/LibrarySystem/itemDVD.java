package LibrarySystem;

import java.util.LinkedList;

public class itemDVD extends baseItem {
	private String studio;
	private String director;
	private LinkedList<String> actors;
	
	public itemDVD(String aTitle, String aGenre, int aDate, int aNum, boolean isNew, String aDirector) {
		super(aTitle, aGenre, aDate, aNum, isNew);
		this.setDirector(aDirector);
		this.actors = new LinkedList<String>();
	}
	
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

	private void setStudio(String aStudio) {
		this.studio = aStudio;
	}
	private void setDirector(String aDirector) {
		this.director = aDirector;
	}
	
	public void addActor(String anActor) {
		actors.add(anActor);}

	public String getType() {
		return "itemDVD";
	}
}