package Objects ;

import java.awt.Color;

public class Book {
	private String title;
	private int numOfPages;
	private Person author;
	private Color jacketColor;
	private boolean setOnFire;
	//H 150 and 250
	//T numOfPages / 10
	private int height;
	private int thickness;
	private boolean checkedOut;
	private long checkOutDate;
	private long dueDate;
	private String description;
	private double accumulatedUse;
	
	
	static public String[] conditions = 
	{
		"This appears to be a brand new book! How lucky!",
		"This book is very gently used.",
		"This book is missing some pages.",
		"This book was used by Fei  First.",
		"The cover is gone.",
		"A chapter was missing.",
	};
	
	
	
	public long getSecondsRemaining(){
		
		return ((dueDate - System.currentTimeMillis())/1000);
		
	}
	
	public void setCheckedOut(boolean checkOut) {
		this.checkedOut = checkOut;
	}

	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public long getDueDate() {
		return dueDate;
	}
	
	public void updateCondition(long timeOfReturn){
		accumulatedUse = (double) (accumulatedUse + (timeOfReturn - checkOutDate));
		System.out.println(accumulatedUse);
		if(accumulatedUse > 5) description=conditions[1];
		if(accumulatedUse > 10) description=conditions[2];
		if(accumulatedUse > 15) description=conditions[3];
		if(accumulatedUse > 20) description=conditions[4];
		if(accumulatedUse > 25) description=conditions[5];
	}
	
	
	public Book(String title, int numOfPages, Person author) {
		this.title = title;
		this.numOfPages= numOfPages;
		this.author = author;
		jacketColor = Color.cyan;
		setOnFire = false;
		height = (int) ((Math.random() * 100) + 150);
		thickness = numOfPages / 10;
		checkedOut = false;
		checkOutDate = 0;
		dueDate = 0;
		description = conditions[0];
		accumulatedUse = 0;
	}
	
	public String getDescription() {
		return description;
	}

	public double getAccumulatedUse() {
		return accumulatedUse;
	}

	public static String[] getConditions() {
		return conditions;
	}

	public int getHeight(){
		return height;
	}

	public int getThickness(){
		return thickness;
	}

	public Color getJacketColor() {
		return jacketColor;
	}

	public void setJacketColor(Color jacketColor) {
		this.jacketColor = jacketColor;
	}

	public String toString(){
		if(setOnFire){
			return "\"" + title + "\", by " + "dead author " + ". " + numOfPages + " pages.";
		}
		else return "\"" + title + "\", by " + author + ". " + numOfPages + " pages.";
 	}
	
	public String getTitle(){
		return title;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public Person getAuthor() {
		return author;
	}
	
	public void setOnFire(){
		jacketColor = Color.black;
		title = "The title of this book is too charred to make out.";
		setOnFire = true;
	}

	
}
