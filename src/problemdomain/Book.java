package problemdomain;

/**
 * Used to create a book object.
 * 
 * @author liamm
 * @version 1.5
 */

public class Book {

	private String isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;

	/**
	 * Create Book with no arguments.
	 */
	public Book() {
		super();
	}

	/**
	 * Create a Book object with arguments.
	 * todo more detail
	 * @param isbn       The ISBN of the Book
	 * @param callNumber The Call number of the Book
	 * @param available  How many books are avaliable
	 * @param total      How many books there are in total
	 * @param title      The name of the book
	 */
	public Book(String isbn, String callNumber, int available, int total, String title) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}
	
	
	/** 
	 * @return Returns ISBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn Sets the ISBN
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
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {

		return String.format("%-15s\t%s", "ISBN:", isbn) + String.format("%-15s\t%s", "\nCall Number:", callNumber)
				+ String.format("%-15s\t%s", "\nAvailable:", available) + String.format("%-15s\t%s", "\nTotal:", total)
				+ String.format("%-15s\t%s\n", "\nTitle:", title);
	}

}
