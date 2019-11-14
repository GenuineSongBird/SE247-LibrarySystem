package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import LibrarySystem.startPage;
import LibrarySystem.userPatron;

public class ChangeToCurrentUserTest {

	@Test
	public void test() {
		startPage SP = new startPage();
		userPatron test = new userPatron("john", 1,"1","1","1",1,1,"1");
		SP.changeToCurrentUser(test);
		userPatron output = test;
		assertEquals(SP.changeToCurrentUser(test),output);
	}

}
