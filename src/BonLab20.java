import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BonLab20 {

	public static void main(String[] args) {

		ArrayList<String> orderList = new ArrayList<>();
		ArrayList<Double> priceList = new ArrayList<>();

		System.out.println("Welcome to Guenther's Market!");

		Scanner scan = new Scanner(System.in);

		String cont = "y";

		while (cont.equalsIgnoreCase("y")) {
			HashMap<String, Double> products = new HashMap<>();
			products.put("apple", 0.99);
			products.put("banana", 0.59);
			products.put("orange", .79);
			products.put("chicken", .99);
			products.put("pizza", 1.99);
			products.put("hamburger", .79);
			products.put("cheeseburger", .89);
			products.put("watermelon", .89);

			System.out.printf("%-15s %-10s", "Item", "Price");
			System.out.println();
			System.out.println("===========================");

			for (String product : products.keySet()) { // you've declared a new String with "product". Right hand side
														// is
														// going to pull something out and put it in product. You are
														// getting all the items from the left column.
				// System.out.println(product + "\t\t\t" + products.get(product)); // .get will
				// pull the associated info
				System.out.printf("%-15s %-10s", product, products.get(product));
				System.out.println();
			}

			// Prompt user for item name
			System.out.println("What item would you like to order?");

			// Get user input
			String userInput = scan.next();

			// add to order
			if (products.containsKey(userInput)) {
				System.out.println("Adding " + userInput + " to cart at " + products.get(userInput));
			} else {
				System.out.println("Sorry, we don't have those. Please try again.");
			}

			System.out.println();

			orderList.add(userInput);
			priceList.add(products.get(userInput));

			// prompt user to continue with order
			System.out.println("Would you like to order anything else (y/n)?");
			cont = scan.next();
			scan.nextLine();
		}

		System.out.println();
		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got:");

		// display user order items and prices in columns
		for (int i = 0; i < orderList.size(); i++) {
			System.out.printf("%-15s %-10s", orderList.get(i), priceList.get(i));
			System.out.println();
		}

		System.out.printf("Average price per item in order was %.2f", averagPrice(priceList));
		System.out.println();
		System.out.println("Good bye!");

	}
	// Method to determine average of price of items ordered

	public static Double averagPrice(ArrayList<Double> priceList) {
		Double sum = 0.0;
		for (int i = 0; i < priceList.size(); i++) {
			sum += priceList.get(i);
		}
		Double avg = sum / priceList.size();

		return avg;
	}
}
