/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: Order class models a beverage order made by a customer on a specific day and time. 
 * It stores multiple beverages, calculates the total price, and tracks order details like order number, 
 * day, time, and customer. It also supports adding different beverage types and comparing orders by ID.
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderTime;
	private int orderNo;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages = new ArrayList<Beverage>(); // The list of beverages in the order
	
	/**
	 * Constructs a new Order object.
	 * @param orderTime the time the order was placed
	 * @param orderDay the day the order was placed
	 * @param cust the customer who placed the order
	 */
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.orderNo = generateOrder(); // Generate order number when creating the order
	}

	/**
	 * Gets the time the order was placed.
	 * 
	 * @return the order time
	 */
	public int getOrderTime() {
		return orderTime;
	}


	/**
	 * Sets the time the order was placed.
	 * 
	 * @param orderTime the order time to set
	 */
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}


	/**
	 * Gets the order number.
	 * 
	 * @return the order number
	 */
	public int getOrderNo() {
		return orderNo;
	}

	/**
	 * Sets the order number.
	 * 
	 * @param orderNo the order number to set
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Gets the day the order was placed.
	 * 
	 * @return the order day
	 */
	public Day getOrderDay() {
		return orderDay;
	}

	/**
	 * Sets the day the order was placed.
	 * 
	 * @param orderDay the order day to set
	 */
	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}


	/**
	 * Returns a copy of the customer to preserve encapsulation.
	 * @return a copy of the Customer object
	 */
	public Customer getCustomer() {
		return new Customer(cust.getName(), cust.getAge());
	}


	/**
	 * Sets the customer for the order by copying the provided customer.
	 * @param cust the customer to set
	 */
	public void setCust(Customer cust) {
		this.cust = new Customer(cust.getName(), cust.getAge());
	}


	/**
	 * Generates a random order number between 10000 and 89999.
	 * @return the generated order number
	 */
	public int generateOrder() {
		Random random = new Random();
        
        return 10000 + random.nextInt(80001); // Generate a random integer between 10000 and bound 90000
	}
	
	/**
	 * Checks if the order was placed on a weekend.
	 * @return true if the order day is Saturday or Sunday, false otherwise
	 */
	@Override
	public boolean isWeekend() {
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) return true;
		return false;
	}

	/**
	 * Returns the beverage at the specified index.
	 * @param itemNo the index of the beverage
	 * @return the Beverage object or null if index is invalid
	 */
	@Override
	public Beverage getBeverage(int itemNo) {
	    if (itemNo >= 0 && itemNo < beverages.size()) {
	        return beverages.get(itemNo);  // Return shallow copy if itemNo is valid
	    }
	    return null;  // Return null if itemNo is out of bounds
	}

	/**
	 * Adds a new Coffee beverage to the order.
	 * @param bevName the name of the coffee
	 * @param size the size of the coffee
	 * @param extraShot whether it has an extra shot
	 * @param extraSyrup whether it has extra syrup
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));  
	}

	/**
	 * Adds a new Alcohol beverage to the order.
	 * @param bevName the name of the alcohol
	 * @param size the size of the drink
	 */
	@Override
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend()));
	}

	/**
	 * Adds a new Smoothie beverage to the order.
	 * @param bevName the name of the smoothie
	 * @param size the size of the smoothie
	 * @param numOfFruits the number of fruits
	 * @param addProtein whether protein is added
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	/**
	 * Calculates the total price for the order by summing the price of all beverages.
	 * @return the total cost of the order
	 */
	@Override
	public double calcOrderTotal() {
		double total = 0;
		for (Beverage bev : beverages) {
	        total += bev.calcPrice();
	    }
		return total;
	}

	/**
	 * Finds the number of beverages of a specific type in the order.
	 * @param type the beverage type to look for
	 * @return the number of beverages of that type
	 */
	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;
	    // Loop through the list of beverages
	    for (Beverage bev : beverages) {
	        // Check if the beverage type matches the specified type
	        if (bev.getType() == type) {
	            count++;
	        }
	    }
	    return count;  // Return the number of matching beverages
	}

	/**
	 * Compares this order with another order based on order number.
	 * @param anotherOrder the other order to compare to
	 * @return 0 if equal, 1 if this is greater, -1 otherwise
	 */
	@Override
	public int compareTo(Order anotherOrder) {
		if (orderNo == anotherOrder.orderNo) {
			return 0;
		} else if (orderNo > anotherOrder.orderNo) {
			return 1;
		}
		return -1;
	}
	
	/**
	 * Gets the total number of beverage items in this order.
	 * @return the number of beverages
	 */
	public int getTotalItems() {
		return beverages.size();
	}
	
	/**
	 * Returns a string representation of the order.
	 * @return string with order number, time, day, customer, and beverages
	 */
	@Override
	public String toString() {
		String str = "Order Number: " + orderNo + ", Order Time: " + orderTime + ", Day: " + orderDay + ", Customer: " + 
				cust.getName() + ", Age: " + cust.getAge() + 
				"\nList of Beverages:\n";
		for (Beverage bev : beverages) {
			str += bev.toString() + "\n";
		}
		
		return str.trim(); // Delete last new line
	}

}
