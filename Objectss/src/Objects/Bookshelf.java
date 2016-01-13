package Objects;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;

public class Bookshelf {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person  author1 = new Person("Noah", "Webster", true);
		Person  author2 = new Person("Anthony", "Burgess", true);
		Person  author3 = new Person("Philip", "K", "Dick", true);
		Book book1 = new Book("Dictionary", 1001, author1);
		Book book2 = new Book("Clockwork Orange", 749, author2);
		Book book3 = new Book("Do Androids Dream of Electirc Sheep?", 500, author3);

		
		ArrayList<Book> shelf = new ArrayList<Book>();
		shelf.add(book1);
		shelf.add(book2);
		shelf.add(book3);
		shelf.add(new Book("The Man in the High Castle",600, author3));
		Book book5 = new Book("Minorities Report", 589, author3);
		shelf.add(0,book5);
		
		book1.setJacketColor(new Color(69,69,69));
		book2.setJacketColor(Color.white);
		book3.setJacketColor(Color.orange);
		book5.setJacketColor(Color.red);
		
		ArrayList<Person> libraryCardHolders = new ArrayList<Person>();
		Person p1 = new Person("Fei", " First", true);
		Person p2 = new Person("Fei", " Second", true);
		Person p3 = new Person("Fei", " Third", true);
		libraryCardHolders.add(p1);
		libraryCardHolders.add(p2);
		libraryCardHolders.add(p3);
		
//		By page number
//		Collections.sort(shelf, new Comparator<Book>() {
//		    public int compare(Book a, Book b) {
//
//		        return a.getNumOfPages() - b.getNumOfPages();
//
//		    }
//
//		});
		
		//by last name
//		Collections.sort(shelf, new Comparator<Book>() {
//		    public int compare(Book a, Book b) {
//	
//		        return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
//	
//		    }
//
//		});
		
		//By height
//		Collections.sort(shelf, new Comparator<Book>() {
//		    public int compare(Book a, Book b) {
//
//		        return a.getHeight() - b.getHeight();
//
//		    }
//
//		});
		
		
		
		printAll(shelf);
		
		Library lib = new Library(shelf, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 

		lib.setSize(new Dimension(400,400));

		lib.setVisible(true);

		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void sortByAuthor(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
	
		       if(ascending) return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
		       return b.getAuthor().getLastName().compareTo(a.getAuthor().getLastName());
		    }

		});
	}
	
	public static void sortByHeight(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
	
		    	if(ascending)return a.getHeight() - b.getHeight();
		    	return b.getHeight() - a.getHeight();
		    }

		});
	}
	
	public static void sortByTitle(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	if(ascending) return a.getTitle().toString().compareTo(b.getTitle().toString());
		    	return b.getTitle().compareTo(a.getTitle());
		    }

		});
	}
	
	public static void sortByPageNumber(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {

		        if(ascending) return a.getNumOfPages() - b.getNumOfPages();
		        return b.getNumOfPages() - a.getNumOfPages();
		    }

		});
	}
	
	
	private static void arrayListStuff(){
//		/**
//		 * Book is a generic type. It tells the constructor what is in the array list
//		 * we use generic to save ourselves the trouble of type casting
//		 * new ArrayList<?>() constructor
//		 * length. (default is 10, adjust as you add objects)
//		 * not that ArrayList is indexed(item 0 is always at index0, item 1 is always at index 1
//		 * and so on) You can iterate through it
//		 * You cannot make an ArrayList of primitive 
//		 * (no int, boolean, etc)
//		 * If you wish to make an ArrayList of int, you use the wrapper class
//		 * Int is integer, double is double etc,
//		 */
//		
//		//adding things(for array we did: array[0] = book1
//		shelf.add(book1);
//		shelf.add(book2);
//		shelf.add(book3);
//		//you can construct at the same time
//		shelf.add(new Book("The Man in the Cigh Castle",600, author3));
//		
//		//to get something from ArrayList u do
//		System.out.println("The first book is " + shelf.get(0));
//		
//		for(Book b:shelf){
//			System.out.println(b);
//		}
//		
//		//adding object at specified indicies
//		Book book5 = new Book("Minorities Report", 589, author3);
//		shelf.add(0,book5);
//		//shelf.remove(4);
//		//shelf.remove(book1);
//		
//		//remove all book with the in name
////		for(int i = 0; i < shelf.size(); i++){
////				while(i < shelf.size() && shelf.get(i).getTitle().indexOf("The") > -1){
////					shelf.remove(i);
////				}
////		}
//		
//		//to get the length of ArrayList we call using
//		System.out.println("The size of the shelf is " + shelf.size());
//		
//		System.out.println("Using Standard for loop");
//		for(int i = 0; i < shelf.size(); i++){
//			System.out.println(shelf.get(i));
//		}
//		
//		//determine if an object is in the list
//		if(shelf.contains(book2)){
//			System.out.println(book2.getTitle() + " is book #" + 
//					shelf.indexOf(book2) + " on the shelf" );
//		}
//		
//		ArrayList<Book> creepyBooks = new ArrayList<Book>();
//		for(Book b : shelf){
//			if(b.getAuthor().toString().equals("Philip K Dick")){
//				creepyBooks.add(b);
//				b.setOnFire();
//			}
//		}
//		printAll(creepyBooks);
//		
//		
//	
	}
	
	private static void printAll(ArrayList list){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}

