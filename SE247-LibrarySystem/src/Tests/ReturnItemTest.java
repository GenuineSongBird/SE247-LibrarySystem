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

public class ReturnItemTest {

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
		testUser.addToCheckedOutList(testBook);
		userDatabase.database.add(testUser);
		itemDatabase.database.add(testBook);
		SP.changeToCurrentUser(testUser);
		int output = 0;
		systemInMock.provideLines("1", "1");
		SP.returnItem();
		assertEquals(userDatabase.database.get(0).checkedOutListSize(), output, 0);
	}

}
