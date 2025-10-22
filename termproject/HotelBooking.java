package termproject;

import java.util.*;
import java.time.format.*;


//Elisheva Goldfarb
//06/15/2025


public class HotelBooking {

	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {

		Hotel hotel = new Hotel();
		hotel.setRooms(createRooms());
		hotel.setReservations(createReservations(hotel));
		hotel.setEmployees(createEmployees());
		System.out.print(hotel);
		
		int menu = intInput("Would you like the menu for a\n1. Manager\n2. Guest\nChoice: ", 1, 2);
		int choice;
		switch (menu) {
		case 1: 
			do {
				choice = managerMenu();
				switch(choice) {
				case 1: bookReservation(hotel); break;
				case 2: cancelReservation(hotel); break;
				case 3: roomInfo(hotel); break;
				case 4: guestInfo(hotel); break;
				case 5: addEmployee(hotel); break;
				case 6: addRoom(hotel); break;
				case 7: System.out.println(hotel); break;
				}
			}while(choice != 8);
			break;
		case 2: 
			do {
				choice = guestMenu();
				switch(choice) {
				case 1: bookReservation(hotel); break;
				case 2: cancelReservation(hotel); break;
				case 3: roomInfo(hotel); break;
				case 4: guestInfo(hotel); break;
				}
			}while(choice != 5);
			break;
		}
	
		System.out.print("You are exiting the program. Goodbye!");
		keyboard.close();
	}
	
	public static int guestMenu() {
		System.out.println("Menu:\n" 
						+	"1. Booking Reservation\n"
						+ 	"2. Cancel Reservation\n"
						+	"3. View Room Details\n"
						+ 	"4. Viewing Guest Details\n"
						+ 	"5. Exit program");
		int choice = intInput("Choice: ", 1, 5);
		return choice;
	}
	
