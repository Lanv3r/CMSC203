/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: BevShopDriverApp simulates the operations of a beverage shop.
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/

import java.util.Scanner;

public class BevShopDriverApp {
	static Scanner scanner = new Scanner(System.in);
	static BevShop shop = new BevShop(); // instance of a BevShop class to test the program

	public static void main(String[] args) {
		int time = 12; // Test time value, as no instructions were provided on obtaining the actual time
		
		// Check if shop is open
		if (shop.isValidTime(time)) {
			// Explain the rules regarding alcohol
			System.out.println("The current order in process can have at most " + shop.getMaxOrderForAlcohol() + " alcoholic beverages.");
			System.out.println("The minimum age to order alcohol drink is " + shop.getMinAgeForAlcohol());
			
			// I'm testing the program for one order, there were no clear instructions on what should be in this class at all
			// so I decided to process the order from one customer.
			// The example of a program output in the documentation file is not consistent, so I'm improvising
			System.out.println("Please start a new order.");
			System.out.println("Would you please enter your name:");
			String name = scanner.nextLine(); // Get customer name
			int age = handleAgeSelection(); // Get customer age
			
			// Start a new order with test time, day and the given customer data
			shop.startNewOrder(time, Day.FRIDAY, name, age); // Test day to test the program; there were no instructions on how to get day for the order
			
			 // Validate the customer's age for alcohol orders
			if(shop.isValidAge(age)) {
				handleAlcoholOrder(); // Handle alcohol order if valid age
			}
			handleSmoothieOrder(); // Handle smoothie order
			handleCoffeeOrder(); // Handle coffee order
			
			// Display the checkout summary
			checkOut();
			
		} else {
			System.out.println("Beverage Shop is closed. Come back later!");
		}
		
		
		

	}
	
