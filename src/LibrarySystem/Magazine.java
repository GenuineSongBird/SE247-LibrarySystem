package LibrarySystem;

public class Magazine extends Item {
private String publisher;
	
	public Magazine(String title) {
		super(title);
	}
	
public String toString() {
		return super.toString() + "\nPublisher: " + this.publisher;
	}
}
