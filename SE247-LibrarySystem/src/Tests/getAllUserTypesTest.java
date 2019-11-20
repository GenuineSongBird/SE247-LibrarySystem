package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import LibrarySystem.userPatron;
import LibrarySystem.baseUser;
import LibrarySystem.userChild;
import LibrarySystem.userAdmin;
import LibrarySystem.userLibrarian;
import LibrarySystem.userTeacher;

public class getAllUserTypesTest {
	
	@Test
	public void testGetTypePatron() {
		baseUser patronUser = new userPatron("Ted", 0, "1", "1", "1", 1, 0, "1");
		assertEquals("Patron",patronUser.getType());
	}
	
	@Test
	public void testGetTypeChild() {
		baseUser childUser = new userChild("Ted", 0, "1", "1", "1", 1, 0, "1");
		assertEquals("Child",childUser.getType());
	}
	
	@Test
	public void testGetTypeAdmin() {
		baseUser adminUser = new userAdmin("Ted", 0, "1", "1", "1", 1, 0, "1");
		assertEquals("Admin",adminUser.getType());
	}
	
	@Test
	public void testGetTypeLibrarian() {
		baseUser librarianUser = new userLibrarian("Ted", 0, "1", "1", "1", 1, 0, "1");
		assertEquals("Librarian",librarianUser.getType());
	}
	
	@Test
	public void testGetTypeTeacher() {
		baseUser teacherUser = new userTeacher("Ted", 0, "1", "1", "1", 1, 0, "1");
		assertEquals("Teacher",teacherUser.getType());
	}
}
