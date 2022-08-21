public abstract class Title implements Comparable<Title>, Restorable{
    private String title;
    private String publisher;
    private String callNumber;
    private int year;
    private int copies;

    /***
	 * Default constructor
	 * No parameters
	 * Initializes title, publisher, callNumber, year, and copies
	 */
    protected Title(){
        this("none", "none", "none", 0, 0);
    }
    /***
	 * Constructor with three parameters
	 * @param	title for the title 
	 * @param	publisher for the publisher of the Title
	 * @param	callNumber for the title callNumber
     * @param	year for the year of publication
	 * @param	copies the number of copies
	 */
    protected Title(String title, String publisher, String callNumber, int year, int copies){
        this.title = title;
        this.publisher = publisher;
        this.callNumber = callNumber;
        this.year = year;
        this.copies = copies;
    }
    /***
	 * Getter for the title
	 * @param	no parameters
	 * @return	the value of the data member title
	 */
    public String getTitle(){
        return title;
    }
    /***
	 * Getter for the publisher of title
	 * @param	no parameters
	 * @return	the value of the data member publisher
	 */
    public String getPublisher(){
        return publisher;
    }
    /***
	 * Getter for the call number of title
	 * @param	no parameters
	 * @return	the value of the data member callNumber
	 */
    public String getCallNumber(){
        return callNumber;
    }
    /***
	 * Getter for the call number of year
	 * @param	no parameters
	 * @return	the value of the data member year
	 */
    public int getYear(){
        return year;
    }
    /***
	 * Getter for the call number of copies
	 * @param	no parameters
	 * @return	the value of the data member copies
	 */
    public int getCopies(){
        return copies;
    }
     /***
	 * Setter for the title 
	 * @param	title to set the data member title
	 * no return value
	 */
    public void setTitle(String title){
        this.title = title;
    }
    /***
	 * Setter for the publisher of the title
	 * @param	publisher to set the data member publisher
	 * no return value
	 */
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
     /***
	 * Setter for the call number of the title
	 * @param	callNumber to set the data member callNumber
	 * no return value
	 */
    public void setCallNumber(String callNumber){
        this.callNumber = callNumber;
    }
    /***
	 * Setter for the year of publication
	 * @param	year to set the data member year
	 * no return value
	 */
    public void setYear(int year){
        this.year = year;
    }
    /***
	 * Setter for the copies of the title
	 * @param	copies to set the data member copies
	 * no return value
	 */
    public void setCopies(int copies){
        this.copies = copies;
    }
    /***
	 * Method to get the String information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        String out = "";
        out = String.format("%-20s\t%-55s\t%-25s\t%-5s", callNumber, title, publisher, year);
        return out;
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
	 * Method for compareTo, which was an implemented interface in this class
	 * @param	t to compare which year ob publication is greater
	 * @return an int which tells us which year is greater or less
	 */
    public int compareTo(Title t){
        if(getYear() == t.getYear()){
            return 0;
        }
        else if(getYear() > t.getYear()){
            return 1;
        }
        else{
            return -1;
        }
    }
    /***
	 * Method to get the object information for the txt file.
	 * no parameters
	 * @return string containing the value of the data members
	 */
    public String simpleString(){
        String out;
        out = String.format("%s\n%s\n%s\n%s\n%s\n", callNumber, title, publisher, year, copies);
        return out;
    }
	  /***
	 * Method to print String information of object
	 * no parameters
	 * @return string containing the value of the data members
	 */

    public String printString(){
        String out;
        out = String.format("%s\n%s\n%s\n%s\n%s\n", "\nCall Number: " + callNumber, "\nTitle : " + title, "\nPublisher: " + publisher, "\nYear: " + year, "\nCopies " + copies);
        return out;
    }

       
}