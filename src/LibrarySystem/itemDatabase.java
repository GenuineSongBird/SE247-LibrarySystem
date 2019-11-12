package LibrarySystem;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * Class that initializes database and contains some of its functionalities.
 */
public class itemDatabase {
	
	private static final String BOOK_FILE_NAME = "src/books.json";
	private static final String DVD_FILE_NAME = "src/dvds.json";
	private static final String MAGAZINE_FILE_NAME = "src/magazines.json";
	public static LinkedList<baseItem> database = new LinkedList<baseItem>();
	private static itemDatabase iDatabase;
	
	private itemDatabase() {}
/**
 * Singleton Design Pattern is used so that the system only ever uses one database at a time.
 */
	public static itemDatabase getInstance() {
		if(iDatabase == null) {
			iDatabase = new itemDatabase();
		}
		return iDatabase;
	}
	
	private void addItem(baseItem anItem) {
		database.add(anItem);
	}
	
	/**
	 * Loads into a database from a JSON file by collecting the different types of items across different files.
	 */
	public void loadDatabase() {
		try { // This try-catch block parses the data from the book JSON file. 
			FileReader reader = new FileReader(BOOK_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray booksJSON = (JSONArray)jsonData.get("books");

			
			for(int i = 0; i < booksJSON.size(); i++) {
				JSONObject bookJSON = (JSONObject)booksJSON.get(i);
				String title = (String)bookJSON.get("title");
				int year = ((Long) bookJSON.get("year")).intValue();
				String genre = (String)bookJSON.get("genre");
				String author = (String)bookJSON.get("author");
				int numCopies = ((Long) bookJSON.get("numCopies")).intValue();
				boolean isNew = (Boolean)bookJSON.get("newArrival");
				JSONArray comments = (JSONArray)bookJSON.get("comments");
				itemBook itemBook = new itemBook(title, genre, year, numCopies, isNew, author);
				LinkedList<String> commentsArray = new LinkedList<String>();
				for(int j = 0; j < comments.size(); j++) {
					commentsArray.add((String)comments.get(j));
				}
				itemBook.setRatingComments(commentsArray);
				this.addItem(itemBook);
				System.out.println("itemDatabase: Loaded " + title);
			}
			reader.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try { //This try block parses the data from the DVD JSON file.
			FileReader reader = new FileReader(DVD_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray dvdsJSON = (JSONArray)jsonData.get("dvds");
			
			for(int i = 0; i < dvdsJSON.size(); i++) {
				JSONObject dvdJSON = (JSONObject)dvdsJSON.get(i);
				String title = (String)dvdJSON.get("title");
				int year = ((Long) dvdJSON.get("year")).intValue();
				String genre = (String)dvdJSON.get("genre");
				String director = (String)dvdJSON.get("director");
				JSONArray actors = (JSONArray)dvdJSON.get("actors");
				int numCopies = ((Long) dvdJSON.get("numCopies")).intValue();
				boolean isNew = (Boolean)dvdJSON.get("newArrival");
				itemDVD newItem = new itemDVD(title, genre, year, numCopies, isNew, director);//Initialized as itemDVD for addActor() method use.
				System.out.println("itemDatabase: Loaded " + title);
				for(int j = 0; j < actors.size(); j++) {//Parses through an actor array in the JSON file then adds it to the list of actors of the item.
					String actor = (String)actors.get(j);
					newItem.addActor(actor);
				}
				JSONArray comments = (JSONArray)dvdJSON.get("comments");
				LinkedList<String> commentsArray = new LinkedList<String>();
				for(int j = 0; j < comments.size(); j++) {
					commentsArray.add((String)comments.get(j));
				}
				newItem.setRatingComments(commentsArray);
				this.addItem(newItem);
			
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try { //This block parses the data from the magazine JSON file.
			FileReader reader = new FileReader(MAGAZINE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray magsJSON = (JSONArray)jsonData.get("magazines ");
			
			for(int i = 0; i < magsJSON.size(); i++) {
				JSONObject magJSON = (JSONObject)magsJSON.get(i);
				String title = (String)magJSON.get("title");
				int year = ((Long) magJSON.get("year")).intValue();
				String genre = (String)magJSON.get("genre");
				String publisher = (String)magJSON.get("publisher");
				int volume = ((Long) magJSON.get("volume")).intValue();
				int issue = ((Long) magJSON.get("issue")).intValue();
				int numCopies = ((Long) magJSON.get("numCopies")).intValue();
				boolean isNew = (Boolean) magJSON.get("newArrival");
				itemMagazine itemMagazine = new itemMagazine(title, genre, year, numCopies, isNew, publisher, volume, issue);
				JSONArray comments = (JSONArray)magJSON.get("comments");
				LinkedList<String> commentsArray = new LinkedList<String>();
				for(int j = 0; j < comments.size(); j++) {
					commentsArray.add((String)comments.get(j));
				}
				itemMagazine.setRatingComments(commentsArray);
				this.addItem(itemMagazine);
				System.out.println("itemDatabase: Loaded " + title);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * Displays the toString() method of existing items in the database. The toString() method contains all information about the item.
	 */
	public void printDB() {
		for(baseItem i : database) {
			System.out.println(i.toString());
			System.out.println("--------------------------------------------------------------------");
		}
	}
}
