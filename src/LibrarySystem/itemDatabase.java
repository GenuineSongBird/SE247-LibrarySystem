package LibrarySystem;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class itemDatabase {
	
	private static final String BOOK_FILE_NAME = "src/books.json";
	private static final String DVD_FILE_NAME = "src/dvds.json";
	private static final String MAGAZINE_FILE_NAME = "src/magazines.json";
	public static LinkedList<baseItem> database = new LinkedList<baseItem>();
	private static itemDatabase iDatabase;
	
	private itemDatabase() {}

	public static itemDatabase getInstance() {
		if(iDatabase == null) {
			iDatabase = new itemDatabase();
		}
		return iDatabase;
	}
	
	private void addItem(baseItem anItem) {
		database.add(anItem);
	}
	
	public void loadDatabase() {
		try {
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
				this.addItem(new itemBook(title, genre, year, numCopies, isNew, author));;
				System.out.println("itemDatabase: Loaded " + title);
			}
			reader.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
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
				itemDVD newItem = new itemDVD(title, genre, year, numCopies, isNew, director);
				for(int j = 0; j < actors.size(); j++) {
					String actor = (String)actors.get(j);
					newItem.addActor(actor);
				}
				this.addItem(newItem);
			
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
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
				this.addItem(new itemMagazine(title, genre, year, numCopies, isNew, publisher, volume, issue));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void printDB() {
		for(baseItem i : database) {
			System.out.println(i.toString());
			System.out.println("--------------------------------------------------------------------");
		}
	}
	
	/**public void createItem(String title, String genre, int releaseDate, int numCopies, boolean isNew, String type) {
	Item newItem;
	Scanner keyboard = new Scanner(System.in);
	if(type.equalsIgnoreCase("book")) {
		System.out.println("Enter the name of the author:");
		String author = keyboard.nextLine();
		newItem = new Book(title, year, genre, isNew, numCopies);
	} 
	else if(type.equalsIgnoreCase("eBook")) {
		System.out.println("Enter the name of the author:");
		String author = keyboard.nextLine();
		newItem = new EBook(title, year, genre, isNew, numCopies);
	}
	else if(type.equalsIgnoreCase("Audio Book")) {
		System.out.println("Enter the name of the author:");
		String author = keyboard.nextLine();
		System.out.println("Enter the name of the reader:")
		String reader = keyboard.nextLine();
		newItem = new AudioBook(title, year, genre, isNew, numCopies);
	}
	else if(type.equalsIgnoreCase("DVD")) {
		System.out.println("Enter the name of the author:");
		String author = keyboard.nextLine();
		newItem = new DVD(title, year, genre, isNew, numCopies);
	}
	else if(type.equalsIgnoreCase("Magazine")) {
	}
	else {
		System.out.println("Invalid Type");
		return;
	}
	this.addItem(newItem);
	}*/
	
}
