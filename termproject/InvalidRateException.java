package termproject;


public class InvalidRateException extends RuntimeException {

	
	public InvalidRateException()  {
		super("Invalid Rate");
	}
	
	public InvalidRateException(String message)  {
		super(message);
	}
}
