
public class DatabaseTester {
	public static void main(String[] args) {
		itemDatabase iDatabase  = itemDatabase.getInstance();
		iDatabase.loadDatabase();
		iDatabase.printDB();
	}
}
