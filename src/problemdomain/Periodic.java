package problemdomain;
/**
 * This is a test!
 * @author liamm
 * @version 1.0
 */
public class Periodic extends Book {
	private char frequency;

	/**
	 * 
	 */
	public Periodic() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isbn
	 * @param callNumber
	 * @param total
	 * @param title
	 */
	public Periodic(String isbn, String callNumber, int total, int title, char frequency) {
		super(isbn, callNumber, total, title);
		this.frequency = frequency;
	}

	/**
	 * @return the frequency
	 */
	public char getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Periodic Book: frequency=" + frequency + ", " + super.toString();
	}
	
	
}
