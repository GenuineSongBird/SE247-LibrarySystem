package Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import LibrarySystem.itemBook;
import LibrarySystem.itemDatabase;
import LibrarySystem.startPage;
import LibrarySystem.userDatabase;
import LibrarySystem.userPatron;

public class CheckForHoldsTest {

	@Test
	public void test() {
		itemDatabase.database.clear();
		startPage SP = new startPage();
		userDatabase.database.clear();
		userPatron testUser = new userPatron("john", 18,"1","1","1",1,1,"1");
		itemBook testBook = new itemBook("name", "1", 1, 1, false, "1");
		SP.changeToCurrentUser(testUser);
		userDatabase.database.add(testUser);
		itemDatabase.database.add(testBook);
		itemDatabase.database.get(0).setHolds(userDatabase.database.get(0));
		itemDatabase.database.get(0).setNumCopies(10);

		 String input = "1";
		    InputStream in = new ByteArrayInputStream(input.getBytes());
		    System.setIn(in);
		 boolean output = true;
		assertEquals(SP.checkForHolds(), output);
	}

}
