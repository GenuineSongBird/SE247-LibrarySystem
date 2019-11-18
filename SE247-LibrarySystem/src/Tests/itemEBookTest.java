package LibrarySystem;

import static org.junit.Assert.*;
import LibrarySystem.baseItem;
import LibrarySystem.itemEBook;
import org.junit.Test;

public class itemEBookTest {
	
	@Test
	public void testGetType() {
		baseItem bookItem = new itemEBook("Title", "Genre", 0, 0, true, "Author");
		assertEquals("itemEBook", bookItem.getType());
	}

}
