package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ChoiceSetupAndPrintSpecialTest.class,
	ChoiceSetupTest.class,
	IsUserLoggedInLoopTest.class,
	IsUserLoggedInTest.class,
	ChangeToCurrentUserTest.class,
	MakeUserLookAtThisMessageLoopTest.class,
	GetLineTest.class,
	GetTitleTest.class,
	GetDueDateTest.class,
	GetDateTest.class,
	FlagUserTest.class,
	ViewUserAcctInfoTest.class,
	RemoveUserTest.class,
	AddAnItemTest.class,
	UpdateAccountTypesTest.class,
	CheckForHoldsTest.class,
	ApplyFeesTest.class,
	ViewWishlistTest.class,
	ViewHoldsTest.class,
	PayFeeTest.class
	})
public class AllTests {

}
