package termproject;

public class RoomExistsException extends RuntimeException {
	
	public RoomExistsException()  {
		super("Room Exists");
	}
	
	public RoomExistsException(String message)  {
		super(message);
	}
}

