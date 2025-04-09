/**
 * This class represents a Plot object.
 */
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * Creates a default Plot with width and depth of 1.
	 */
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	/**
	 * Creates a Plot using the given values.
	 * 
	 * @param x   the x coordinate of the plot
	 * @param y   the y coordinate of the plot
	 * @param width   the width coordinate of the plot
	 * @param depth   the depth coordinate of the plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Creates a new plot given another plot.
	 * 
	 * @param otherPlot   the plot to make a copy of
	 */
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 * 
	 * @param x   the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 * 
	 * @param y   the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the depth.
	 * 
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the depth.
	 * 
	 * @param depth   the new depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Gets the width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 * 
	 * @param width   the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Determines if the given plot instance is overlapped by the current plot.
	 * 
	 * @param other   the plot to test against and check if overlaps
	 * @return true if the two plots overlap, false otherwise
	 */
	public boolean overlaps(Plot other) {
	    if (this.x + this.width <= other.x || // This plot is completely to the left of the other plot
	        other.x + other.width <= this.x || // Other plot is completely to the left of this plot
	        this.y + this.depth <= other.y || // This plot is completely above the other
	        other.y + other.depth <= this.y) { // Other plot is completely above this plot
	        return false;
	    }
	    return true; 
	}
	
	/**
	 * Determines if the given plot is encompassed by (is contained by) this plot.
	 * 
	 * @param other   the plot to test against and check if encompasses
	 * @return true if the given plot is encompassed by this plot, false otherwise
	 */
	public boolean encompasses(Plot other) {
	    // Check if this plot surrounds the other plot from each side
	    return (this.x <= other.x && this.y <= other.y && 
	    		this.x + this.width >= other.x + other.width && 
	            this.y + this.depth >= other.y + other.depth);
	}

	/**
	 * Represents a Plot object in the following String format. x,y,width,depth
	 * 
	 * @return the string representation of a plot.
	 */
	public String toString() {
		String str = "" + x + "," + y + "," + width + "," + depth;
		return str;
	}
}
