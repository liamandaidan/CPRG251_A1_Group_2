package problemdomain;

/**	
 * 
 */

public class Book {
	
	private String isbn;
	private String callNumber;
	private int total;
	private int title;
	/**
	 * 
	 */
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param isbn
	 * @param callNumber
	 * @param total
	 * @param title
	 */
	public Book(String isbn, String callNumber, int total, int title) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.total = total;
		this.title = title;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the callNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}
	/**
	 * @param callNumber the callNumber to set
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the title
	 */
	public int getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(int title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book: isbn=" + isbn + ", callNumber=" + callNumber + ", total=" + total + ", title=" + title;
	}
	

	
}