	/**
     * This method handles the checkout process, calculating and printing the total price of the order.
     */
	public static void checkOut() {
	    System.out.println("Thank you for shopping with us today!");
	    System.out.println("Total order price: $" + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal())); // Print order total
	    System.out.println(shop.getCurrentOrder()); // Print order information(receipt)
	}
	
	/**
     * This method handles the customer’s age input, ensuring it is a valid integer.
     * @return the validated age input.
     */
	public static int handleAgeSelection() {
		int age;
		while (true) {
		    System.out.println("Would you please enter your age:");
		    if (scanner.hasNextInt()) {
		        age = scanner.nextInt();
		        scanner.nextLine(); // consume leftover newline
		        break;
		    } else {
		        System.out.println("Invalid input. Please enter a valid integer for age:");
		        scanner.nextLine(); // clear the invalid input
		    }
		}
		return age;
	}
	
	/**
     * This method prompts the user to select the size of a drink.
     * @return the selected size.
     */
	public static Size handleSizeSelection() {
		int choice;
	    Size size = Size.SMALL; // Initialize with default value

	    while (true) {
	        System.out.println("Please enter your size choice (1-3):");
	        System.out.println("1. Small\n2. Medium\n3. Large");

	        // Validating user input
	        if (scanner.hasNextInt()) { 
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume leftover newline

	            if (choice >= 1 && choice <= 3) {
	                switch (choice) {
	                    case 1:
	                    	size = Size.SMALL;
	                        break;
	                    case 2:
	                    	size = Size.MEDIUM;
	                        break;
	                    case 3:
	                    	size = Size.LARGE;
	                        break;
	                }
	                break; // Valid input, exit loop
	            } else {
	                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
	            }
	        } else {
	            System.out.println("Invalid input. Please enter a valid integer for size.");
	            scanner.nextLine(); // Clear invalid input
	        }
	    }
	    return size;
	}
	
	/**
     * This method prompts the user to select the number of fruits for their smoothie order.
     * @return the number of fruits selected.
     */
	public static int handleFruitSelection() {
	    int numOfFruits = 0; // Initialize with default value
	    while (true) {
	    	System.out.println("The maximum number of fruits for a smoothie is: " + shop.getMaxNumOfFruits());
	        System.out.println("Please enter desired number of fruits (0-" + shop.getMaxNumOfFruits() + "):");

	        // Validating user input
	        if (scanner.hasNextInt()) { 
	        	numOfFruits = scanner.nextInt();
	            scanner.nextLine(); // Consume leftover newline

	            if (numOfFruits >= 0 && numOfFruits <= shop.getMaxNumOfFruits()) {
	                break; // Valid input, exit loop
	            } else {
	                System.out.println("Invalid choice. Please enter a number between 0 and " + shop.getMaxNumOfFruits() + ".");
	            }
	        } else {
	            System.out.println("Invalid input. Please enter a valid integer for number of fruits.");
	            scanner.nextLine(); // Clear invalid input
	        }
	    }
	    return numOfFruits;
	}
	
	/**
     * This method checks if the user wants to add protein to their smoothie.
     * @return true if the user selects 'Y', otherwise false.
     */
	public static boolean handleProteinSelection() {
		System.out.println("Would you like to add protein to your smoothie? (Y/N)");
	    if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
	    	return true;
		}
	    return false;
	}
	
	/**
     * This method checks if the user wants to add an extra shot to their coffee.
     * @return true if the user selects 'Y', otherwise false.
     */
	public static boolean handleExtraShotSelection() {
		System.out.println("Would you like an extra shot to your coffee? (Y/N)");
	    if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
	    	return true;
		}
	    return false;
	}
	
	/**
     * This method checks if the user wants to add extra syrup to their coffee.
     * @return true if the user selects 'Y', otherwise false.
     */
	public static boolean handleExtraSyrupSelection() {
		System.out.println("Would you like to add syrup to your coffee? (Y/N)");
	    if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
	    	return true;
		}
	    return false;
	}
	
	/**
     * This method allows the user to add alcoholic drinks to their order.
     * It checks if the user is eligible for more alcoholic drinks based on their age and previous order.
     */
	public static void handleAlcoholOrder() {
		System.out.println("Your age is 21+ and you are eligible to order alcohol.");
		System.out.println("The maximum number of alcohol drinks you can order is " + shop.getMaxOrderForAlcohol() + ".");
		while (shop.isEligibleForMore()) {
			System.out.println("Would you like to add an alcohol drink? (Y/N)");
			
			if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
			    System.out.println("Adding alcohol drink...");
			    System.out.println("Please enter beverage name");
			    String bevName = scanner.nextLine(); // Get beverage name from user
			    Size size = handleSizeSelection(); // Get beverage size from user
			    
			    shop.processAlcoholOrder(bevName, size); // Process alcohol order with the data from user
			    System.out.println("Total order price: $" + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal())); // Print order total
			    
			    if (!shop.isEligibleForMore()) System.out.println("You cannot buy any more alcohol drinks.");
			} else {
			    break; // Exit alcohol order processing if the user doesn't want to add an alcohol drink
			}
		}
	}
	
	/**
     * This method allows the user to add smoothie drinks to their order.
     * It collects information about the smoothie and processes the order.
     */
	public static void handleSmoothieOrder() {
		while (true) {
			System.out.println("Would you like to add a smoothie drink? (Y/N)");
			
			if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
			    System.out.println("Adding smoothie drink...");
			    System.out.println("Please enter beverage name");
			    String bevName = scanner.nextLine(); // Get beverage name from user
			    Size size = handleSizeSelection(); // Get beverage size from user
			    int numOfFruits = handleFruitSelection(); // Get number of fruits from user
			    boolean addProtein = handleProteinSelection(); // Get protein choice from user
			    
			    shop.processSmoothieOrder(bevName, size, numOfFruits, addProtein); // Process smoothie order with the data from user 
			    System.out.println("Total order price: $" + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal())); // Print order total
			} else {
			    break;
			}
		}
	}
	
	/**
     * This method allows the user to add coffee drinks to their order.
     * It collects information about the coffee and processes the order.
     */
	public static void handleCoffeeOrder() {
		while (true) {
			System.out.println("Would you like to add a coffee drink? (Y/N)");
			
			if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
			    System.out.println("Adding coffee drink...");
			    System.out.println("Please enter beverage name");
			    String bevName = scanner.nextLine(); // Get beverage name from user
			    Size size = handleSizeSelection(); // Get beverage size from user
			    boolean extraShot = handleExtraShotSelection(); // Get extra shot choice from user
			    boolean extraSyrup = handleExtraSyrupSelection(); // Get extra syrup choice from user
			    
			    shop.processCoffeeOrder(bevName, size, extraShot, extraSyrup); // Process coffee order with the data from user 
			    System.out.println("Total order price: $" + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal())); // Print order total
			} else {
			    break;
			}
		}
	}

}
