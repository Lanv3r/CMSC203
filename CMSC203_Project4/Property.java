/**
 * This class represents a Property object.
 */
public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	/**
	 * Creates a new Property using empty strings. It also creates a default Plot.
	 */
	public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot(); // Default Plot
    }
	
	/**
	 * Creates a new Property object using given values. It also creates a default Plot.
	 * 
	 * @param propertyName   property name
	 * @param city           city where the property is located
	 * @param rentAmount   rent amount
	 * @param owner          the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(); // Default Plot
    }
	
	/**
	 * Creates a new Property object using given values. It also creates a Plot using given values of a plot.
	 * 
	 * @param propertyName   property name
	 * @param city           city where the property is located
	 * @param rentAmount   rent amount
	 * @param owner          the owner's name
	 * @param x              the x coordinate of the plot
	 * @param y              the y coordinate of the plot
	 * @param width          the width of the plot
	 * @param depth          the depth of the plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

	/**
	 * Creates a new copy of the given property object.
	 * 
	 * @param otherProperty the Property object to make a copy of
	 */
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
	    this.city = otherProperty.city;
	    this.rentAmount = otherProperty.rentAmount;
	    this.owner = otherProperty.owner;
	    this.plot = new Plot(otherProperty.plot.getX(), otherProperty.plot.getY(), otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
	}

	/**
	 * Gets the property name.
	 * 
	 * @return the property name
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Sets the property name.
	 * 
	 * @param propertyName   the new property name
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 * 
	 * @param city   the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the rent amount.
	 * 
	 * @return the rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Sets the rent amount.
	 * 
	 * @param rentAmount   the new rent amount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Gets the owner.
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owner.
	 * 
	 * @param owner   the new owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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
	 * Sets the plot.
	 * 
	 * @param plot   the new plot
	 */
	public void setPlot(Plot plot) {
		this.plot = new Plot(plot.getX(), plot.getY(), plot.getWidth(), plot.getDepth());
	}
	
	/**
	 * Represents a Property object in the following String format: propertyName,city,owner,rentAmount
	 * 
	 * @return the string representation of a Property object
	 */
	public String toString() {
		String str = "" + propertyName + "," + city + "," + owner + "," + rentAmount;
		return str;
	}
}
