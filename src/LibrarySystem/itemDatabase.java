package LibrarySystem;

public class itemDatabase {
	
	private static itemDatabase itemDatabase;
	
	private itemDatabase() {}
	
	public static itemDatabase getInstance() {
	if (itemDatabase == null) {
		//search for save file
		//if save file does not exist...
		System.out.println("Creating a item database");
		itemDatabase = new itemDatabase();
		}
	return itemDatabase;
	}
}

