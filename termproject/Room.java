package termproject;

public class Room {

	private int roomNumber;
	private String roomType;
	private boolean isAvailable;
	private double nightlyRate;
	
	public Room() {	}
	
	public Room(int roomNumber, String roomType, boolean isAvailable, double nightlyRate) {
		if(nightlyRate > 0) {
			this.roomNumber = roomNumber;
			this.roomType = roomType;
			this.isAvailable = isAvailable;
			this.nightlyRate = nightlyRate;
		} else throw new InvalidRateException("Rate must be a positive number");
	}
	
	public Room(Room r) {
		this(r.roomNumber, r.roomType, r.isAvailable, r.nightlyRate);
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getNightlyRate() {
		return nightlyRate;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(o instanceof Room) {
		 Room compare = (Room) o;
		 if(this.roomNumber == compare.roomNumber) return true;}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Room:\n");
		string.append("Room Number: " + roomNumber).append("\tRoom Type: " + roomType);
		string.append("\nAvailability: " +isAvailable).append(String.format("\tNightly Rate: %.2f", nightlyRate));
		return string.toString();
	}
}
