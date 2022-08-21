import java.util.InputMismatchException;

public class InvalidDataException extends InputMismatchException{
    /***
     * Default constructor
     * No parameters
     * calls super class with String message
     */
    public InvalidDataException(){
        super("Invalid Data");
    }
    /***
	 * Constructor with one parameter
	 * @param	message for the message of InvalidRatingException
     * sends message to parent class to be received.
	 */
    public InvalidDataException(String message){
        super(message);
    }
}
