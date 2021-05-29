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

				// checkl the type of book
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
		String publisher = bookInfo[4];
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
	 * @author Robyn
	 */
	public void displayMenu() {
		// Todo create menu

		// From menu four functions to call
		checkOutBook();
		findBookTitle();
		displayBookType();
		produceRandomBookList();
		// Save book and exit
		saveBook();

	}

	/**
	 * @author Benson
	 */
	public void checkOutBook() {
		// TODO Auto-generated method stub

	}

	/**
	 * This method will prompt the user to enter a title. 
	 * It is case-insensitive. Will display books in table form.
	 * @author Liam
	 * @version 1.2
	 */ 
	public void findBookTitle() {
		//Print to user read In From user
		Scanner input = new Scanner(System.in);
		System.out.print("Enter title to search for: ");
		String title = input.nextLine().toLowerCase();
		//Compare to the rest of the bookList. Case insensitive. Save the index Number for later.
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().toLowerCase().contains(title)) {
				System.out.println(bookList.get(i));
			}			
		}
		input.close();
	}

	/**
	 * This will be used in the rest of the function to display book in a nice form.
	 */
	public void displayBookType() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	public void produceRandomBookList() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	public void saveBook() {
		// TODO Auto-generated method stub

	}

}
