package problemdomain;
/**
 * 
 *	this is a sub class for the Cook Book 
 * @author Robyn
 * @version 06/02/2021
 */
public class CookBook extends Book {

	private String publisher;
	private char diet;
	
	/**
	 * CookBook constructor no args
	 */
	public CookBook() {
		super();
	}
	/**
	 * @param isbn is the book unique number
	 * @param callNumber is the book address
	 * @param available number of books
	 * @param total number of books in stock
	 * @param title of book
	 * @param publisher of book
	 * @param diet category
	 */
	public CookBook(String isbn, String callNumber,int available, int total, String title, String publisher, char diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}
	/**
	 * @param publisher is the publisher of the book
	 * @param diet is the diet type the cookbook covers
	 */
	public CookBook(String publisher, char diet) {
		super();
		this.publisher = publisher;
		this.diet = diet;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the diet
	 */
	public char getDiet() {
		return diet;
	}
	/**
	 * @param diet the diet to set
	 */
	public void setDiet(char diet) {
		this.diet = diet;
	}
	/**
	 * @return cook book details and book details toString
	 * @override
	 */
	
	public String toString() {
		String dietName;
		switch(this.diet) {
		case 'D': dietName = "Diabetic"; break;
		case 'V': dietName = "Vegetarian"; break;
		case 'G': dietName = "Gluten-free"; break;
		case 'I': dietName = "International"; break;
		case 'N': dietName = "None"; break;
		default: dietName = "Null";
		}
		
		return super.toString()+String.format("%-15s\t%s%n", "Publisher:",this.publisher)+String.format("%-15s\t%s%n", "Diet:",dietName);
	}
	

}
