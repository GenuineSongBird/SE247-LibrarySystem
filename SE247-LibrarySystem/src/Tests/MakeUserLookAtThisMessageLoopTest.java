package Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import LibrarySystem.startPage;

public class MakeUserLookAtThisMessageLoopTest {

	@Test
	public void test() {
		startPage SP = new startPage();
		

	    String input = "1";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);

		
		String message = "TestTest Test";
		String output = message + "\nReturn to main menu?. \n1. Yes\n2. No";
		assertEquals(SP.makeUserLookAtThisMessageLoop(message), output);
		

	}
}
