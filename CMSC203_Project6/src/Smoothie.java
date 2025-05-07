/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: Smoothie class is a subclass of Beverage that represents a smoothie drink with an optional fruit price charge 
 * and an option to add protein to a smoothie. It calculates the final price based on this data.
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/
public class Smoothie extends Beverage {
	private static final double FRUIT_PRICE = 0.5; // Additional cost per fruit added
	private static final double PROTEIN_PRICE = 1.5; // Additional cost for adding protein
	private int numOfFruits; // Number of fruits added to the smoothie
	private boolean addProtein; // Indicates whether protein was added to the smoothie
	
	/**
     * Constructs a Smoothie object with specified name, size, number of fruits, and protein option.
     * 
     * @param name        the name of the smoothie
     * @param size        the size of the smoothie (SMALL, MEDIUM, LARGE)
     * @param numOfFruits the number of fruits added
     * @param addProtein  whether protein is added
     */
	public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
		super(name, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	/**
     * Returns the number of fruits added to the smoothie.
     * 
     * @return number of fruits
     */
	public int getNumOfFruits() {
		return numOfFruits;
	}

	/**
     * Sets the number of fruits added to the smoothie.
     * 
     * @param numOfFruits number of fruits
     */
	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	/**
     * Returns whether protein is added to the smoothie.
     * 
     * @return true if protein is added, false otherwise
     */
	public boolean isAddProtein() {
		return addProtein;
	}

	/**
     * Sets whether protein should be added to the smoothie.
     * 
     * @param addProtein true to add protein, false otherwise
     */
	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}

	/**
     * Returns a string representation of the smoothie, including name, size,
     * whether protein is added, number of fruits, and total price.
     * 
     * @return string describing the smoothie
     */
	public String toString() {
		return getName() + ", " + getSize() + ", Protein Added: " + addProtein + ", Number of Fruits: " + numOfFruits + ", Price: $" + String.format("%.2f", calcPrice());
	}

	/**
     * Calculates the price of the smoothie based on size, fruit additions, and protein.
     * 
     * @return final price of the smoothie
     */
	@Override
	public double calcPrice() {
		double price = addSizePrice(); // the calculated price based on size
		if (addProtein) price += PROTEIN_PRICE;
		price += FRUIT_PRICE * numOfFruits;
		return price;
	}
	
	/**
     * Compares this Smoothie to another object for equality.
     * Two smoothies are equal if their inherited beverage fields, number of fruits,
     * and protein options are the same.
     * 
     * @param anotherBev another object to compare
     * @return true if equal, false otherwise
     */
	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev) return true; // same object
	    if (anotherBev == null || getClass() != anotherBev.getClass()) return false; // null or different class
	    
	    if (!super.equals(anotherBev)) return false; // compare Beverage fields

	    Smoothie other = (Smoothie) anotherBev; // safe cast after class check
	    // two objects are equal if their addProtein and numOfFruits fields are equal
	    return addProtein == other.addProtein && numOfFruits == other.numOfFruits; 
	}

}
