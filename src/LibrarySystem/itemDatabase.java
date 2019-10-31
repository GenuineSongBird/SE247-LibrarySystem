package LibrarySystem;

import java.util.Iterator;
import java.util.LinkedList;

public class itemDatabase {
	
	private static itemDatabase itemDatabase;
	
	static LinkedList<baseUser> database = new LinkedList<baseUser>(); 
	
	private itemDatabase() {
		loadDatabase();
		//if no database found
	};

	public static itemDatabase getInstance() {
		if(database == null) {
			System.out.println("Creating a item database");
			itemDatabase = new itemDatabase();
		}
		return itemDatabase;
	}

	//public void addItem(Item anItem) {
		//database.add(anItem);
	//}
	public boolean loadDatabase()
	{
		boolean loadStatus = false;
		
		return loadStatus;
	}
}	
