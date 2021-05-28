package problemdomain;

public class CookBook extends Book {
		
	private String publisher;
	private char diet;
	
	/**
	 * 
	 */
	public CookBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param isbn
	 * @param callNumber
	 * @param total
	 * @param title
	 */
	public CookBook(String isbn, String callNumber, int total, int title) {
		super(isbn, callNumber, total, title);
		// TODO Auto-generated constructor stub
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
		return "CookBook: publisher=" + publisher + ", diet=" + diet + ", toString()=" + super.toString();
	}
	

}
