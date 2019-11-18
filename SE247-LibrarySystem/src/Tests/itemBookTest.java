package LibrarySystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import LibrarySystem.itemBook;
import LibrarySystem.baseItem;

class itemBookTest {

	@Test
	public void testGetType() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		assertEquals("itemBook", bookItem.getType());
	}
	
}
