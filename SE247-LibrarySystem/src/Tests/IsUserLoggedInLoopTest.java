package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import LibrarySystem.startPage;
import LibrarySystem.userPatron;

public class IsUserLoggedInLoopTest {

	@Test
	public void test() {
		startPage SP = new startPage();
		userPatron test = new userPatron("john", 1,"1","1","1",1,1,"1");
		SP.changeToCurrentUser(test);
		boolean output = true;
		assertEquals(SP.isUserLoggedInLoop(),output);
	}

}
