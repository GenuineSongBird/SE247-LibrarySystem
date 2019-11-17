package Tests;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import LibrarySystem.startPage;
import LibrarySystem.userChild;
import LibrarySystem.userDatabase;
import LibrarySystem.userPatron;

public class UpdateAccountTypesTest {
	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		startPage SP = new startPage();
		userDatabase.database.clear();
		userChild testUser = new userChild("john", 18,"1","1","1",1,1,"1");
		userDatabase.database.add(testUser);
		userPatron output = new userPatron("john", 18,"1","1","1",1,1,"1");
		SP.updateAccountTypes();
		assertEquals(userDatabase.database.get(5).getType(), output.getType());
	}

}
