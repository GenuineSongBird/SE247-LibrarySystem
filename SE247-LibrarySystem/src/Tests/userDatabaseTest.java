package LibrarySystem;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;

import LibrarySystem.userChild;
import LibrarySystem.userDatabase;
import LibrarySystem.userPatron;
import LibrarySystem.baseUser;

public class itemDatabaseTest {

	@Test
	public void testLoad() {
		userDatabase uDatabase = userDatabase.getInstance();
		assertEquals(6, uDatabase.database.size());
	}
}
