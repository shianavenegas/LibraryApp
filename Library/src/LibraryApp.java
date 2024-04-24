/**
 * 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Shiana Venegas
 */
public class LibraryApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> library = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        
        
     
     
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add or Update Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                continue;
        }
            
            switch (choice) {
            case 1:
                addOrUpdateBook(library, scanner);
                break;
            case 2:
                borrowBook(library, scanner);
                break;
            case 3:
                returnBook(library, scanner);
                break;
            case 4:
                System.out.println("Exiting the program. Thank you!");
                return;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
            
            }
        }
	}

            private static void addOrUpdateBook(Map<String, Integer> library, Scanner scanner) {
               
            	System.out.print("Enter book title: ");
                String title = scanner.nextLine().toLowerCase();

                System.out.print("Enter author: ");
                @SuppressWarnings("unused")
				String author = scanner.nextLine();

                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();

                String bookKey = title;

                if (library.containsKey(bookKey)) {
                    int existingQuantity = library.get(bookKey);
                    int updatedQuantity = existingQuantity + quantity;
                    library.put(bookKey, updatedQuantity);
                    System.out.println("Updated quantity for " + bookKey + ": " + updatedQuantity);
                } else {
                    // New book, add it to the library
                	library.put(bookKey, quantity);
                    System.out.println("Added " + bookKey + " to the library.");
                }
            }
            

            private static void borrowBook(Map<String, Integer> library, Scanner scanner) {
            	// Prompt user to borrow books
                System.out.print("Enter book title to borrow: ");
                String borrowTitle = scanner.nextLine().toLowerCase();

                System.out.print("Enter number of books to borrow: ");
                int borrowQuantity = scanner.nextInt();

                if (library.containsKey(borrowTitle)) {
                    int availableQuantity = library.get(borrowTitle);
                    if (availableQuantity >= borrowQuantity) {
                        // Sufficient books available, update quantity
                        int updatedQuantity = availableQuantity - borrowQuantity;
                        library.put(borrowTitle, updatedQuantity);
                        System.out.println("Successfully borrowed " + borrowQuantity + " books of " + borrowTitle);
                    } else {
                        System.out.println("Error: Not enough books available to borrow.");
                    }
                } else {
                    System.out.println("Error: Book not found in the library.");
                }
            }

            private static void returnBook(Map<String, Integer> library, Scanner scanner) {
            	// Prompt user to return books
                System.out.print("Enter book title to return: ");
                String returnTitle = scanner.nextLine().toLowerCase();

                System.out.print("Enter number of books to return: ");
                int returnQuantity = scanner.nextInt();

                if (library.containsKey(returnTitle)) {
                    int currentQuantity = library.get(returnTitle);
                    if (currentQuantity >= returnQuantity) {
                        // Sufficient books to return, update quantity
                        int updatedQuantity = currentQuantity - returnQuantity;
                        library.put(returnTitle, updatedQuantity);
                        System.out.println("Successfully returned " + returnQuantity + " books of " + returnTitle);
                    }else {
                        System.out.println("Error: Not enough books to return.");
                    }
                } else {
                    System.out.println("Error: Book not found in the library.");
                }
            }
}

    



