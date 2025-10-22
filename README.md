# OOP
Implementing Object Oriented Programing Concepts
# 🏨 TermProject: Hotel Booking Management System

A Java-based object-oriented project that models a **hotel booking system**, including guests, employees, reservations, rooms, and hotels.  
The program demonstrates **inheritance, encapsulation, composition, and exception handling** in a realistic domain context.

---

## 📦 Package Structure
**Package name:** `termproject`

termproject/  
├── Person.java # Abstract base class for shared person attributes  
├── Guest.java # Extends Person; represents a hotel guest  
├── Employee.java # Extends Person; represents an employee with role & department  
├── Room.java # Represents a hotel room with rate & availability  
├── Reservation.java # Represents booking details for a guest and room  
├── Hotel.java # Manages rooms, guests, employees, and reservations  
└── HotelBooking.java # Driver class demonstrating the system  


---

## 🧩 Class Overview

### **Person**
- Abstract superclass for `Guest` and `Employee`.  
- Attributes: `firstName`, `lastName`, `gender`, `address`, `birthdate`.  
- Provides getters, setters, and a formatted `toString()`.

### **Guest**
- Inherits from `Person`.  
- Adds fields: `guestID`, `email`, and `phoneNumber`.  
- Used to represent hotel customers who can make reservations.

### **Employee**
- Inherits from `Person`.  
- Fields: `employeeID`, `role`, and `department`.  
- Includes equality check by `employeeID` and a detailed `toString()` output.  
- Demonstrates method overriding and polymorphism.

### **Room**
- Represents an individual hotel room.  
- Attributes: `roomNumber`, `roomType`, `isAvailable`, `nightlyRate`.  
- Includes validation for positive nightly rates via `InvalidRateException`.  
- Equality based on room number.

### **Reservation**
- Connects a `Guest` with a specific `Room` for a range of dates.  
- Likely includes methods for cost calculation, date validation, and reservation status.

### **Hotel**
- Central management class maintaining lists of:
  - `Room` objects
  - `Guest` and `Employee` records
  - `Reservation` records  
- Includes methods for adding, removing, searching, and displaying hotel data.

### **HotelBooking**
- The **main driver** demonstrating creation and management of hotel components.
- Handles user interactions, example reservations, and data printing.

---

## 🧠 Object-Oriented Design

| Concept | Implementation Example |
|----------|------------------------|
| **Encapsulation** | Private fields with public getters/setters |
| **Inheritance** | `Guest` and `Employee` inherit from `Person` |
| **Polymorphism** | Overridden `toString()` and `equals()` in subclasses |
| **Composition** | `Hotel` contains lists of `Room`, `Guest`, `Employee`, and `Reservation` |
| **Exception Handling** | Custom `InvalidRateException` for invalid nightly rates |

---

## 🧮 Example Flow

Hotel → contains Rooms, Employees, Guests, Reservations
Guest → makes Reservation → for a Room
Employee → manages Hotel operations


**Example snippet (conceptually):**
```java
Address addr = new Address("123 Main St", "New York", "NY", "10001");
Guest g1 = new Guest("Alice", "Wong", Gender.FEMALE, addr, "1990-03-15", "G001", "alice@email.com", "555-1111");
Room r1 = new Room(101, "Queen Suite", true, 180.0);
Reservation res = new Reservation(g1, r1, "2025-05-01", "2025-05-05");

Hotel h = new Hotel("Sunrise Inn");
h.addRoom(r1);
h.addGuest(g1);
h.addReservation(res);

System.out.println(h);
```

## ⚙️ Running the Project
1. Compile All Classes
```
javac termproject/*.java
```
2. Run the Main Program
```
java termproject.HotelBooking
```
## 🧪 Suggested Testing Ideas

    Attempt to create a Room with a negative rate → should throw InvalidRateException.

    Create duplicate Employee or Guest objects and check .equals() output.

    Print hotel details after multiple additions/removals.

## 🧩 UML-Style Overview
```text
          ┌─────────────────┐
          │     Person      │
          ├─────────────────┤
          │ - firstName     │
          │ - lastName      │
          │ - gender        │
          │ - address       │
          │ - birthdate     │
          └──────┬──────────┘
                 │
      ┌──────────┼──────────┐
      │                     │
      ▼                     ▼
 ┌───────────────┐     ┌──────────────┐
 │    Guest      │     │   Employee   │
 ├───────────────┤     ├──────────────┤
 │ - guestID     │     │ - employeeID │
 │ - email       │     │ - role       │
 │ - phoneNumber │     │ - department │
 └───────────────┘     └──────────────┘
 
          ┌─────────────────┐
          │      Room       │
          ├─────────────────┤
          │ - roomNumber    │
          │ - roomType      │
          │ - isAvailable   │
          │ - nightlyRate   │
          └────────┬────────┘
                   │
                   ▼
          ┌─────────────────┐
          │   Reservation   │
          ├─────────────────┤
          │ - guest         │
          │ - room          │
          │ - checkInDate   │
          │ - checkOutDate  │
          └─────────────────┘

                 ▲
                 │
          ┌──────┴────────┐
          │    Hotel      │
          ├───────────────┤
          │ - rooms       │
          │ - guests      │
          │ - employees   │
          │ - reservations│
          └───────────────┘

          ┌─────────────────┐
          │  HotelBooking   │
          ├─────────────────┤
          │ (main method)   │
          │ Demonstrates    │
          │ the system flow │
          └─────────────────┘
```

## 🧑‍💻 Author

Developed by Elisheva Goldfarb
For academic use — demonstrating principles of object-oriented software design in Java.


