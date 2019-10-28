package LibrarySystem;

public class userDatabase {
	
	private static userDatabase userDatabase;
	
	private userDatabase() {
		loadDatabase();
	}
	
	public static userDatabase getInstance() {
	if (userDatabase == null) {
		//search for save file
		//if save file does not exist...
		System.out.println("Creating a item database");
		userDatabase = new userDatabase();
		}
	return userDatabase;
	}
	public void createUser(String name, int age, String phoneNum, String address, String email, String password)
	{
		
	}
	public boolean loadDatabase()
	{
		boolean loadStatus = false;
		
		return loadStatus;
	}
}
