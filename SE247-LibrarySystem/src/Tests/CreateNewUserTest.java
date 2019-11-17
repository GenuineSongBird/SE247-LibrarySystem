package Tests;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import LibrarySystem.baseUser;
import LibrarySystem.itemDatabase;
import LibrarySystem.loginPage;
import LibrarySystem.userDatabase;
import LibrarySystem.userPatron;

public class CreateNewUserTest {

	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		systemInMock.provideLines("2", "bob", "18","1","1","1","1","1","1");
		loginPage LP = new loginPage();
		userDatabase.database.clear();
		itemDatabase.database.clear();
		userPatron testUser = new userPatron("bob", 18,"1","1","1",1,1,"1");
		baseUser output = testUser;
		userDatabase.database.add(testUser);
		assertEquals(userDatabase.database.get(0), output);
	}

}
