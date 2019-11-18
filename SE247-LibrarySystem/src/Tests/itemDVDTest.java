package LibrarySystem;

import static org.junit.Assert.*;
import LibrarySystem.baseItem;
import LibrarySystem.itemDVD;
import org.junit.Test;

public class itemDVDTest {

	@Test
	public void testGetType() {
		baseItem dvdItem = new itemDVD("Title", "Genre", 0, 0, true, "Director");
		assertEquals("itemDVD", dvdItem.getType());
	}
}
