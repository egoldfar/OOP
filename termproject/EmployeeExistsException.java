package termproject;

public class EmployeeExistsException extends RuntimeException {

	public EmployeeExistsException()  {
		super("Employee Exists");
	}
	
	public EmployeeExistsException(String message)  {
		super(message);
	}
	
}
