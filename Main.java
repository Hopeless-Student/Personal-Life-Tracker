import java.io.IOException;
import java.util.Scanner;

public class Main {
    public void mainMenu() {
        System.out.println("Personal Life Tracker Menu:");
        System.out.println("1. Add Log Entry");
        System.out.println("2. Remove Log Entry");
        System.out.println("3. Display All Entries");
        System.out.println("4. Get Number of Entries");
        System.out.println("5. Check if Tracker is Empty");
        System.out.println("6. Exit");
        System.out.print("Please select an option (1-6): ");
    }

    public void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Unable to clear the console.");
        }
    }
    public void addLogEntry(LifeTracker lifeTracker, Scanner scanner) {
        System.out.println("\nAdding a new log entry...");
        float hoursStudied = 0;
        do{
            try { //hours studied
            scanner.nextLine(); 
            System.out.print("Enter hours studied: ");
            hoursStudied = scanner.nextFloat();

            if(hoursStudied < 0) {
                System.out.print("\nHours studied cannot be negative. Please enter a valid number: ");
                hoursStudied = scanner.nextFloat();
            }
        } catch (Exception e) {
            System.out.println("\nStrings are not allowed. Please enter a valid number for hours studied.");
        }
        } while (hoursStudied < 0);
        
        
        System.out.print("Did you exercise today? (Yes/No): ");
        boolean exerciseDone = false;
        scanner.nextLine(); 
        String exerciseToday = scanner.nextLine().trim().toLowerCase();
        while (exerciseDone == false) {
            if (exerciseToday.equals("yes") || exerciseToday.equals("y")) {
                exerciseToday = "Yes";
                exerciseDone = true;
            } else if (exerciseToday.equals("no") || exerciseToday.equals("n")) {
                exerciseToday = "No";
                exerciseDone = false;
            } else {
                System.out.print("Invalid input. Please enter 'Yes' or 'No': ");
                exerciseToday = scanner.nextLine().trim().toLowerCase();
            }
        }
        
        System.out.print("Rate your mood from 1 to 10: ");
        int moodRating = scanner.nextInt();
        
        scanner.nextLine(); 
        System.out.print("Any additional notes? ");
        String notes = scanner.nextLine();
        
        LogEntry logEntry = new LogEntry(hoursStudied, exerciseDone, moodRating, notes);
        lifeTracker.addEntry(logEntry);
        System.out.println("Log entry added successfully.");
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LifeTracker lifeTracker = new LifeTracker();
        Main main = new Main();
        System.out.println("HELLO GIT!");
        System.out.println("===================================");
        System.out.println("Welcome to the Personal Life Tracker!\n");
        int choice = 0;

        do {
            main.mainMenu();
            try {
                choice = scanner.nextInt();
                if(choice < 1 || choice > 6) {
                    System.out.println("Invalid choice. Please select a number between 1 and 6.");
                    continue;
                }

                switch (choice) {
                    case 1:
                    main.addLogEntry(lifeTracker, scanner);
                        break;
                    case 2:

                        break;

                    case 3:
                        lifeTracker.displayAllEntries();
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nStrings are not allowed.");
                scanner.nextLine();
            }
        } while (choice != 6);
        
    }
}
