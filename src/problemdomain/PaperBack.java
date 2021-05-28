package problemdomain;

/**
 * @author bdavi
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
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param isbn
	 * @param callNumber
	 * @param total
	 * @param title
	 * @param authors
	 * @param year
	 * @param genre
	 */
	public PaperBack(String isbn, String callNumber, int total, int title, String authors, int year, char genre)
	{
		super(isbn, callNumber, total, title);
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
		return "PaperBack getAuthors()=" + getAuthors() + ", getYear()=" + getYear() + ", getGenre()=" + getGenre()
				+ ", getIsbn()=" + getIsbn() + ", getCallNumber()=" + getCallNumber() + ", getTotal()=" + getTotal()
				+ ", getTitle()=" + getTitle() + ", toString()=" + super.toString();
	}
	
	
}
