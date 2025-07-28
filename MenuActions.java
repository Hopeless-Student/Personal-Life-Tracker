import java.util.Scanner;

public class MenuActions {

    Main main = new Main();
    LifeTracker lifeTracker = new LifeTracker();
    

    public void addLogEntry(LifeTracker lifeTracker, Scanner scanner) throws InterruptedException {
        main.printRunningText("\nAdding new log entry...", 15);
        Thread.sleep(1234);
        main.clearConsole();
        System.out.println("===================================");
        main.printRunningText("New Log Entry!", 15);
        float hoursStudied = 0;
        do{
            try { //hours studied
            System.out.print("Enter hours studied: ");
            hoursStudied = scanner.nextFloat();

            if(hoursStudied < 0) {
                System.out.print("\nHours studied cannot be negative. Please enter a valid number: ");
                
            }
        } catch (Exception e) {
            System.out.println("\nStrings are not allowed. Please enter a valid number for hours studied.");
            scanner.nextLine(); 
            hoursStudied = -1;
            }
        } while (hoursStudied < 0);
        
        // exercise done
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
                break;
            } else {
                System.out.print("Invalid input. Please enter 'Yes' or 'No': ");
                exerciseToday = scanner.nextLine().trim().toLowerCase();
            }
        }
        //mood rating
        float moodRating = 0;
        while (moodRating < 1 || moodRating > 10) {
            try {
                System.out.print("Rate your mood from 1 to 10: ");
                moodRating = scanner.nextFloat();

                if (moodRating < 1 || moodRating > 10) {
                    System.out.print("Invalid rating. Please enter a number between 1 and 10! ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("\nStrings are not allowed. Enter a valid mood rate!");
                scanner.nextLine();
            }
        }
        
        scanner.nextLine(); 
        System.out.print("Any additional notes? ");
        String notes = scanner.nextLine();
        
        LogEntry logEntry = new LogEntry(hoursStudied, exerciseDone, moodRating, notes);
        lifeTracker.addEntry(logEntry);
        System.out.println("Log entry added successfully.");
        System.out.println("===================================");
        main.printRunningText("Returning to main menu...", 30);
        Thread.sleep(1500);
        main.clearConsole();
        
    }

        public void removeLogEntry(LifeTracker lifeTracker, Scanner scanner) throws InterruptedException {
        main.printRunningText("\nRemoving log entry...", 15);
        Thread.sleep(1234);
        main.clearConsole();

        System.out.println("===================================");
        lifeTracker.displayAllEntries();

        int maxAttempts = 5;
        int attempts = 0;
        int index = -1;

        while (attempts < maxAttempts) {
            System.out.print("Enter the index of the entry to remove: ");
            try {
                index = scanner.nextInt() - 1;
                scanner.nextLine();
                System.out.println(attempts);
                if (index < 0 || index >= lifeTracker.getEntrySize()) {
                    System.out.println("Invalid index. Try again.");
                    attempts++;
                    continue;
                }

                if (confirmRemoval(scanner, index)) {
                    lifeTracker.removeEntry(index);
                    System.out.println("Entry removed successfully.");
                } else {
                    System.out.println("Removal cancelled.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
                attempts++;
            }
        }

        if (attempts >= maxAttempts) {
            System.out.println("Too many invalid attempts.");
            Thread.sleep(1234);
        }

        System.out.println("===================================");
        main.printRunningText("Returning to main menu...", 30);
        Thread.sleep(1500);
        main.clearConsole();
    }


    public boolean confirmRemoval(Scanner scanner, int index) {
    while (true) {
        System.out.print("Confirm removal of entry " + (index + 1) + "? (Yes/No): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("yes") || input.equals("y")) {
            return true;
        } else if (input.equals("no") || input.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
        }
    }
}


    
}