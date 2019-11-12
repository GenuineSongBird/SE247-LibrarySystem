/*
 * This class is a singleton userDatabase to
 * store and read user class objects
 * It is called primarily by start page
 * for instantiation and uses
 *
 * Team: Untitled: Nick Bautista, Tyson Medlin, Luis Canales
 * Main programmer(s) of this class: Luis Canales 
 * Date: 10/28/2019
 */
package LibrarySystem;

import java.util.Iterator;
import java.util.LinkedList;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class userDatabase {
	
	/**
	 * Attributes of the userDatabse 
	 */
	private static final String USER_FILE_NAME = "src/users.json";
	
	private static userDatabase userDatabase;
	
	public static LinkedList<baseUser> database = new LinkedList<baseUser>(); 
	
	/**
	 * Ensures that only one userDatabase may be instantiated
	 * @return
	 */
	public static userDatabase getInstance() {
	if (userDatabase == null) {
		userDatabase = new userDatabase();
		}
	return userDatabase;
	}
	
	/**
	 * Create user method that allows for a Patron class to be created
	 * Child is created if the age is set to below 16
	 * @param name
	 * @param age
	 * @param phoneNum
	 * @param address
	 * @param email
	 * @param password
	 * @return
	 */
	public baseUser createUser(String name, int age, String phoneNum, String address, String email, String password)
	{
		//String name, int age, int phoneNum,String address, String email, int accNum, double feeTotal,String password)
		baseUser thisUser;
		if(age < 16)
		{
			thisUser = new userChild(name, age, phoneNum, address, email, database.size(),0,password);
		}
		else
		{
			thisUser = new userPatron(name, age, phoneNum, address, email, database.size(),0,password);
		}
		database.add(thisUser);
		return thisUser;
	}
	
	/**
	 * user database object
	 * takes in a JSON USER_FILE_NAME in order to populate database
	 * populates userdatabase with user objects defined and seperated by type
	 */
	private userDatabase()
	{
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			//JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray usersJSON = (JSONArray)jsonData.get("users");

			
			for(int i = 0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject)usersJSON.get(i);
				String name = (String)userJSON.get("firstName");
				//System.out.println(name);
				int age = ((Long) userJSON.get("age")).intValue();
				String phoneNum = (String)userJSON.get("phone");
				String address = (String)userJSON.get("address");
				String email = ((String) userJSON.get("email"));
				int accNum = ((Long)userJSON.get("id")).intValue();
				double feeTotal = (Double)userJSON.get("fines");
				String password = (String)userJSON.get("password");
				String userType = (String)userJSON.get("type");
				
				if(userType.equalsIgnoreCase("Patron"))
				{
					
					userPatron userAccount = new userPatron(name,age,phoneNum,address,email,accNum, feeTotal,password);
					database.add(userAccount);
				}
				
				else if(userType.equalsIgnoreCase("Admin"))
				{
					userAdmin userAccount = new userAdmin(name,age,phoneNum,address,email,accNum, feeTotal,password);
					database.add(userAccount);
				}
				
				else if(userType.equalsIgnoreCase("Librarian"))
				{
					userLibrarian userAccount = new userLibrarian(name,age,phoneNum,address,email,accNum, feeTotal,password);
					database.add(userAccount);
				}
				
				else if(userType.equalsIgnoreCase("Teacher"))
				{
					userTeacher userAccount = new userTeacher(name,age,phoneNum,address,email,accNum, feeTotal,password);
					database.add(userAccount);
				}
				
				else if(userType.equalsIgnoreCase("Child"))
				{
					userChild userAccount = new userChild(name,age,phoneNum,address,email,accNum, feeTotal,password);
					database.add(userAccount);
				}
				
				System.out.println("userDatabase: Loaded " + name);
			}
			reader.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * returns size of database
	 * @return size
	 */
	public int getSize()
	{
		return database.size();
	}
	
	/**
	 * returns the current iteration of database
	 * @return iterator
	 */
	public static Iterator<baseUser> returnIterator()
	{
		return database.iterator();
	}
}
