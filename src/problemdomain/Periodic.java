package problemdomain;
/**
 * This is a test!
 * @author liamm
 * @version 1.5
 * Change log: updated toString to display better.
 */
public class Periodic extends Book {
	private char frequency;

	/**
	 * Constructor calls super no inputs.
	 */
	public Periodic() {
		super();
	}

	/**
	 * @param isbn of book.
	 * @param callNumber of book.
	 * @param available of book.
	 * @param total of how many books are left.
	 * @param title of book.
	 * @param frequency of book.
	 */
	public Periodic(String isbn, String callNumber,int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	/**
	 * @return the frequency.
	 */
	public char getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set.
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%-15s\t%s%n", "Frequency:",this.frequency);
	}


	
	
}
