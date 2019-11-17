package Tests;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import LibrarySystem.startPage;
import LibrarySystem.userDatabase;
import LibrarySystem.userPatron;

public class ViewUserAcctInfoTest {

	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	@Test
	public void test() {
		
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		
		startPage SP = new startPage();
		userDatabase.database.add(testUser);


		 systemInMock.provideLines("1", "1");
	    
		
		boolean output = true;
		assertEquals(SP.viewUserAcctInfo(), output);
	}

}
