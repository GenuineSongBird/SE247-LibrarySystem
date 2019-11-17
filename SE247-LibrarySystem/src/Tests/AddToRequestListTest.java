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
import LibrarySystem.userPatron;

public class AddToRequestListTest {

	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		userPatron testUser = new userPatron("bob", 18,"1","1","1",1,1,"1");
		systemInMock.provideLines("1", "1", "1");
		startPage SP = new startPage();
		SP.changeToCurrentUser(testUser);
		browsePage BP = new browsePage();
		userDatabase.database.clear();
		itemDatabase.database.clear();

		boolean output = true;

		assertEquals(BP.addToRequestList(), output);
	}

}
