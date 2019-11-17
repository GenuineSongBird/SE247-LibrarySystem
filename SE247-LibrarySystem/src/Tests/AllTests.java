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
	PayFeeTest.class,
	ReturnItemTest.class,
	ViewFeeTest.class,
	LogoutTest.class,
	LoginTest.class,
	GetUserChoiceTest.class,
	GetUserChoiceAndPrintSpecialTest.class,
	CreateNewUserTest.class,
	LibrarianChoicesArrayTest.class,
	AdminChoicesArrayTest.class,
	SearchByTitleTest.class,
	SearchByYearTest.class,
	SearchByGenreTest.class,
	SearchByDescriptionTest.class,
	SearchByRatingTest.class,
	})
public class AllTests {

}
