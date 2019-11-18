package LibrarySystem;

import static org.junit.Assert.*;
import org.junit.Test;

import LibrarySystem.baseItem;
import LibrarySystem.itemBook;

class baseItemTest {
	
	
	@Test
	public void testGetNumCopies() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		int numCopies = bookItem.getNumCopies();
		assertEquals(0, numCopies);
	}
	
	@Test
	public void testSetNumCopies() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		bookItem.setNumCopies(1);
		int numCopies = bookItem.getNumCopies();
		assertEquals(1, numCopies);
	}
	
	@Test
	public void testSetNumCopiesNegative() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		bookItem.setNumCopies(-1);
		int numCopies = bookItem.getNumCopies();
		assertEquals(0, numCopies);
	}
	
	@Test
	public void testAddCopy() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		bookItem.addCopy();
		int numCopies = bookItem.getNumCopies();
		assertEquals(1, numCopies);
	}
	@Test
	public void testSubtractCopy() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		bookItem.subtractCopy();
		int numCopies = bookItem.getNumCopies();
		assertEquals(0, numCopies);
	}
	
	@Test
	public void testSubtractCopyAtZero() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		bookItem.subtractCopy();
		int numCopies = bookItem.getNumCopies();
		assertEquals(0, numCopies);
	}
	
	@Test
	public void testGetReleaseDate() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		int releaseDate = bookItem.getReleaseDate();
		assertEquals(0, releaseDate);
	}
	
	@Test
	public void testGetTitle() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		String title = bookItem.getTitle();
		assertEquals("Title", title);
	}
	
	@Test
	public void testGetGenre() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		String genre = bookItem.getGenre();
		assertEquals("Genre", genre);
	}
	
	@Test
	public void testIsNew() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		boolean isNew = bookItem.isNew();
		assertEquals(true, isNew);
	}
	
	@Test
	public void testSetNewStatus() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		bookItem.setNewStatus(false);
		boolean isNew = bookItem.isNew();
		assertEquals(false, isNew);
	}
	
	@Test
	public void testSetRating() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		bookItem.setRating(5);
		double rating = bookItem.getRating();
		assertEquals(5, rating);
	}

}
