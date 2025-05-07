/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: Beverage class is an abstract superclass representing a generic beverage with a name, type, and size. 
 * It can calculate the size-based price and check for equality, 
 * It is a superclass for more specific beverage types: Alcohol, Coffee, and Smoothie.
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/
public abstract class Beverage {
	private String name;
	private Type type;
	private Size size;
	private static final double BASE_PRICE = 2.0; // Base price for any beverage regardless of size.
	private static final double SIZE_PRICE = 0.5; // Additional price per size upgrade.
	
	/**
     * Constructs a Beverage object with specified name, type, and size.
     * 
     * @param name the name of the beverage
     * @param type the type of beverage (ALCOHOL, COFFEE, SMOOTHIE)
     * @param size the size of the beverage (SMALL, MEDIUM, LARGE)
     */
	public Beverage(String name, Type type, Size size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	/**
     * Calculates the price based on the size of the beverage.
     * SMALL: base price only  
     * MEDIUM: base + SIZE_PRICE  
     * LARGE: base + 2 * SIZE_PRICE
     * 
     * @return the calculated price based on size
     */
	public double addSizePrice() {
		if (size == Size.SMALL) {
			return BASE_PRICE;
		} else if (size == Size.MEDIUM) {
			return BASE_PRICE + SIZE_PRICE;
		} else {
			return BASE_PRICE + 2 * SIZE_PRICE;
		}
	}

	/**
     * Abstract method to be implemented by subclasses to calculate total price.
     * 
     * @return the total calculated price
     */
	public abstract double calcPrice();
	
	/**
     * Returns a string representation of the beverage including name and size.
     * 
     * @return formatted string with name and size
     */
	public String toString() {
		return name + ", " + size;
	}
	
	/**
     * Compares this beverage to another object for equality based on name, type, and size.
     * 
     * @param anotherBev the object to compare
     * @return true if both beverages have the same name, type, and size; false otherwise
     */
	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev) return true;                            // same object
	    if (anotherBev == null || getClass() != anotherBev.getClass()) return false; // null or different class

	    Beverage other = (Beverage) anotherBev;                         // safe cast after class check

	    return name.equals(other.name) && type == other.type && size == other.size;
	}

	/**
     * Gets the name of the beverage.
     * 
     * @return the beverage name
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name of the beverage.
     * 
     * @param name the new name to set
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Gets the type of the beverage.
     * 
     * @return the beverage type
     */
	public Type getType() {
		return type;
	}

	/**
     * Sets the type of the beverage.
     * 
     * @param type the new type to set
     */
	public void setType(Type type) {
		this.type = type;
	}

	/**
     * Gets the size of the beverage.
     * 
     * @return the beverage size
     */
	public Size getSize() {
		return size;
	}

	/**
     * Sets the size of the beverage.
     * 
     * @param size the new size to set
     */
	public void setSize(Size size) {
		this.size = size;
	}
	
}
