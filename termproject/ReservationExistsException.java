package termproject;

public class ReservationExistsException extends RuntimeException {

	public ReservationExistsException()  {
		super("Reservation Exists");
	}
	
	public ReservationExistsException(String message)  {
		super(message);
	}
}
