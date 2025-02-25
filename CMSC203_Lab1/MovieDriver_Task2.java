package A;
import java.util.*;

public class MovieDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continueLoop = true;
        while (continueLoop) {   
        	Movie movie = new Movie();
    		System.out.println("Enter the name of a movie");
    		movie.setTitle(scanner.nextLine());
    		System.out.println("Enter the rating of the movie");
    		movie.setRating(scanner.nextLine());
    		System.out.println("Enter the number of tickets sold for this movie");
    		movie.setSoldTickets(scanner.nextInt());
    		System.out.println(movie.toString());
    		
            System.out.println("Would you like to continue? (Yes/No): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim();
            if (!response.equalsIgnoreCase("Yes")) {
            	continueLoop = false;
            }
        }
        System.out.println("Goodbye!");
	}

}
