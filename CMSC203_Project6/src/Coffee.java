/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: Coffee class is a subclass of Beverage that represents a coffee drink with an optional charge 
 * for extra shot and extra syrup. It calculates the final price based on this data.
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/
public class Coffee extends Beverage {
	private static final double EXTRA_PRICE = 0.5; // Cost for each extra shot or syrup
	private boolean extraShot; // Indicates if an extra shot is added
	private boolean extraSyrup; // Indicates if extra syrup is added

	/**
	 * Constructs a Coffee object with the given properties.
	 * 
	 * @param bevName     the name of the coffee beverage
	 * @param size        the size of the coffee (SMALL, MEDIUM, LARGE)
	 * @param extraShot   true if extra shot is added
	 * @param extraSyrup  true if extra syrup is added
	 */
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * Returns true if the coffee has an extra shot.
	 * 
	 * @return true if extra shot is added, false otherwise
	 */
	public boolean isExtraShot() {
		return extraShot;
	}

	/**
	 * Sets whether the coffee has an extra shot.
	 * 
	 * @param extraShot true to add an extra shot, false to remove it
	 */
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	/**
	 * Returns true if the coffee has extra syrup.
	 * 
	 * @return true if extra syrup is added, false otherwise
	 */
	public boolean isExtraSyrup() {
		return extraSyrup;
	}

	/**
	 * Sets whether the coffee has extra syrup.
	 * 
	 * @param extraSyrup true to add extra syrup, false to remove it
	 */
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	/**
	 * Returns a string representation of the Coffee object, including name, size,
	 * extra shot/syrup flags, and the calculated price.
	 * 
	 * @return a formatted string describing the coffee beverage
	 */
	public String toString() {
		return getName() + ", " + getSize() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup + ", Price: $" + String.format("%.2f", calcPrice());
	}

	/**
	 * Calculates and returns the total price of the coffee, including size price
	 * and charges for any extras.
	 * 
	 * @return the final price of the coffee
	 */
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if (extraShot) price += EXTRA_PRICE;
		if (extraSyrup) price += EXTRA_PRICE;
		return price;
	}
	
	/**
	 * Compares this Coffee object to another object for equality.
	 * Two Coffee objects are equal if their Beverage fields and extraShot/extraSyrup
	 * values match.
	 * 
	 * @param anotherBev the object to compare
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev) return true; // same object
	    if (anotherBev == null || getClass() != anotherBev.getClass()) return false; // null or different class
	    
	    if (!super.equals(anotherBev)) return false; // compare Beverage fields

	    Coffee other = (Coffee) anotherBev; // safe cast after class check
	 // two Coffee objects are equal if their extraShot and extraSyrup fields are equal
	    return extraShot == other.extraShot && extraSyrup == other.extraSyrup;
	}
	

}
