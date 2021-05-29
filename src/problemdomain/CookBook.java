package problemdomain;
/**
 * @author Robyn
 * @version 05/28/21
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
	 * @param publisher
	 * @param diet
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
	@Override
	public String toString() {
		return super.toString()+String.format("%-15s\t%s%n", "Publisher:",this.publisher)+String.format("%-15s\t%s%n", "Diet:",this.diet);
	}
	

}
