package Tests;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import LibrarySystem.baseUser;
import LibrarySystem.itemDatabase;
import LibrarySystem.startPage;
import LibrarySystem.userDatabase;
import LibrarySystem.userPatron;

public class GetUserChoiceTest {

	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		startPage SP = new startPage();
		userDatabase.database.clear();
		itemDatabase.database.clear();
		userPatron testUser = new userPatron("john", 18,"1","1","1",1,1,"1");
		int output = 2;
		userDatabase.database.add(testUser);
		systemInMock.provideLines("7", "2");
		String[] choices = {" test 1", "test 2"};
		assertEquals(SP.getUserChoice(choices, choices.length), output);
	}
}
