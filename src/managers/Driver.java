package managers;

import problemdomain.*;

import java.io.*;
import java.util.*;

/**
 * The main part of the program to load, create, search, and process books
 * 
 * @author Liam, Robyn, Benson, Mike
 * @version 1.0
 * 
 */
public class Driver {

	private final String FILEPATH = "res/books.txt";
	private ArrayList<Book> bookList;

	/**
	 * Constructs the Driver, loads the array, displays the menu for the customer to
	 * interact with
	 */
	public Driver() {
		bookList = new ArrayList<Book>();
		loadBooks();

		// the following 4 lines are code testing the function of the checkOutBook
		// method
		// checkOutBook("9789560996916");//operating systems concepts has 5 available
		// out of 8 to start
		// checkOutBook("9796356055276");//the great gatsby has 0 available out of 8
		// checkOutBook("9792662264098");//Time magazine is a periodical and cannot be
		// checked out
		// checkOutBook("2387984712697");//testing an isbn that doesn't exist
		displayMenu();

		// The follow code is to test that all of the books were added
		// can be removed!!!!
		/*
		 * for(Book b: bookList){ System.out.println(b.getTitle()); }
		 * System.out.println(bookList.size());
		 */

	}

	/**
	 * This loads the file checks the book type and creates the matching object type
	 * and loads in into the array
	 * 
	 * @author Mike
	 */
	public void loadBooks() {
		try {
			Scanner load = new Scanner(new File(FILEPATH));
			System.out.println("Worked");

			while (load.hasNext()) {
				String[] entry = load.nextLine().split(";");

				// checks the type of book
				int type = bookType(entry[0]);

				// creates the appropriate book
				switch (type) {
				case 0:
					createChildrensBook(entry); // creates a Childrensbook and adds it to the array
					break;
				case 1:
					createCookBook(entry); // creates a Cook book and adds it to the array
					break;
				case 2:
					createPaperbackBook(entry); // creates a PaperBack and adds it to the array
					break;
				case 3:
					createPeriodical(entry); // creates a Periodical and adds it to the array
					break;
				case -1:
					System.out.println("No book created");
					break;
				default:
					System.out.println("Error");
					break;
				}
			}

			load.close();
		} catch (FileNotFoundException e) {
			System.out.println("Did not read in file properly, restart the program, and check filepath of books.txt.");
		}
	}

	/**
	 * Takes in the info about a book and creates ChildrensBook object and inserts
	 * it into bookList
	 * 
	 * @param bookInfo Information about the book
	 */
	private void createChildrensBook(String[] bookInfo) {
		String isbn = bookInfo[0];
		String callNumber = bookInfo[1];
		int available = Integer.parseInt(bookInfo[2]);
		int total = Integer.parseInt(bookInfo[3]);
		String title = bookInfo[4];
		String authors = bookInfo[5];
		char format = bookInfo[6].charAt(0);

		bookList.add(new ChildrensBook(isbn, callNumber, available, total, title, authors, format));
	}

	/**
	 * Takes in the info about a book and creates Cookbook object and inserts it
	 * into bookList
	 * 
	 * @param bookInfo Information about the book
	 */
	private void createCookBook(String[] bookInfo) {
		String isbn = bookInfo[0];
		String callNumber = bookInfo[1];
		int available = Integer.parseInt(bookInfo[2]);
		int total = Integer.parseInt(bookInfo[3]);
		String title = bookInfo[4];
		String publisher = bookInfo[5];
		char diet = bookInfo[6].charAt(0);

		bookList.add(new CookBook(isbn, callNumber, available, total, title, publisher, diet));
	}

	/**
	 * Takes in the info about a book and creates Paperback object and inserts it
	 * into bookList
	 * 
	 * @param bookInfo Information about the book
	 */
	private void createPaperbackBook(String[] bookInfo) {
		String isbn = bookInfo[0];
		String callNumber = bookInfo[1];
		int available = Integer.parseInt(bookInfo[2]);
		int total = Integer.parseInt(bookInfo[3]);
		String title = bookInfo[4];
		String authors = bookInfo[5];
		int year = Integer.parseInt(bookInfo[6]);
		char genre = bookInfo[7].charAt(0);

		bookList.add(new PaperBack(isbn, callNumber, available, total, title, authors, year, genre));
	}

	/**
	 * Takes in the info about a book and creates Periodical object and inserts it
	 * into bookList
	 * 
	 * @param bookInfo Information about the book
	 */
	private void createPeriodical(String[] bookInfo) {
		String isbn = bookInfo[0];
		String callNumber = bookInfo[1];
		int available = Integer.parseInt(bookInfo[2]);
		int total = Integer.parseInt(bookInfo[3]);
		String title = bookInfo[4];
		char frequency = bookInfo[5].charAt(0);

		bookList.add(new Periodic(isbn, callNumber, available, total, title, frequency));
	}

