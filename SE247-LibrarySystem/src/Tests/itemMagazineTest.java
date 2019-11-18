package LibrarySystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import LibrarySystem.baseItem;
import LibrarySystem.itemMagazine;
import org.junit.jupiter.api.Test;

class itemMagazineTest {

	@Test
	public void testGetType() {
		baseItem magazineItem = new itemMagazine("Title", "Genre", 0, 0, true, "Publisher", 0, 0);
		assertEquals("itemMagazine", magazineItem.getType());
	}
}
