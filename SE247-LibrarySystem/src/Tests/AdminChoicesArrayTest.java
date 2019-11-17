package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import LibrarySystem.adminControls;
import LibrarySystem.librarianControls;

public class AdminChoicesArrayTest {

	@Test
	public void test() {
		//{"Add a user", "Remove a User","Add an item","View a user account's info","Flag a user account","Change a user account's type"}
		adminControls AC = new adminControls();
		String[] output = {"Add a user", "Remove a User","Add an item","View a user account's info","Flag a user account","Change a user account's type"};
		assertArrayEquals(AC.adminChoicesArray(), output);
	}
}


