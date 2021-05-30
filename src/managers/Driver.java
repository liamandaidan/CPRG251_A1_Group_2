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
		
		//the following 4 lines are code testing the function of the checkOutBook method
				//checkOutBook("9789560996916");//operating systems concepts has 5 available out of 8 to start
				//checkOutBook("9796356055276");//the great gatsby has 0 available out of 8
				//checkOutBook("9792662264098");//Time magazine is a periodical and cannot be checked out
				//checkOutBook("2387984712697");//testing an isbn that doesn't exist
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
		//checkOutBook();
		findBookTitle();
		displayBookType();
		produceRandomBookList();
		// Save book and exit
		saveBook();

	}

	/**
	 * @author Benson
	 */
	public void checkOutBook(String isbn) {

		if(bookExists(isbn))
		{
		 for(Book theBook: bookList)
		 {
		 	String bookCode = theBook.getIsbn();
		 	if(bookCode.equals(isbn))
		 		{
		 			if(bookType(bookCode) != 3)
		 			{
		 /*test code*///System.out.println(theBook.toString());
		 			if(theBook.getAvailable() >= 1)
		 			{
		 				theBook.setAvailable(theBook.getAvailable() - 1);
		 				System.out.println("Book checked out successfully. Enjoy your reading!");
		 /*test code*///System.out.println(theBook.toString());
		 			} else
		 			{
		  				System.out.println("Sorry, there are no more copies of this book available to check out. Please try another book.");
		  			}
		 			} else
		 			{
		 				System.out.println("Sorry, you can't check out periodicals.");
		 			}
		 		}
		 }
		} else
		{
		 	System.out.println("That ISBN does not exist in our system. Please enter a valid ISBN.");
		}
		  
		 
		 
	}

	/**
	 * This method will prompt the user to enter a title. It is case-insensitive.
	 * Will display books in table form.
	 * 
	 * @author Liam
	 * @version 1.2
	 */
	public void findBookTitle() {
		// Print to user read In From user
		Scanner input = new Scanner(System.in);
		System.out.print("Enter title to search for: ");
		String title = input.nextLine().toLowerCase();
		// Compare to the rest of the bookList. Case insensitive. Save the index Number
		// for later.
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().toLowerCase().contains(title)) {
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
	 * Method will grab x random books from user and display.
	 * 
	 * @author Liam
	 * @version 1.0
	 * 
	 * Error with scanner. So numOfBook is hard coded for now.
	 */
	public void produceRandomBookList() {
		//Scanner in = new Scanner(System.in);
		System.out.println("============================================\nRandom"); //this is temp just to show the random method
		System.out.println("Enter number of books: ");
		int numOfBook = 6; //change this to int numofBook = in.nextInt();

		for (int i = 0; i < numOfBook; i++) {
			double rand = (Math.random()*bookList.size());
			System.out.println(bookList.get((int)rand));
		}
	//	in.close();
	}

	/**
	 * 
	 */
	public void saveBook() {
		// TODO Auto-generated method stub

	}
	/**Method to check if a book exists or not
	 * 
	 * @author Benson
	 * 
	 * @param String
	 * @return boolean
	 * */
	public boolean bookExists(String isbn)
	{
		for(int i = 0; i < bookList.size(); i++)
		{
			if(bookList.get(i).getIsbn().equals(isbn))
			{
				/*test line*///System.out.println("true");
				return true;
			}
		}
		/*test line*///System.out.println("false");
		return false;
	}

}
