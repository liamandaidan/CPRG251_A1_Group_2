package problemdomain;

/**
 * Used to create a book object.
 * 
 * @author liamm
 * @version June/2/2021
 */

public class Book {

	private String isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;

	/**
	 * Construct Book with no arguments.
	 */
	public Book() {
		super();
	}

	/**
	 * Construct a Book object with arguments.
	 * 
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
	 * Gets the ISBN of the book.
	 * 
	 * @return Returns ISBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Sets the ISBN of the book.
	 * 
	 * @param isbn Sets the ISBN
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the call number of the book.
	 * 
	 * @return the callNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * Sets the call number of the book.
	 * 
	 * @param callNumber the callNumber to set
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/**
	 * Gets the total number of books.
	 * 
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Sets the total number of books.
	 * 
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Gets the title of the book.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the book.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the number of available books.
	 * 
	 * @return available The number of books available.
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * Sets the number of available books.
	 * 
	 * @param available the available books.
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * Returns a formatted output of the book info
	 * @Override
	 * @return Formated output
	 */

	public String toString() {

		return String.format("%-15s\t%s", "ISBN:", isbn) + String.format("%-15s\t%s", "\nCall Number:", callNumber)
				+ String.format("%-15s\t%s", "\nAvailable:", available) + String.format("%-15s\t%s", "\nTotal:", total)
				+ String.format("%-15s\t%s\n", "\nTitle:", title);
	}

}
