package Objects;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	public static int MAX_ALLOWED_BOOKS = 3;
	private boolean male;
	private Balance balance;
	private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
	

	//constructor
	//no return type: it "returns" a Person
	public Person(String firstName, String lastName, boolean male){
		this.firstName = firstName; //assign firstName to fN
		middleName = "";
		this.lastName = lastName;//this is used to specify the field
		checkedOutBooks = new ArrayList<Book>();
		this.male = male;
		balance = new Balance();
		//whereas lastName is used as local parameter
	}
	
	public String getGenderPosessivePronoun(){
		
		if(male) return "his";
		return "her";
		
	}
	
	public Balance getBalance() {
		return balance;
	}

	public String getLibraryDescription(){
		return getFirstName() + " is thinking of borrowing a book. " +  getFirstName() + "'s balance is " + getBalance().getAmount();
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void checkOutBook(Book thing){
		thing.setCheckedOut(true);
		thing.setCheckOutDate(System.currentTimeMillis()/1000);
		thing.setDueDate(System.currentTimeMillis()+30000);
		checkedOutBooks.add(thing);
	}
	
	public void renewBook(Book thing){
		thing.setDueDate(System.currentTimeMillis()+30000);
	}
	
	public void returnBook(Book thing){
		thing.setCheckedOut(false);
		thing.updateCondition(System.currentTimeMillis()/1000);
		Balance.subtractLateFees((System.currentTimeMillis() - thing.getDueDate())/1000);
		thing.setCheckOutDate(0);
		thing.setDueDate(0);
		checkedOutBooks.remove(thing);
	}
	//constructor for middle name
	public Person(String firstName, String middleName, String lastName,  boolean male){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.male = male;
		checkedOutBooks = new ArrayList<Book>();
		balance = new Balance();
	}
	
	public ArrayList<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}

	public boolean isMale() {
		return male;
	}

	
	public String toString(){
		return firstName + " " + middleName + " " + lastName;
	}
}
