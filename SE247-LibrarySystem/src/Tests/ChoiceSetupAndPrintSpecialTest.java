package Tests;

import static org.junit.Assert.*;


import org.junit.Test;

import LibrarySystem.startPage;

public class ChoiceSetupAndPrintSpecialTest {

	@Test
	public void test() {
		startPage test = new startPage();
		String[] choices = {"Choice 1","Choice 2","Choice 3","Choice 4"};
		String[] special = {"detail 1","detail 2","detail 3","detail 4"};
		String output = test.choiceSetupAndPrintSpecial(choices, special);
		assertEquals("Please select a choice\n\n1. Choice 1\n   detail 1\n2. Choice 2\n   detail 2\n3. Choice 3\n   detail 3\n4. Choice 4\n   detail 4\n",output);
	}

}
