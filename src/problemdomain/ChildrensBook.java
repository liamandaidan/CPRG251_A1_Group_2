package problemdomain;

/**
 * This is the sub class for the Children book more specific type of book
 * 
 * @author mikepcann
 * @version
 */

public class ChildrensBook extends Book {

	private String authors;
	private char format;

	/**
	 * The no argument constructor for ChildrensBook
	 */
	public ChildrensBook() {
		super();
	}

	/**
	 * constructs the Children's book from the Super Class
	 * 
	 * @param isbn          The ISBN of the Book
	 * @param callNumber	The Call number of the Book
	 * @param available     The number of books available
	 * @param total         The total number of books
	 * @param title         The title of the book
	 * @param authors       the authors of the book
	 * @param format        The type of children's book
	 */
	public ChildrensBook(String isbn, String callNumber, int available, int total, String title, String authors,
			char format) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
	}

	/**
	 * Gets the author of the book.
	 * 
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * Sets the author of the book.
	 * 
	 * @param authors the authors of the book.
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * Gets the type of book p = Picture book, e = Early Readers, or c= Chapter
	 * book.
	 * 
	 * @return the format of the book.
	 */
	public char getFormat() {
		return format;
	}

	/**
	 * Sets the format of the book.
	 * 
	 * @param format the format of the book.
	 */
	public void setFormat(char format) {
		this.format = format;
	}

	/**
	 * Formats the output of the children's book info.
	 * 
	 * @Override
	 * @return Formatted output of the book info
	 */
	public String toString() {
		String formatType;
		switch (this.format) {
		case 'P':
			formatType = "Picture Book";
			break;
		case 'E':
			formatType = "Early Readers";
			break;
		case 'C':
			formatType = "Chapter Book";
			break;
		default:
			formatType = "Null";
		}
		return super.toString() + String.format("%-15s\t%s%n", "Authors:", this.authors)
				+ String.format("%-15s\t%s%n", "Format:", formatType);
	}

}
