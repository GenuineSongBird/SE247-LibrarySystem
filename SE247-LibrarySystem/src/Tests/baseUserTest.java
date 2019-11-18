package Tests;

import static org.junit.Assert.*;


import org.junit.Test;

import LibrarySystem.baseUser;
import LibrarySystem.userPatron;

public class baseUserTest {

  @Test
	public void feeTotalMaxed() {
		baseUser userPatron = new userPatron("Bob", 6, "1", "1", "1", 1, 0, "1");
		userPatron.addToFeeTotal(200);
		int userFee = (int) userPatron.getFeeTotal();
		assertEquals(100, userFee);
	}
  
}
