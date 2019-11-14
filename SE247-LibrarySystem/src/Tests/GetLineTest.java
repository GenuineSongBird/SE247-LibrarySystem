package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import LibrarySystem.startPage;

public class GetLineTest {

	@Test
	public void test() {
		startPage SP = new startPage();
		String output = "\n---------------------";
		assertEquals(SP.getLine(), output);
	}

}
