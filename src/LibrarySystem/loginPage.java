package LibrarySystem;
import java.util.Scanner;

public class loginPage {
	public loginPage()
	{
		int choice = 0;
		startPage.getLine();
		String[] choices = {"Login", "Create account","Return to home page"};
		choice = startPage.getUserChoice(choices, choices.length);
		getResponseForChoice(choice);
	}
	private void getResponseForChoice(int usersChoice)
	{
		Scanner key = new Scanner(System.in);
		switch(usersChoice) {
			case 1:
				String name;
				String password;
				System.out.println("Please enter the account name");
				name = key.nextLine();
				System.out.println("Please enter the password");
				password = key.nextLine();
				login( password, name );
				return;
			case 2:
				createNewUser();
				return;
		}
		
	}
	public void createNewUser()
	{
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
	}
	public boolean login( String password, String name)
	{
		startPage.makeUserLookAtThisMessageLoop("This feature will be added once databases are ready");
		return false;
	}
}
