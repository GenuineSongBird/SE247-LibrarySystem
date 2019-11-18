package LibrarySystem;

import static org.junit.Assert.*;

import org.junit.Test;
import LibrarySystem.baseItem;
import LibrarySystem.itemBook;
import LibrarySystem.itemDatabase;
import LibrarySystem.itemMagazine;
import LibrarySystem.itemDVD;

public class itemDatabaseTest {

	@Test
	public void testLoad() {
		itemDatabase iDatabase = itemDatabase.getInstance();
		iDatabase.loadDatabase();
		assertEquals(16, iDatabase.database.size());
	}
}
