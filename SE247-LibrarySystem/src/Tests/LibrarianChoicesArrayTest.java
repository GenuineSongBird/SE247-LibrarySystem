package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import LibrarySystem.librarianControls;
import LibrarySystem.userDatabase;

public class LibrarianChoicesArrayTest {

	@Test
	public void test() {
		librarianControls LC = new librarianControls();
		String[] output = {"Add a user", "Remove a User","Add an item","View a user account's info","Flag a user account"};
		assertArrayEquals(LC.librarianChoicesArray(), output);
	}

}
