package A;
import java.util.*;

public class MovieDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Movie movie = new Movie();
		System.out.println("Enter the name of a movie");
		movie.setTitle(scanner.nextLine());
		System.out.println("Enter the rating of the movie");
		movie.setRating(scanner.nextLine());
		System.out.println("Enter the number of tickets sold for this movie");
		movie.setSoldTickets(scanner.nextInt());
		System.out.println(movie.toString());
	}

}
