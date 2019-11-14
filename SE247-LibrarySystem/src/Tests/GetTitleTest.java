package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import LibrarySystem.startPage;

public class GetTitleTest {

	@Test
	public void test() {
		startPage SP = new startPage();
		String output = "----------------------\nPortia Plante Library of Excellence\n----------------------";
		assertEquals(SP.getTitle(), output);
	}

}
