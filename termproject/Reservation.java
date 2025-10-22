package termproject;

import java.time.*;

public class Reservation {

	private Room room;
	private Guest guest;
	private BookingStatus bookingStatus;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	
	public Reservation(Room room, Guest guest, BookingStatus bookingStatus, LocalDate checkInDate, LocalDate checkOutDate) {
		if(checkInDate.isBefore(checkOutDate)) {
			this.room = new Room(room);
			this.guest = new Guest(guest);
			this.bookingStatus = bookingStatus;
			this.checkInDate = checkInDate;
			this.checkOutDate = checkOutDate;
		} else {
			throw new InvalidDateException("Check-In date must be before the Check-Out date");
		}
	}
	
	public Reservation(Room room, Guest guest, BookingStatus bookingStatus, String checkInDate, String checkOutDate) {
		this(room, guest, bookingStatus, LocalDate.parse(checkInDate), LocalDate.parse(checkOutDate));
	}
	
	public Reservation(Reservation r) {
		this(r.room, r.guest, r.bookingStatus, r.checkInDate, r.checkOutDate);
	}
	
	public Room getRoom() {
		return new Room(room);
	}

	public void setRoom(Room room) {
		this.room = new Room(room);
	}

	public Guest getGuest() {
		return new Guest(guest);
	}

	public void setGuest(Guest guest) {
		this.guest = new Guest(guest);
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		if(checkInDate.isBefore(checkOutDate)) {
			this.checkInDate = checkInDate;
		} else {
			throw new InvalidDateException("Check-In date must be before the Check-Out date");	
		}
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		if(checkInDate.isBefore(checkOutDate)) {
			this.checkOutDate = checkOutDate;
		} else {
			throw new InvalidDateException("Check-In date must be before the Check-Out date");
		}
	}
	
	@Override
	public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null) return false;
			if(o instanceof Reservation) {
				Reservation compare = (Reservation) o;
				if(this.guest.equals(compare.guest))
					return true;
			}
			return false;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Reservation:\n");
		string.append(room).append("\n" + guest);
		string.append("\nBooking Status: " + bookingStatus);
		string.append("\nCheck-In Date: " + checkInDate).append(" Check-Out Date: " + checkOutDate);
		return string.toString();
	}
	
} //Close Class
