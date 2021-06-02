package problemdomain;

/**
 * This class, inheriting from the Book class, is specifically for paperback books
 * 
 * @author bdavi
 * @version 1.2
 * */
public class PaperBack extends Book {
	
	private String authors;
	private int year;
	private char genre;
	
	
	/**
	 * constructor based on superclass
	 */
	public PaperBack()
	{
		super();
	}
	
	/**
	 * constructor calling the super as well as specific paperback parameters
	 * @param isbn
	 * @param callNumber
	 * @param available
	 * @param total
	 * @param title
	 * @param authors
	 * @param year
	 * @param genre
	 */
	public PaperBack(String isbn, String callNumber, int available, int total, String title, String authors, int year, char genre)
	{
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * @return the authors
	 */
	public String getAuthors()
	{
		return authors;
	}
	/**
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}
	/**
	 * @return the genre
	 */
	public char getGenre()
	{
		return genre;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(String authors)
	{
		this.authors = authors;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year)
	{
		this.year = year;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(char genre)
	{
		this.genre = genre;
	}
	@Override
	public String toString()
	{
		String genreType;
		switch(this.genre) {
		case 'A':
			genreType = "Adventure";
			break;
		case 'D':
			genreType = "Drama";
			break;
		case 'E':
			genreType = "Education";
			break;
		case 'C':
			genreType = "Classic";
			break;
		case 'F':
			genreType = "Fantasy";
			break;
		case 'S':
			genreType = "Science Fiction";
			break;
		default:
			genreType = "Null";
		}
		return super.toString()+String.format("%-15s\t%s%n", "Authors:",this.authors)+String.format("%-15s\t%s%n", "Year:",this.year)
	    +String.format("%-15s\t%s%n", "Genre:",genreType);
	}
	
	
}
