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

public class ApplyFeesTest {

	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		startPage SP = new startPage();
		userDatabase.database.clear();
		itemDatabase.database.clear();
		userPatron testUser = new userPatron("john", 18,"1","1","1",1,1,"1");
		userDatabase.database.add(testUser);
		itemBook testBook = new itemBook("name", "1", 1, 1, false, "1");
		testBook.setDueDate("2019/01/05");
		testUser.addToCheckedOutList(testBook);
		SP.changeToCurrentUser(testUser);
		double output = testUser.getFeeTotal() + 0.01;
		SP.applyFees();
		assertEquals(userDatabase.database.get(0).getFeeTotal(), output, 0);
	}

}
