package multiformat;

/**
 * This class is an exception that is thrown when the entered number is too high or too low.
 * 
 * @author bonnemaj
 * @version 1.0
 */
public class NumberBaseException extends Exception {
	
	/**
	 * Creates a new NumberBaseException and display the message given as parameter.
	 * @param message Message that is displayed when this exception is thrown.
	 */
	public NumberBaseException(String message)
	{
		super(message);
	}
}
