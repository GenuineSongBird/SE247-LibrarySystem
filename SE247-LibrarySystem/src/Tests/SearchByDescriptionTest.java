package Tests;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import LibrarySystem.browsePage;
import LibrarySystem.itemBook;
import LibrarySystem.itemDatabase;
import LibrarySystem.startPage;
import LibrarySystem.userDatabase;

public class SearchByDescriptionTest {

	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		systemInMock.provideLines("1", "1");
		startPage SP = new startPage();
		SP.changeToCurrentUser(null);
		browsePage BP = new browsePage();
		userDatabase.database.clear();
		itemDatabase.database.clear();
		itemBook testBook = new itemBook("name", "1", 1, 1, false, "1");
		itemDatabase.database.add(testBook);
		String output = testBook.toString();

		assertEquals(BP.searchByDescription(""), output);
	}

}
