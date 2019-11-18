package LibrarySystem;

import static org.junit.Assert.*;

import org.junit.Test;
import LibrarySystem.baseItem;
import LibrarySystem.itemAudioBook;

public class itemAudioBookTest {

	@Test
	public void testGetType() {
		baseItem bookItem = new itemAudioBook("Title", "Genre", 0, 0, true, "Author","Reader");
		assertEquals("itemAudioBook", bookItem.getType());
	}

}