	public static int managerMenu() {
		System.out.println("Menu:\n" 
				+	"1. Booking Reservation\n"
				+ 	"2. Cancel Reservation\n"
				+	"3. View Room Details\n"
				+ 	"4. Viewing Guest Details\n"
				+	"5. Add Employee\n"
				+	"6. Add Room\n"
				+	"7. Veiw Hotel Information\n"
				+ 	"8. Exit program");
		int choice = intInput("Choice: ", 1, 8);
		return choice;
	}
	public static void bookReservation(Hotel h) {
		System.out.println("Please enter the reservation information.");
		Reservation r = createReservation(h);
		try {
			h.bookRoom(r);
		} catch (ReservationExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void cancelReservation(Hotel h) {
		System.out.print("What is the number of the reservation that you'd like to cancel? ");
		String rn = keyboard.nextLine();
		try {
			h.cancelReservation(rn);
		} catch (ReservationNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void roomInfo(Hotel h) {
		int rn = intInput("What is the number of the room that you would like the information on? ", 0, 9999);
		Room r = h.roomInfo(rn);
		if(r != null)
			System.out.println(r);
		else 
			System.out.println("Room Not Found");
	}
	
	public static void guestInfo(Hotel h) {
		System.out.println("What is the reservation number of the guest that you'd like to find their information? ");
		String rn = keyboard.nextLine();
		Guest g = h.guestInfo(rn);
		if(g != null)
			System.out.println(g);
		else 
			System.out.println("Guest Not Found");
	}
	
	public static void addEmployee(Hotel h) {
		Employee employee = createEmployee();
		try {
			h.addEmployee(employee);
		} catch (EmployeeExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void addRoom(Hotel h) {
		Room r = createRoom();
		try {
			h.addRoom(r);
		} catch (RoomExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static ArrayList<Room> createRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		int amount = intInput("How many rooms are in the hotel? ", 0, 300);	
			for(int i = 0; i < amount; i++) {
				Room r = createRoom();
				rooms.add(r);
		}
		return rooms;
	}
	
	public static ArrayList<Reservation> createReservations(Hotel h) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		int amount = intInput("How many reservations would you like to put into the system? ", 0, 500);	
		for(int i = 0; i < amount; i++) {
			Reservation r = createReservation(h);	
			reservations.add(r);
		}
		return reservations;
	}
	
	public static ArrayList<Employee> createEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		int amount = intInput("How many employees would you like to put into the system?  ", 0, 1500);	
		for(int i = 0; i < amount; i++) {
			Employee e = createEmployee();
			employees.add(e);
		}
		return employees;
	}
	
	public static Room createRoom() {
		Room r = null;
		int rn = intInput("What is the room number? ", 0, 9999);
		System.out.print("What is the room type? ");
		String roomType = keyboard.nextLine();
		System.out.print("Is the room available? (y/n) ");
		boolean availability = (keyboard.nextLine().toUpperCase().charAt(0) == 'Y'? true: false);
		boolean validRate = false;
		while(!validRate)
		try {
			System.out.print("What is the nightly rate? ");
			double nr = keyboard.nextDouble(); keyboard.nextLine();
			r = new Room(rn, roomType, availability, nr);
			validRate = true;
		} catch (InvalidRateException e) {
			System.out.println(e.getMessage());
			
		}
		return r;
	}
	
	public static Employee createEmployee() {
		System.out.println("Please enter the employee's information.");
		Person p = createPerson();
		System.out.println("What is the employee's ID? "); String ID = keyboard.nextLine();
		System.out.println("What is the employee's role? "); String role = keyboard.nextLine();
		System.out.println("What is the employee's department? "); String department = keyboard.nextLine();
		Employee e = new Employee(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), p.getBirthdate().toString(), ID, 
				role, department);
		return e;
	}
	
	public static Guest createGuest() {
		System.out.println("Please enter the guest's information.");
		Person p = createPerson();
		System.out.println("What is the guest's reservation number? "); String reservationNumber = keyboard.nextLine();
		System.out.println("What is the guest's phone number? "); String phoneNumber = keyboard.nextLine();
		System.out.println("What is the guest's email? "); String email = keyboard.nextLine();
		
		Guest g = new Guest(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), p.getBirthdate().toString(), 
				  reservationNumber, phoneNumber, email);
		return g;
	}
	
	public static Reservation createReservation(Hotel h) {
		int rn = intInput("What is the room number for this reservation? ", 0, 9999);
		Room room = h.roomInfo(rn);
		while (room == null) {
			System.out.println("There is no such room in the hotel");
			rn = intInput("What is the room number for this reservation? ", 0, 9999);
			room = h.roomInfo(rn);
		}
		Guest g = createGuest();
		BookingStatus bs = createBookingStatus();
		System.out.println("What is the check-in date? (YYYY-MM-DD) "); String checkin = keyboard.nextLine();
		System.out.println("What is the check-out date? (YYYY-MM-DD) "); String checkout = keyboard.nextLine();
		Reservation r = makeReservation(room, g, bs, checkin, checkout);
		while (r == null) {
			System.out.println("Please reenter the check-in date: (YYYY-MM-DD) "); checkin = keyboard.nextLine();
			System.out.println("Please reenter the check-out date: (YYYY-MM-DD) "); checkout = keyboard.nextLine();
			r = makeReservation(room, g, bs, checkin, checkout);	
		}
		return r;
	}
		
	public static Reservation makeReservation(Room room, Guest guest, BookingStatus bookingStatus, String checkInDate, String checkOutDate) {
		try {
			Reservation r = new Reservation(room, guest, bookingStatus, checkInDate, checkOutDate);
			return r;
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
		} catch (DateTimeParseException e) {
			System.out.println("Invalid Date Format: " + e.getMessage());
		}
		return null;
	}
	
	public static int intInput(String question, int min, int max) {
		while(true)
			try {
				System.out.print(question);
				int integer = keyboard.nextInt();
				while(integer < min || integer > max) {
					System.out.println("Invalid Input");
					System.out.print(question);
					integer = keyboard.nextInt();
					}
				keyboard.nextLine();
				return  integer;
				}	
			catch(InputMismatchException e){
				System.out.println("Input must be an integer");
				keyboard.nextLine();
				}
	}
	
	public static Person createPerson() {
		System.out.print("What is the persons's first name? "); String firstName = keyboard.nextLine();
		System.out.print("What is the person's last name? "); String lastName = keyboard.nextLine();
		System.out.print("What is the person's gender? (F/M) "); char c = keyboard.nextLine().toUpperCase().charAt(0);
		while(c != 'F' && c != 'M') {
			System.out.println("Input must be either F or M.");
			System.out.print("What is the person's gender? (F/M) "); c = keyboard.nextLine().toUpperCase().charAt(0);
		}
		Gender gender = null;
		switch(c) {
		case 'F': gender = Gender.F; break;
		case 'M': gender = Gender.M; break;
		}
		System.out.println("Please enter the person's address.");
		Address address = createAddress();
		System.out.println("Please enter the person's birthday: (YYYY-MM-DD) "); String birthday = keyboard.nextLine();
		Person p = new Person(firstName, lastName, gender, address, birthday);
		return p;
		
	}
	
	public static Address createAddress() {
		System.out.print("What is the street adress? "); String street = keyboard.nextLine();
		System.out.print("What is the city? "); String city = keyboard.nextLine();
		System.out.print("What is the state? "); String state = keyboard.nextLine();
		System.out.print("What is the zipcode? "); String zc = keyboard.nextLine();
		Address a = new Address(street, city, state, zc);
		return a;
	}
	
	public static BookingStatus createBookingStatus() {
		int choice = intInput("What is the booking status of this reservation?\n"
						+   "1. Confirmed\n"
						+	"2. Pending\n"
						+	"3. Canceled\n"
						+ 	"Choice: ", 1, 3);
		switch(choice) {
		case 1: return BookingStatus.CONFIRMED;
		case 2: return BookingStatus.PENDING;
		case 3: return BookingStatus.CANCELLED;
		default: return null;
		}
	}
	
} //close class
