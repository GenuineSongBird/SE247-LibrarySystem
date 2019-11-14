package Tests;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import LibrarySystem.startPage;

public class GetDateTest {

	@Test
	public void test() {
		startPage SP = new startPage();
		DateTime dateTime = new DateTime();
		String output = dateTime.getYear() + "/" + dateTime.getMonthOfYear() + "/" + dateTime.getDayOfMonth();
		
		assertEquals(SP.getDate(),output);
	}

}
