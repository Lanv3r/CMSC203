/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: BevShop class manages beverage orders, validates orders,
 * tracks alcohol limits, calculates sales, and supports order sorting.
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	public ArrayList<Order> orders; // List of all orders made
	private int numOfAlcohol = 0; // Tracks number of alcohol drinks in current order
	
	/**
     * Constructs a new BevShop with an empty list of orders.
     */
	public BevShop() {
        orders = new ArrayList<>();
    }
	
	/**
     * Checks if the given time is valid for placing an order.
     * @param time the hour of the order
     * @return true if time is within operating hours, false otherwise
     */
	@Override
	public boolean isValidTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) return true;
		return false;
	}

	/**
     * Gets the maximum number of fruits allowed in a smoothie.
     * @return maximum fruit count
     */
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	/**
     * Gets the minimum age required to order alcohol.
     * @return minimum legal age for alcohol
     */
	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/**
     * Checks if the number of fruits exceeds or equals the max allowed.
     * @param numOfFruits number of fruits in the order
     * @return true if max or more, false otherwise
     */
	@Override
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits >= MAX_FRUIT;
	}

	/**
     * Gets the max number of alcohol drinks allowed per order.
     * @return maximum allowed alcohol count
     */
	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
     * Determines if customer can order more alcohol.
     * @return true if below max, false if limit reached
     */
	@Override
	public boolean isEligibleForMore() {
		return numOfAlcohol < MAX_ORDER_FOR_ALCOHOL;
	}

	/**
     * Gets number of alcohol drinks in the current order.
     * @return number of alcohol drinks
     */
	@Override
	public int getNumOfAlcoholDrink() {
		return numOfAlcohol;
	}

	/**
     * Validates if age is above minimum alcohol age.
     * @param age customer's age
     * @return true if age is valid for alcohol
     */
	@Override
	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL;
	}

	/**
     * Starts a new customer order.
     * @param time order time
     * @param day day of order
     * @param customerName name of customer
     * @param customerAge age of customer
     */
	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
		numOfAlcohol = 0;
	}

	/**
     * Processes a coffee order and adds it to the current order.
     * @param bevName beverage name
     * @param size beverage size
     * @param extraShot true if extra shot
     * @param extraSyrup true if extra syrup
     */
	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	/**
     * Processes an alcohol order and increments the alcohol count.
     * @param bevName beverage name
     * @param size beverage size
     */
	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		getCurrentOrder().addNewBeverage(bevName, size);
		numOfAlcohol ++;
	}

	/**
     * Processes a smoothie order and adds it to the current order.
     * @param bevName smoothie name
     * @param size smoothie size
     * @param numOfFruits number of fruits
     * @param addProtein true if protein is added
     */
	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	/**
     * Finds the index of an order by order number.
     * @param orderNo order number
     * @return index of order or -1 if not found
     */
	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
	        if (orders.get(i).getOrderNo() == orderNo) {
	            return i;
	        }
	    }
	    return -1; // not found
	}

	/**
     * Calculates total price of a specific order.
     * @param orderNo order number
     * @return total price of the order
     */
	@Override
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	/**
     * Calculates total sales for the month.
     * @return monthly sales total
     */
	@Override
	public double totalMonthlySale() {
		double total = 0;
		for (int i = 0; i < orders.size(); i++) {
	        total += getOrderAtIndex(i).calcOrderTotal();
	    }
		return total;
	}

	/**
     * Gets the total number of orders this month.
     * @return number of monthly orders
     */
	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	 /**
     * Gets the current order.
     * @return current order or null if none exist
     */
	@Override
	public Order getCurrentOrder() {
		if (!orders.isEmpty()) {
	        return orders.get(orders.size() - 1); // last order in the list
	    }
	    return null;
	}

	/**
     * Retrieves an order by its index in the list.
     * @param index index in list
     * @return the order or null if index is invalid
     */
	@Override
	public Order getOrderAtIndex(int index) {
		if (index >= 0 && index < orders.size()) {
	        return orders.get(index); // Shallow copy
	    }
	    return null; // Invalid index
	}

	/**
     * Sorts the list of orders by their order numbers using selection sort.
     */
	@Override
	public void sortOrders() {
		for (int i = 0; i < orders.size() - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < orders.size(); j++) {
	            if (getOrderAtIndex(j).getOrderNo() < getOrderAtIndex(minIndex).getOrderNo()) {
	                minIndex = j;
	            }
	        }
	        // Swap orders[i] and orders[minIndex] if needed
	        if (minIndex != i) {
	            Order temp = orders.get(i);
	            orders.set(i, orders.get(minIndex));
	            orders.set(minIndex, temp);
	        }
	    }
	}
	
	/**
     * Returns a string representation of all orders and the monthly sale total.
     * @return summary of all orders and sales
     */
	@Override
	public String toString() {
		String str = "List of the Orders\n";
		for (Order o : orders) {
			str += o.toString() + "\n";
		}
		str += "Total Monthly Sale: $" + String.format("%.2f", totalMonthlySale());
		return str;
	}
}
