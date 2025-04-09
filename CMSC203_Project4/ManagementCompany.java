/**
 * Represents Management Company Object
 * 
 * @author Farnaz Eivazi, 7/8/2022
 *
 */

public class ManagementCompany {
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private Plot plot;
	private int numberOfProperties;

	/**
	 * Creates a ManagementCompany object using empty strings, 
	 * creates a default Plot with maximum width and depth and 
	 * it initializes the properties array.
	 * 
	 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Creates a ManagementCompany object using the given values, 
	 * creates a default Plot with maximum width and depth and 
	 * it initializes the properties array.
	 * 
	 * @param name   	management Company name
	 * @param taxID  	tax Id
	 * @param mgmFee 	management Fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Creates a ManagementCompany object using the given values
	 * creates a Plot using the given values and 
	 * it initializes the properties array. 
	 * This constructor should call an appropriate existing constructor.
	 * 
	 * @param name   	management Company name
	 * @param taxID  	tax Id
	 * @param mgmFee 	management Fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this(name, taxID, mgmFee);
		this.plot = new Plot(x, y, width, depth);
	}

	/**
	 * Creates a new ManagementCompany copy of the given ManagementCompany. 
	 * This constructor should call an appropriate existing constructor.
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer);
		this.plot = otherCompany.plot;
	}
	
	/**
	 * Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
	 * 
	 * @param name  	property name
	 * @param city  	city where the property is located
	 * @param rent  	rent amount
	 * @param owner 	the owner's name
	 * 
	 * @return -1 if the array is full, 
	 * -2 if the Property object is null,
	 * -3 if management company does not encompass the property plot, 
	 * -4 if property plot overlaps ANY of properties in array, 
	 * otherwise return the index of the array where the property was added.
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}

	/**
	 * Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
	 * 
	 * @param name  	property name
	 * @param city  	city where the property is located
	 * @param rent  	rent amount
	 * @param owner 	the owner's name
	 * @param x     	The x coordinate of the plot
	 * @param y     	The y coordinate of the plot
	 * @param width 	The width coordinate of the plot
	 * @param depth 	The depth coordinate of the plot
	 * 
	 * @return -1 if the array is full, 
	 * -2 if the Property object is null,
	 * -3 if management company does not encompass the property plot, 
	 * -4 if property plot overlaps ANY of properties in array, 
	 * otherwise return the index of the array where the property was added.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}

	/**
	 * Creates a property object by copying from another property and adds it to the properties array.
	 * 
	 * @return -1 if the array is full, 
	 * -2 if the Property object is null,
	 * -3 if management company does not encompass the property plot, 
	 * -4 if property plot overlaps ANY of properties in array, 
	 * otherwise return the index of the array where the property was added.
	 */
	public int addProperty(Property property) {		
		if (isPropertiesFull()) {
			return -1;
		}
		if (property == null) {
			return -2;
		}
		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}

		int returnValue = 0;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				Property p = new Property(property);
				properties[i] = p;
				numberOfProperties++;
				returnValue = i;
				break;
			} else if (properties[i].getPlot().overlaps(property.getPlot())) {
				returnValue = -4;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * Removes(nullifies) the LAST property in the properties array
	 * 
	 */
	public void removeLastProperty() {
		properties[properties.length-1] = null;
		numberOfProperties--;
	}

	/**
	 * Checks if the properties array has reached the maximum capacity
	 * 
	 * @return true 	if properties array is full, false otherwise
	 */
	public boolean isPropertiesFull() {
		return (getPropertiesCount() >= MAX_PROPERTY);
	}
	
	/**
	 * 
	 * Gets the number of existing properties in the array
	 * 
	 * @return the number of existing properties in the array 
	 */
	public int getPropertiesCount() {
		return numberOfProperties;
	}

	/**
	 * Returns the total rent of the properties in the properties array	 * 
	 * 
	 * @return total rent
	 */
	public double getTotalRent() {
		double totalRent = 0;
		for (int i = 0; i < properties.length && properties[i] != null; i++) {
			totalRent += properties[i].getRentAmount();			
		}

		return totalRent;
	}

	/**
	 * Gets the property in the array with the maximum amount of rent
	 * 
	 * @return the property in the array which has the highest amount of rent
	 */
	public Property getHighestRentProperty() {
		return (properties[getHighestRentPropertyIndex()]);
	}

	/**
	 * Returns the index of the property with the maximum rent amount.	 * 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is  different.
	 * 
	 * @return the index of the property with the maximum rent amount
	 */
	private int getHighestRentPropertyIndex()

	{
		double maxRent = properties[0].getRentAmount();
		int maxIndex = 0;

		for (int i = 0; i < properties.length && properties[i] != null; i++) {
			if (properties[i].getRentAmount() > maxRent) {
				maxRent = properties[i].getRentAmount();
				maxIndex = i;

			}
		}
		return maxIndex;

	}
	
	/**
	 * Checks if the management company has a valid (between 0-100) fee
	 * 
	 * @return 	true of the management fee is valid (between 0-100), false otherwise
	 */
	public boolean isMangementFeeValid() {
		return !(mgmFeePer < 0 || mgmFeePer > 100);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the tax ID.
	 *
	 * @return the tax ID
	 */
	public String getTaxID() {
		return taxID;
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	public Property[] getProperties() {
		return properties;
	}

	/**
	 * Gets the management fee per.
	 *
	 * @return the mgmFeePer
	 */
	public double getMgmFeePer() {
		return mgmFeePer;
	}

	/**
	 * Gets the plot.
	 *
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * Represents the information of all the properties in the properties array.
	 * 
	 * @return information of ALL the properties within this management company by accessing the properties array.
	 * This value should include each management company's name, taxID as well each property's name,city,owner,rent Amount
	 *         
	 */

	public String toString() {

		String pStr = "List of the properties for " + name + ", " + "taxID: " + taxID + "\n";
		pStr += "______________________________________________________\n";

		for (int i = 0; i < properties.length && properties[i] != null; i++) {
			pStr += properties[i] + "\n";

		}
		pStr += "______________________________________________________\n";
		pStr += "\n total management Fee: " + (getTotalRent() * mgmFeePer) / 100;
		return pStr;
	}
	
	

}
