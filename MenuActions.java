import java.lang.reflect.Array;
import java.util.Scanner;

public class MenuActions {

    Main main = new Main();
    LifeTracker lifeTracker = new LifeTracker();
    

    public void addLogEntry(LifeTracker lifeTracker, Scanner scanner) throws InterruptedException {
        main.printRunningText("\nAdding new log entry...", 30);
        Thread.sleep(1234);
        main.clearConsole();
        System.out.println("===================================");
        main.printRunningText("New Log Entry!", 30);
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
        main.printRunningText("\nRemoving log entry...", 30);
        Thread.sleep(1234);
        main.clearConsole();
        System.out.println("===================================");
        lifeTracker.displayAllEntries();
        System.out.print("Enter the index of the entry to remove: ");
        int index;
        boolean isRemoved = false;
        do{
            try { // index to be removed
            
            index = scanner.nextInt() -1;

            if(index < 0 || index >= lifeTracker.getEntrySize()) {
               System.out.print("Invalid index. Please enter a valid index: ");
               //index = scanner.nextInt() -1;
            }else {
                lifeTracker.removeEntry(index);
                isRemoved = true;
                break;
            }
        } catch (Exception e) {
            System.out.print("\nStrings are not allowed. Please enter a valid index to be removed: ");
            scanner.nextLine(); 
            index = -1;
            }
        } while (isRemoved == false);
        
        System.out.println("===================================");
        main.printRunningText("Returning to main menu...", 30);
        Thread.sleep(1500);
        //main.clearConsole();
    }
}