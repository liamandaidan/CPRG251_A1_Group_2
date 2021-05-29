package managers;

import problemdomain.*;
import java.io.*;
import java.util.*;

/**
 * 
 * @author Liam, Robyn, Benson, Mike
 * @version 1.0
 * 
 */
public class Driver {

	private final String FILEPATH = "res/books.txt";
	private ArrayList<Book> bookList;

	/**
	 * 
	 */
	public Driver() {
		bookList = new ArrayList<Book>();
		loadBooks();
		displayMenu();
	}

	/**
	 * @author Mike
	 */
	public void loadBooks() {
		try {
			Scanner load = new Scanner(new File(FILEPATH));
			System.out.println("Worked");

		} catch (FileNotFoundException e) {
			System.out.println("Did not read in file properly, restart the program, and check filepath of books.txt.");
		}
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
	 *  @author Benson
	 */
	public void checkOutBook(String isbn) {
		// TODO Auto-generated method stub
		//take argument of book ISBN no. and locate that item in the arraylist
		//check that object's available count. If the count is 0, deny the request. If the count is 1 or more, reduce the count by 1 and display an approval message
		/*	
		 * for(Book theBook: bookList)
		 * {
		 * 		String bookCode = theBook.getIsbn();
		 * 		if(bookCode.equals(isbn)
		 * 		{
		 * 			if(theBook.getAvailable() >= 1)
		 * 			{
		 * 				theBook.setAvailable(theBook.getAvailable() - 1);
		 * 			} else
		 * 			{
		 * 				System.out.println("Sorry, there are no more copies of this book available to check out. Please try another book.");
		 * 			}
		 * 		}
		 * }
		 * */
	}
	/**
	 *  @author Liam
	 */
	public void findBookTitle() {
		// TODO Auto-generated method stub

	}
	/**
	 * 
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
