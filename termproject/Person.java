package termproject;

import java.time.*;

public class Person {
	
	private String firstName;
	private String lastName;
	private Gender gender;
	private Address address;
	private LocalDate birthdate;
	
	public Person(String firstName, String lastName, Gender gender, Address address, LocalDate birthdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.birthdate = birthdate;		
	}
	
	public Person(String firstName, String lastName, Gender gender, Address address, String birthdate) {
		this(firstName, lastName, gender, address, LocalDate.parse(birthdate));
	}
	
	public Person(String firstName, String lastName, Gender gender, String street, String city, String state, String zipcode, String birthdate) {
		this(firstName, lastName, gender, new Address(street, city, state, zipcode), LocalDate.parse(birthdate));
	}
	
	public Person(Person p) {
		this(p.firstName, p.lastName, p.gender, p.address, p.birthdate);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = new Address(address);
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Person:\n");
		string.append("Name: " + firstName + " " + lastName );
		string.append("\nGender: " + gender).append(" Birthdate: " + birthdate);
		string.append("\n" + address);
		return string.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(o instanceof Person) {
			Person compare = (Person) o;
			if(this.firstName != null ? firstName.equals(compare.firstName): compare.firstName == null)
				if(this.lastName != null ? lastName.equals(compare.lastName): compare.lastName == null)
					if(this.birthdate.isEqual(compare.birthdate))
						return true;
		}
		return false;
	}
	
}
