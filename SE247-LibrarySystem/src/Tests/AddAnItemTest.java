package Tests;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import LibrarySystem.itemBook;
import LibrarySystem.itemDatabase;
import LibrarySystem.startPage;
import LibrarySystem.userDatabase;

public class AddAnItemTest {

	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		itemDatabase.database.clear();
		itemBook testBook = new itemBook("name", "1", 1, 1, false, "1");
		itemDatabase.database.add(testBook);
		startPage SP = new startPage();
		 systemInMock.provideLines("1", "1");
		 int output = testBook.getNumCopies() + 1;
		 SP.addAnItem();
		assertEquals(itemDatabase.database.get(0).getNumCopies(), output);
	}

}
