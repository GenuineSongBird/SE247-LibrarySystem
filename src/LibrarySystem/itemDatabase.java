package LibrarySystem;

import java.util.List;
import java.util.ArrayList;

public class ItemDatabase {
	private List<Item> itemList = new ArrayList<Item>();
	private static ItemDatabase iDatabase;
	private ItemDatabase() {};

	public static ItemDatabase getInstance() {
		if(iDatabase == null) {
			iDatabase = new Database();
		}
		return iDatabase;
	}

	public void createItem(Item anItem) {
		iDatabase.add(anItem);
	}
}	
