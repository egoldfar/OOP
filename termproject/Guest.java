package termproject;

public class Guest extends Person {
	
	private String reservationNumber;
	private String phoneNumber;
	private String email;

	public Guest(String firstName, String lastName, Gender gender, Address address, String birthdate, 
				 String reservationNumber, String phoneNumber, String email) {
	super(firstName,lastName,gender,address, birthdate);
	this.reservationNumber = reservationNumber;
	this.phoneNumber = phoneNumber;
	this.email = email;
	}
	
	public Guest(Guest g) {
		this(g.getFirstName(), g.getLastName(),g.getGender(),g.getAddress(),g.getBirthdate().toString(),
			 g.reservationNumber, g.phoneNumber, g.email);
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(o instanceof Guest) {
			Guest compare = (Guest) o;
			if(this.reservationNumber.equals(compare.reservationNumber))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Guest:\n");
		string.append(super.toString() + "\n");
		string.append("Reservation Number: " + reservationNumber);
		string.append("\nPhone Number: " + phoneNumber);
		string.append("\nEmail: " + email);
		return string.toString();
	}
	
} //Close Class
