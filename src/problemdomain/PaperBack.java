package problemdomain;

/**
 * @author bdavi
 * */
public class PaperBack extends Book {
	
	private String authors;
	private int year;
	private char genre;
	
	
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
	
	
}
