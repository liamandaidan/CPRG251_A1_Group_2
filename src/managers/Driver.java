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
	 * 
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
	 * 
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
	 * 
	 */
	public void checkOutBook() {
		// TODO Auto-generated method stub

	}
	/**
	 * 
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
