public class Book extends Title{
    //data members
    private Long ISBN;
    private String author;
    /***
	 * Default constructor
	 * No parameters
	 * Initializes ISBN, author
	 */
    public Book(){
        super();
        ISBN = 0L;
        author = "none";
    }

    /***
	 * Constructor with seven parameters
	 * @param	title for the title 
	 * @param	publisher for the publisher of the Title
	 * @param	callNumber for the title callNumber
     * @param	year for the year of publication
	 * @param	copies the number of copies
     * @param	ISBN for the book ISBN #
	 * @param	author author of book
	 */
    public Book(String title, String publisher, String callNumber, int year, int copies, Long ISBN, String author){
        super(title, publisher, callNumber, year, copies);
        this.ISBN = ISBN;
        this.author = author;
    }
    /***
	 * Getter for the ISBN
	 * @param	no parameters
	 * @return	the value of the data member ISBN
	 */
    public Long getISBN(){
        return ISBN;
    }
    /***
	 * Getter for the title
	 * @param	no parameters
	 * @return	the value of the data member author
	 */
    public String getAuthor(){
        return author;
    }
    /***
	 * Setter for the ISBN 
	 * @param	ISBN to set the data member ISBN
	 * no return value
	 */
    public void setISBN(Long ISBN){
        this.ISBN = ISBN;
    }
    /***
	 * Setter for the author 
	 * @param	author to set the data member author
	 * no return value
	 */
    public void setAuthor(String author){
        this.author = author;
    }
    /***
	 * Method overidden from interface to check if a title is restorable
	 * no parameters
	 * @return boolean which determines if a title is restorable
	 */
    public boolean isRestorable(){
        boolean restorable = false;
        if(getYear() < 2002){
            restorable = true;
        }
        return restorable;
    }
     /***
	 * Method to get the String information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        return super.toString();
    }
    /***
	 * Method to get the object information for the txt file.
	 * no parameters
	 * @return string containing the value of the data members
	 */
    public String simpleString(){
        String out;
        out = super.simpleString() + String.format("%s\n%s", author, ISBN);
        return out;
    }
     /***
	 * Method to print String information of object
	 * no parameters
	 * @return string containing the value of the data members
	 */
    public String printString(){
        String out;
        out = "Call Number: " + super.getCallNumber() + "\nTitle : " + super.getTitle() + "\nPublisher: " + super.getPublisher() + "\nYear: " + super.getYear() + "\nCopies " + super.getCopies() + "\nAuthor: " + author + "\nISBN: " + ISBN;
        return out;
    }
}