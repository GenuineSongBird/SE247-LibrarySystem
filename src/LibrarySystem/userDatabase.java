package LibrarySystem;

import java.util.Iterator;
import java.util.LinkedList;

public class userDatabase {
	
	private static userDatabase userDatabase;
	
	static LinkedList<baseUser> database = new LinkedList<baseUser>(); 
	
	private userDatabase() {
		loadDatabase();
		//if no database found
	}
	
	public static userDatabase getInstance() {
	if (userDatabase == null) {
		System.out.println("Creating a user database");
		userDatabase = new userDatabase();
		}
	return userDatabase;
	}
	public baseUser createUser(String name, int age, String phoneNum, String address, String email, String password)
	{
		//String name, int age, int phoneNum,String address, String email, int accNum, double feeTotal,String password)
		userPatron thisUser = new userPatron(name, age, phoneNum, address, email, database.size(),0,password);
		database.add(thisUser);
		return thisUser;
	}
	public boolean loadDatabase()
	{
		boolean loadStatus = false;
		
		return loadStatus;
	}
	public int getSize()
	{
		return database.size();
	}
	public static Iterator<baseUser> returnIterator()
	{
		return database.iterator();
	}
}
