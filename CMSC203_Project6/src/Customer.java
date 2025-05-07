/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: Customer class class represents a customer with a name and age.
 * It provides constructors for creating a new customer or copying an existing one.
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/
public class Customer {
	private String name;
	private int age;
	
	/**
	 * Constructs a Customer object with the specified name and age.
	 * 
	 * @param name the name of the customer
	 * @param age  the age of the customer
	 */
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Copy constructor. Creates a new Customer object by copying another Customer.
	 * 
	 * @param c the Customer object to copy
	 */
	public Customer(Customer c) {
		this.name = c.name;
		this.age = c.age;
	}
	
	/**
	 * Returns a string representation of the customer.
	 * 
	 * @return a string in the format "name, age"
	 */
	public String toString() {
		return name + ", " + age;
	}

	/**
	 * Gets the name of the customer.
	 * 
	 * @return the customer's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the customer.
	 * 
	 * @param name the new name for the customer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the age of the customer.
	 * 
	 * @return the customer's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of the customer.
	 * 
	 * @param age the new age for the customer
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
