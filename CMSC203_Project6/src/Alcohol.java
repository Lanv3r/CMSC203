/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: Alcohol class is a subclass of Beverage that represents an alcoholic drink with an optional weekend price charge.
 *  It calculates the final price based on size and whether the drink is ordered on a weekend.
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/
/**
 * Represents an alcoholic beverage, which is a type of Beverage.
 * Adds logic for weekend pricing surcharge.
 * 
 */
public class Alcohol extends Beverage {
	private static final double WEEKEND_PRICE = 0.6; // Additional charge if ordered on weekend
	private boolean isWeekend;
	
	/**
     * Constructs an Alcohol object with the specified name, size, and weekend status.
     *
     * @param name the name of the beverage
     * @param size the size of the beverage (SMALL, MEDIUM, LARGE)
     * @param isWeekend true if ordered on a weekend, false otherwise
     */
	public Alcohol(String name, Size size, boolean isWeekend) {
		super(name, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	/**
     * Checks if the beverage is ordered on a weekend.
     *
     * @return true if ordered on weekend, false otherwise
     */
	public boolean isWeekend() {
		return isWeekend;
	}

	/**
     * Sets whether the beverage is ordered on a weekend.
     *
     * @param isWeekend true if ordered on a weekend, false otherwise
     */
	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}

	/**
     * Returns a string representation of the Alcohol object, including
     * name, size, weekend status, and calculated price.
     *
     * @return string with details of the beverage
     */
	public String toString() {
		// String representation of Alcohol object including weekend status and price
		return getName() + ", " + getSize() + ", Offered on Weekend: " + isWeekend + ", Price: $" + String.format("%.2f", calcPrice());
	}

	/**
     * Calculates the price of the beverage based on its size and
     * adds a weekend charge if applicable.
     *
     * @return the final price of the alcoholic beverage
     */
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if (isWeekend) price += WEEKEND_PRICE;
		return price;
	}
	
	 /**
     * Determines if two Alcohol objects are equal based on superclass
     * equality and weekend status.
     *
     * @param anotherBev the object to compare
     * @return true if both Alcohol objects are equal, false otherwise
     */
	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev) return true; // same object
	    if (anotherBev == null || getClass() != anotherBev.getClass()) return false; // null or different class
	    
	    if (!super.equals(anotherBev)) return false; // compare Beverage fields

	    Alcohol other = (Alcohol) anotherBev; // safe cast after class check

	    return isWeekend == other.isWeekend; // equal if isWeekend field is equal
	}

}
