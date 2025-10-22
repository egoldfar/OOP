package termproject;

import java.util.*;

public class Hotel {
	
	private ArrayList<Room> rooms;
	private ArrayList<Reservation> reservations;
	private ArrayList<Employee> employees;

	
	public Hotel() {
		rooms = new ArrayList<Room>();
		reservations = new ArrayList<Reservation>();
		employees = new ArrayList<Employee>();
	}
	
	
	public Hotel(ArrayList<Room> rooms,	ArrayList<Reservation> reservations, ArrayList<Employee> employees) {
		
		this();
		
		this.rooms = deepCopyRooms(rooms);
		
		this.reservations = deepCopyReservations(reservations);
		
		this.employees = deepCopyEmployees(employees);
	}

	public Hotel(Hotel h) {
		this(h.rooms, h.reservations, h.employees);
	}


	public ArrayList<Room> getRooms() {
		return deepCopyRooms(rooms);
	}


	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = deepCopyRooms(rooms);
	}


	public ArrayList<Reservation> getReservations() {
		return deepCopyReservations(reservations);
	}


	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = deepCopyReservations(reservations);
	}


	public ArrayList<Employee> getEmployees() {
		return deepCopyEmployees(employees);
	}


	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = deepCopyEmployees(employees);
	}
	
	public void addRoom(Room r) {
		if(!rooms.contains(r))
			rooms.add(new Room(r));
		else 
			throw new RoomExistsException("The room is already in the system.");
		}
	
	public Room roomInfo(int rn) {
		for(int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getRoomNumber() == rn)
				return new Room(rooms.get(i));
		}
		return null;
	}
	
	public void addEmployee(Employee e) {
		if(!employees.contains(e))
			employees.add(new Employee(e));
		else 
			throw new EmployeeExistsException("The employee is already in the system.");
	}
	
	public Employee employeeInfo(String eID) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getEmployeeID().equals(eID))
				return new Employee(employees.get(i));
		}
		return null;
	}
	
	public void bookRoom(Reservation r) {
		if(!reservations.contains(r)) reservations.add(new Reservation(r));
		else throw new ReservationExistsException("That reservation already exists.");
	}
		
	public void cancelReservation(String reservationNumber) {
		for(int i = 0; i < reservations.size(); i++)
			if(reservations.get(i).getGuest().getReservationNumber().equals(reservationNumber)) {
				reservations.remove(i);
				return;
			}
			throw new ReservationNotFoundException("That reservation is not in the system.");
	}
	
	public Guest guestInfo(String rn) {
		for(int i = 0; i < reservations.size(); i++) {
			if(reservations.get(i).getGuest().getReservationNumber().equals(rn))
				return new Guest(reservations.get(i).getGuest());
		}
		return null;
	}
	
	private static ArrayList<Room> deepCopyRooms(ArrayList<Room> rooms) {
		ArrayList<Room> copy = new ArrayList<Room>();
		
		for(int i = 0; i < rooms.size(); i++) {
			copy.add(new Room(rooms.get(i)));
		}
		
		return copy;
	}
	
	
	private static ArrayList<Reservation> deepCopyReservations(ArrayList<Reservation> reservations) {
		ArrayList<Reservation> copy = new ArrayList<Reservation>();
		
		for(int i = 0; i < reservations.size(); i++) {
			copy.add(new Reservation(reservations.get(i)));
		}
		
		return copy;
	}
	
	private static ArrayList<Employee> deepCopyEmployees(ArrayList<Employee> employees) {
		ArrayList<Employee> copy = new ArrayList<Employee>();
		
		for(int i = 0; i < employees.size(); i++) {
			copy.add(new Employee(employees.get(i)));
		}
		
		return copy;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("\033[1;4mHotel:\033[0m\n");
		string.append("\033[1;4mEmployees:\033[0m\n");
		for(int i = 0; i < employees.size(); i++ ) {
			string.append(employees.get(i) + "\n");
		}
		string.append("\033[1;4mRooms:\033[0m\n");
		for(int i = 0; i < rooms.size(); i++ ) {
			string.append(rooms.get(i) + "\n");
		}
		string.append("\033[1;4mReservations:\033[0m\n");
		for(int i = 0; i < reservations.size(); i++ ) {
			string.append(reservations.get(i) + "\n");
		}
		return string.toString();
	}
	
} //Close Class
