/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer 
 * Description: Player guesses randomly chosen colors from a file named "colors.txt". Results are printed to the console and saved in a file named "EspGameResults.txt".
 * Due: 02/11/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Anver Ismagilov
*/

package project1;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {
    public static void main(String[] args) throws IOException {
        final String FILE_NAME = "/Users/anver/Downloads/Assignment1_st_updated012025/colors.txt";
        final int ROUNDS = 3; // the total amount of rounds for each game
        int correctGuesses = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to ESP - Extrasensory Perception!");
        boolean continueGame = true;
        while (continueGame) {
            System.out.println("Would you please choose one of the 4 options from the menu:");
            System.out.println("1. Display first 16 colors");
            System.out.println("2. Display first 10 colors");
            System.out.println("3. Display first 5 colors");
            System.out.println("4. Exit program");
            System.out.print("Enter the option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // to avoid errors when the program reads first guess
            
            if (option == 4) break; // to terminate this while loop and print results
            int colors = 16;
            switch (option) {
            	case 2:
            		colors = 10;
            		break;
            	case 3:
            		colors = 5;
            		break;
            	default: 
            		break;
            }
            
        	Scanner fileScanner = new Scanner(new File(FILE_NAME));
        	System.out.printf("First %d colors from a file:\n", colors);
        	for (int n = 0; n < colors; n++) {
        		if(fileScanner.hasNextLine()) {
        			System.out.println(n + 1 + " " + fileScanner.nextLine());
        		}
        	}
            fileScanner.close();
            
            correctGuesses = 0;
            for (int round = 1; round <= ROUNDS; round++) {
                System.out.println("\nRound " + round);
                System.out.println("I am thinking of a color.");
                System.out.print("Enter your guess: ");
                
                String userGuess = scanner.nextLine().trim(); //I'm using trim() to remove whitespace from a string 
                
                fileScanner = new Scanner(new File(FILE_NAME));
                int randomNum = random.nextInt(colors) + 1; //generates random number from 1 to chosen number of colors
                String correctColor = "";
                for (int k = 0; k < randomNum; k++) {
            		if (fileScanner.hasNextLine()) {
            			correctColor = fileScanner.nextLine(); //finds the randomly chosen color in a file
            		}
            	}
                fileScanner.close();
                if (userGuess.equalsIgnoreCase(correctColor)) correctGuesses ++;  //compares user guess and randomly chosen color ignoring case
                System.out.println("I was thinking of " + correctColor + ".");
            }
                
                System.out.println("Game Over");
                System.out.println("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.");
                
                System.out.print("Would you like to continue? (Yes/No): ");
                String response = scanner.nextLine().trim();
                if (!response.equalsIgnoreCase("Yes")) {
                    continueGame = false;
                }
        }
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();
        System.out.print("Describe yourself: ");
        String description = scanner.nextLine();
        System.out.print("Due Date (MM/DD/YY): ");
        String dueDate = scanner.nextLine();
        System.out.print("Date (MM/DD/YY): ");
        String date = scanner.nextLine();

        String output = "Game Over\nYou guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.\n" +
                        "Due Date: " + dueDate + "\nUsername: " + username + "\nUser Description: " + description + "\nDate: " + date + "\n";
        
        System.out.println(output);
        
        PrintWriter outFile = new PrintWriter("EspGameResults.txt");
        outFile.println(output);
        outFile.close();
      
        scanner.close();     
    }  
}

