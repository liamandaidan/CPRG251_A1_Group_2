package problemdomain;

/**
 * Create a Periodic object that is a subclass of Book.
 * 
 * @author liamm
 * @version June/2/2021
 */
public class Periodic extends Book {
	private char frequency;

	/**
	 * Construct a Periodic without parameters
	 */
	public Periodic() {
		super();
	}

	/**
	 * Construct a Periodic with parameters.
	 * 
	 * @param isbn       The ISBN of the Book
	 * @param callNumber The Call number of the Book
	 * @param available  How many books are avaliable
	 * @param total      How many books there are in total
	 * @param title      The name of the book
	 * @param frequency  What type of Frequency
	 */
	public Periodic(String isbn, String callNumber, int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	/**
	 * Will get the frequency and return as a char.
	 * @return the frequency.
	 */
	public char getFrequency() {
		return frequency;
	}

	/**
	 * Will set the frequency requiring a char.
	 * @param frequency the frequency to set.
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}
	/**
	 * Will display the frequency nicely when used.
 	 * @Override
	 */
	public String toString() {
		String freqName;
		switch (this.frequency) {
		case 'D':
			freqName = "Daily";
			break;
		case 'W':
			freqName = "Weekly";
			break;
		case 'M':
			freqName = "Monthly";
			break;
		case 'B':
			freqName = "Bimonthly";
			break;
		case 'Q':
			freqName = "Quarterly";
			break;
		default:
			freqName = "Null";
			break;
		}
		return super.toString() + String.format("%-15s\t%s%n", "Frequency:", freqName);
	}

}
