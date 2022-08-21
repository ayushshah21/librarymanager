public class Periodical extends Title{
    //data members
    private int month;
    private int issueNumber;
    /***
	 * Default constructor
	 * No parameters
	 * Initializes month, issueNumber
	 */
    public Periodical(){
        super();
        month = 0;
        issueNumber = 0;
    }
    /***
	 * Constructor with seven parameters
	 * @param	title for the title 
	 * @param	publisher for the publisher of the Title
	 * @param	callNumber for the title callNumber
     * @param	year for the year of publication
	 * @param	copies the number of copies
     * @param	month for the month for periodical
	 * @param	issueNumber of periodical
	 */
    public Periodical(String title, String publisher, String callNumber, int year, int copies, int month, int issueNumber){
        super(title, publisher, callNumber, year, copies);
        this.month = month;
        this.issueNumber = issueNumber;
    }
    /***
	 * Getter for the month
	 * @param	no parameters
	 * @return	the value of the data member month
	 */
    public int getMonth(){
        return month;
    }
    /***
	 * Getter for the issueNumber
	 * @param	no parameters
	 * @return	the value of the data member issueNumber
	 */
    public int getIssueNumber(){
        return issueNumber;
    }
    /***
	 * Setter for the month 
	 * @param	month to set the data member month
	 * no return value
	 */
    public void setMonth(int month){
        this.month = month;
    }
    /***
	 * Setter for the issueNumber 
	 * @param	ISBN to set the data member issueNumber
	 * no return value
	 */
    public void setIssueNumber(int issueNumber){
        this.issueNumber = issueNumber;
    }
    /***
	 * Method to get the Periodical information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        return super.toString();
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
	 * Method to get the object information for the txt file.
	 * no parameters
	 * @return string containing the value of the data members
	 */
    public String simpleString(){
        String out;
        out = super.simpleString() + String.format("%s\n%s", month, issueNumber);
        return out;
    }
    /***
	 * Method to print String information of object
	 * no parameters
	 * @return string containing the value of the data members
	 */
    public String printString(){
        String out;
        out = "Call Number: " + super.getCallNumber() + "\nTitle : " + super.getTitle() + "\nPublisher: " + super.getPublisher() + "\nYear: " + super.getYear() + "\nCopies " + super.getCopies() + "\nMonth: " + month + "\nIssue Number: " + issueNumber;
        return out;
    }
}