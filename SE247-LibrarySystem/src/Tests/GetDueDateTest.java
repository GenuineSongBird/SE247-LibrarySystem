package Tests;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import LibrarySystem.itemBook;
import LibrarySystem.itemDVD;
import LibrarySystem.startPage;

public class GetDueDateTest {

	@Test
	public void test() {
		//Tests Book
		startPage SP = new startPage();
		itemBook testBook = new itemBook(null, null, 0, 0, false, null);
		DateTime dateTime = new DateTime();
		dateTime = dateTime.plusDays(30);
		String output = (dateTime.getYear() + "/" + dateTime.getMonthOfYear() + "/" + dateTime.getDayOfMonth());
		assertEquals(SP.getDueDate(testBook),output);
		
		//Tests DVD
		itemDVD testDVD = new itemDVD(null, null, 0, 0, false, null);
		dateTime = new DateTime();
		dateTime = dateTime.plusDays(7);
		output = (dateTime.getYear() + "/" + dateTime.getMonthOfYear() + "/" + dateTime.getDayOfMonth());
		assertEquals(SP.getDueDate(testDVD),output);
	}

}