	/**
	 * Figures out what type of book it is based on the last number
	 * 
	 * @param isbn Unique number about a book
	 * @return book A number relating to book type
	 */
	private int bookType(String isbn) {
		int book = -1;
		int lastDigit = Integer.parseInt((isbn.substring(isbn.length() - 1)));

		if (lastDigit == 0 || lastDigit == 1) {
			book = 0;
			return book; // childrensBook
		} else if (lastDigit == 2 || lastDigit == 3) {
			book = 1;
			return book; // cookBook
		} else if (lastDigit >= 4 && lastDigit <= 7) {
			book = 2;
			return book; // paperBack
		} else if (lastDigit == 8 || lastDigit == 9) {
			book = 3;
			return book; // Periodicals
		}

		return book;
	}

	/**
	 * this displays the menu for the user to choose from
	 * 
	 * @author Robyn
	 */
	public void displayMenu() {
		/**
		 * @param option           is selections made by user
		 * @param isbnSelection    is the isbn entered by user
		 * @param bookTitle        is the title of the book the user searches for
		 * @param typeOfBook       is the type of book the user enters
		 * @param numOfRandomBooks is the number of books the user wants to randomly
		 *                         display
		 * @param freqSelected     is the frequency of the periodic book the user enters
		 * 
		 */

		String option;
		String isbnSelection;
		String bookTitle;
		String displayBookOfType;
		int typeOfBook;
		int numOfRandomBooks;
		char freqSelected;

		Scanner in = new Scanner(System.in);

		System.out.printf("Welcome to the ABC Book Company: How may we assist you?%n" + "1. Checkout Book%n"
				+ "2. Find Books by Title%n" + "3. Display Books by Type%n" + "4. Produce Random Book List%n"
				+ "5. Save & Exit%n%n");

		System.out.printf("Enter option: ");
		option = in.nextLine();

		while (!option.equals("5")) {
			switch (option) {
			case "1":
				System.out.printf("Enter the ISBN of book: ");
				isbnSelection = in.nextLine();
				checkOutBook(isbnSelection);
				break;
			case "2":
				System.out.printf("Enter the title to search for: ");
				bookTitle = in.nextLine();
				findBookTitle(bookTitle);
				break;
			case "3":
				System.out.printf("#  Type%n" + "1. Children's Books%n" + "2. CookBooks%n" + "3. Paperbacks%n"
						+ "4. Periodicals%n%n");
				System.out.printf("Enter type of book: ");

				displayBookOfType = in.nextLine();
				if ("1234".contains(displayBookOfType)) {
					typeOfBook = Integer.parseInt(displayBookOfType);
					if (typeOfBook == 4) {
						System.out.printf("%nEnter a frequency (D for Daily, W for Weekly, "
								+ "M for Monthly, B for Biweekly, or Q for Quarterly): ");
						freqSelected = in.nextLine().charAt(0);
						showBookType(typeOfBook, freqSelected); // displayFrequency method needed!
					} else {
						showBookType(typeOfBook);
					}
					break;
				} else {
					System.out.println("Enter a valid book type (1-4):\n");
					continue;
				}
			case "4":
				System.out.printf("Enter number of books: ");
				numOfRandomBooks = Integer.parseInt(in.nextLine());
				if (numOfRandomBooks <= 50 && numOfRandomBooks >= 0) {
					produceRandomBookList(numOfRandomBooks);
				} else {
					System.out.println("Wrong user Input. Please use an appropriate number from 1-50.");
					continue;
				}
				break;

			default:
				System.out.println("Please enter an appropriate choice (1-4):\n");
				break;
			}
			System.out.printf("Welcome to the ABC Book Company: How may we assist you?%n" + "1. Checkout Book%n"
					+ "2. Find Books by Title%n" + "3. Display Books by Type%n" + "4. Produce Random Book List%n"
					+ "5. Save & Exit%n%n");

			System.out.printf("Enter option: ");

			option = in.nextLine();
		}
		saveBook();
		in.close();
	}

	/**
	 * The purpose of this method will be to process user input, search for book
	 * types and display.
	 * 
	 * @author Liam
	 * @param typeOfBook 1 for childernsBook, 2 for cookBook, 3 for paperback, 4 for
	 *                   Periodic
	 * @version 1.0
	 */
	private void showBookType(int typeOfBook) {
		for (int i = 0; i < bookList.size(); i++) {
			if (typeOfBook - 1 == bookType(bookList.get(i).getIsbn())) { // 0=ChildernsBook 1=cookBook 2=paperback
																			// 3=Periodic
				System.out.println(bookList.get(i));
			}
		}
	}

