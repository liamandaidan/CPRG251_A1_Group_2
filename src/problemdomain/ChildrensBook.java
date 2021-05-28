package problemdomain;

/**
 * This is the sub class for the Children book more specific type of book
 * 
 * @author mikepcann
 *
 */

public class ChildrensBook extends Book {

	private String authors;
	private char format;

	/**
	 * constructs the children book no-arg object
	 */
	public ChildrensBook() {
		super();
	}

	/**
	 * constructs the Childrens book from the Super Class
	 * 
	 * @param isbn       unique number for the book
	 * @param callNumber Call number of the book
	 * @param available  The number of books available
	 * @param total      The total number of books
	 * @param title      The title of the book
	 * @param authors    the authors of the book
	 * @param format     The type of childrens book
	 */
	public ChildrensBook(String isbn, String callNumber, int available, int total, int title, String authors,
			char format) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
	}

	/**
	 * Gets the author of the book
	 * 
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * Sets the author of the book
	 * 
	 * @param authors the authors to set
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * Gets the type of book p = Picture book, e = Early Readers, or c= Chapter
	 * book.
	 * 
	 * @return the format
	 */
	public char getFormat() {
		return format;
	}

	/**
	 * sets the format of the book
	 * 
	 * @param format the format to set
	 */
	public void setFormat(char format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "ChildrensBook: authors=" + authors + ", format=" + format + ", " + super.toString();
	}

}
