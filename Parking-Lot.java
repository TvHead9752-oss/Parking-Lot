import java.util.ArrayList;    
import java.util.Collections;  
import java.util.Random;       
import java.util.Scanner;      

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // List of parking spots (1 to 5)
        ArrayList<Integer> parkingSpots = new ArrayList<>();
        parkingSpots.add(1);
        parkingSpots.add(2);
        parkingSpots.add(3);
        parkingSpots.add(4);
        parkingSpots.add(5);

        // List to track each driver's parking time
        ArrayList<Double> parkingTimes = new ArrayList<>();

        // To get user input
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Loop until all spots are taken
        while (!parkingSpots.isEmpty()) {
            // Display welcome message
            System.out.println("Welcome to Blake's Automatic Parking System!");
            System.out.print("Would you like to park here? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            // Check if the user wants to park
            if (response.equals("no")) {
                System.out.println("Thank you! Have a great day!");
                break;  // Exit the program if the answer is "no"
            } else if (!response.equals("yes")) {
                System.out.println("Invalid input! Please respond with 'yes' or 'no'.");
                continue;  // Ask again if the input is invalid
            }

            // Ask the user how many hours they want to park
            System.out.print("Enter parking hours (0.5 to 12): ");
            double hours = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline

            // Check if the input is valid
            if (hours < 0.5 || hours > 12) {
                System.out.println("Invalid hours! Try again.");
                continue; // Skip to the next loop if input is invalid
            }

            // Add parking time to the list of times
            parkingTimes.add(hours);

            // Pick a random available spot
            int randomSpotIndex = random.nextInt(parkingSpots.size());
            int assignedSpot = parkingSpots.get(randomSpotIndex);

            // Inform the user of their assigned spot
            System.out.println("You can park for " + hours + " hours at spot #" + assignedSpot);
            System.out.println("Thank you for using the parking system!");

            // Remove the assigned spot from the available list
            parkingSpots.remove(randomSpotIndex);

            // Show how many spots are left
            if (!parkingSpots.isEmpty()) {
                System.out.println("There are " + parkingSpots.size() + " spots left: " + parkingSpots);
            } else {
                System.out.println("Sorry, no more spots available at this moment!");
                
                // All spots are taken, show next available time
                double nextAvailableTime = Collections.min(parkingTimes);
                Thread.sleep(4000);
                System.out.println("A spot will be available in " + nextAvailableTime + " hrs.");
                System.out.println("Please come back in " + nextAvailableTime + " hrs or reserve your spot now!");
            }

            System.out.println();
        }

        // Close scanner
        scanner.close();
    }
}