	/**
	 * The purpose of this method will be to process user input, search for book
	 * type 4 and display.
	 * 
	 * @author Liam
	 * @param typeOfBook   Integer being 4 for Periodic
	 * @param freqSelected Char D, W, M, B, Q
	 * @version 1.0
	 */
	private void showBookType(int typeOfBook, char freqSelected) {
		// we are going to print all periodic then print all freqSelected
		final int PERIODIC = 3;
		for (int i = 0; i < bookList.size(); i++) {
			if (PERIODIC == bookType(bookList.get(i).getIsbn())) { // 3=Periodic
				if (((Periodic) bookList.get(i)).getFrequency() == freqSelected) {// check to see if freq is same
					System.out.println(bookList.get(i));
				}
			}
		}
	}

	/**
	 * @author Benson
	 */
	public void checkOutBook(String isbn) {

		if (bookExists(isbn)) {
			for (Book theBook : bookList) {
				String bookCode = theBook.getIsbn();
				if (bookCode.equals(isbn)) {
					if (bookType(bookCode) != 3) {
						/* test code */// System.out.println(theBook.toString());
						if (theBook.getAvailable() >= 1) {
							theBook.setAvailable(theBook.getAvailable() - 1);
							System.out.println("Book checked out successfully. Enjoy your reading!");
							/* test code */// System.out.println(theBook.toString());
						} else {
							System.out.println(
									"Sorry, there are no more copies of this book available to check out. Please try another book.");
						}
					} else {
						System.out.println("Sorry, you can't check out periodicals.");
					}
				}
			}
		} else {
			System.out.println("That ISBN does not exist in our system. Please enter a valid ISBN.");
		}

	}

	/**
	 * This method will prompt the user to enter a title. It is case-insensitive.
	 * Will display books in table form.
	 * 
	 * @author Liam
	 * @param title name to search bookList with.
	 * @version 1.6
	 */
	public void findBookTitle(String title) {
		// find error case of title not matching
		boolean match = false;
		for (int i = 0; i < bookList.size(); i++) {
			// The line below contains the issue to fix
			// Find text with Contains OR find text with the full title
			if (bookList.get(i).getTitle().toLowerCase().contains(title.toLowerCase())
					|| bookList.get(i).getTitle().toLowerCase().equals(title.toLowerCase())) {
				match = true;
				System.out.println(bookList.get(i));
			}
		}
		if (!match) {
			System.out.println("Could not find the book Title");
		}
	}

	/**
	 * Method will grab x random books from user and display random books.
	 * 
	 * @author Liam
	 * @param numOfbooks this will take in the number of books from user.
	 * @version 1.2
	 * 
	 */
	public void produceRandomBookList(int numOfBooks) {
		for (int i = 0; i < numOfBooks; i++) {
			double rand = (Math.random() * bookList.size());
			System.out.println(bookList.get((int) rand));
		}
	}

	/**
	 * @author
	 */
	public void saveBook() {
		// get type of Book
		// hello
		String formated;
		String title;

		for (int i = 0; i < bookList.size(); i++) {
			int type = bookType(bookList.get(i).getIsbn());
			switch (type) {
			case 0: // ChildernsBook
				formated = String.format("%s;%s;%d;%d;%s;%s;%c", bookList.get(i).getIsbn(),
						bookList.get(i).getCallNumber(), bookList.get(i).getAvailable(), bookList.get(i).getTotal(),
						bookList.get(i).getTitle(), ((ChildrensBook) bookList.get(i)).getAuthors(),
						((ChildrensBook) bookList.get(i)).getFormat());
				break;
			case 1: // CookBook @benson
				formated = String.format("%s;%s;%s;%s;", null);
				break;
			case 2: // PaperBack
				formated = String.format("%s;%s;%s;%s;%s;%s;%s;%s", bookList.get(i).getIsbn(),
						bookList.get(i).getCallNumber(), bookList.get(i).getAvailable(), bookList.get(i).getTotal(),
						bookList.get(i).getTitle(), ((PaperBack) bookList.get(i)).getAuthors(),
						((PaperBack) bookList.get(i)).getYear(), ((PaperBack) bookList.get(i)).getGenre());
				break;
			case 3: // periodic
				formated = String.format("%s;%s;%s;%s;%s;%s;", bookList.get(i).getIsbn(),
						bookList.get(i).getCallNumber(), bookList.get(i).getAvailable(), bookList.get(i).getTotal(),
						bookList.get(i).getTitle(), ((Periodic) bookList.get(i)).getFrequency());
				break;
			default:
				formated = "Null";
			}
			System.out.println(formated);
		}

		// String for each book - 9791149311508;050;0;5;Men's Health;M

		// wipe file
		// printWrite to that books.txt
	}

	/**
	 * Method to check if a book exists or not
	 * 
	 * @author Benson
	 * 
	 * @param String
	 * @return boolean
	 */
	public boolean bookExists(String isbn) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getIsbn().equals(isbn)) {
				/* test line */// System.out.println("true");
				return true;
			}
		}
		/* test line */// System.out.println("false");
		return false;
	}

}
