package Tests;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import LibrarySystem.startPage;
import LibrarySystem.itemBook;
import LibrarySystem.baseItem;
import LibrarySystem.itemDetailPage;
import LibrarySystem.userPatron;
import LibrarySystem.itemDatabase;
import LibrarySystem.userDatabase;
import LibrarySystem.baseUser;
import LibrarySystem.userPatron;

public class itemDetailPageTest {
	
	@Rule
	public final TextFromStandardInputStream systemInMock
    = emptyStandardInputStream();

	@Test
	public void testCheckout() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 1, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("1");
		page.checkout(bookItem);
		assertEquals(1, testUser.checkedOutListSize());
	}
	
	@Test
	public void testCheckoutNotAvailable() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("1");
		page.checkout(bookItem);
		assertEquals(0, testUser.checkedOutListSize());
	}
	
	@Test
	public void testHold() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 1, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("1");
		page.putOnHold(bookItem);
		int size = bookItem.getHolds().size();
		assertEquals(0, size);
	}
	
	@Test
	public void testHoldNotAvailable() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("1");
		page.putOnHold(bookItem);
		int size = bookItem.getHolds().size();
		assertEquals(1, size);
	}
	
	@Test
	public void testAddComments() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("This is a test.", "1");
		page.leaveComments(bookItem);
		String comment = bookItem.getRatingComments().peekFirst();
		assertEquals("john says: \"This is a test.\"", comment);
	}

	@Test
	public void testLeaveRating() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("5", "1");
		page.leaveRating(bookItem);
		double rating = bookItem.getRating();
		assertEquals(5, rating, 0.0000);
	}
	
	@Test
	public void testLeaveRatingOver5() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("6", "5", "1");
		page.leaveRating(bookItem);
		double rating = bookItem.getRating();
		assertEquals(5, rating, 0.0000);
	}
	
	@Test
	public void testLeaveRatingLessThan0() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("-1", "5", "1");
		page.leaveRating(bookItem);
		double rating = bookItem.getRating();
		assertEquals(5, rating, 0.0000);
	}
	
	@Test
	public void testAddToWishlist() {
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		itemDatabase.database.add(bookItem);
		userPatron testUser = new userPatron("john", 1,"1","1","1",1,1,"1");
		startPage.currentUser = testUser;
		itemDetailPage page = new itemDetailPage();
		systemInMock.provideLines("5", "1");
		page.addToWishList(bookItem);
		assertEquals(1, testUser.wishList.size());
		
	}
	
	@Test
	public void testViewComments() {
		itemDatabase.database.clear();
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		bookItem.getRatingComments().add("Test" + " says: \"" + "Awsome" + "\"");
		itemDatabase.database.add(bookItem);
		String comment = "Test says: \"Awsome\"";
		assertEquals(bookItem.getRatingComments().getFirst(), comment);
	}
	
	@Test
	public void testViewHoldList() {
		startPage SP = new startPage();
		itemDetailPage IDP = new itemDetailPage();
		itemDatabase.database.clear();
		userDatabase.database.clear();
		baseItem bookItem = new itemBook("Title", "Genre", 0, 0, true, "Author");
		baseUser patronUser = new userPatron("Name", 18, "1", "1", "1", 1, 0, "1");
		userDatabase.database.add(patronUser);
		itemDatabase.database.add(bookItem);
		bookItem.setHolds(patronUser);
		systemInMock.provideLines("1","Name","1");
		SP.login();
		bookItem.setHolds(patronUser);
		systemInMock.provideLines("1","7");
		assertNotNull(bookItem.getHolds());
	}
	
	@Test
	public void testGetDetails() {
		
	}
}
