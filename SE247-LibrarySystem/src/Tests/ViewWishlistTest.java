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
import LibrarySystem.userPatron;

public class ViewWishlistTest {

	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		startPage SP = new startPage();
		userDatabase.database.clear();
		itemDatabase.database.clear();
		userPatron testUser = new userPatron("john", 18,"1","1","1",1,1,"1");
		itemBook testBook = new itemBook("Pajama Time", "Children", 2000, 2, false, "Sandra Boynton");
		testUser.addToWishList(testBook);
		userDatabase.database.add(testUser);
		SP.changeToCurrentUser(testUser);
		String output = testBook.toString();
		systemInMock.provideLines("1");
		assertEquals(SP.viewWishlist(), output);
	}

}
