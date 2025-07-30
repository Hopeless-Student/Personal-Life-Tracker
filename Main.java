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
    public void printRunningText(String text, int delay) {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Error in delay: " + e.getMessage());
                }
            }
            System.out.println();
        }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LifeTracker lifeTracker = new LifeTracker();
        Main main = new Main();
        MenuActions menuActions = new MenuActions();
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
                    menuActions.addLogEntry(lifeTracker, scanner);
                        break;
                    case 2:
                    if (lifeTracker.isEmpty()) {
                      System.out.println("No existing record!");
                    } else {
                        menuActions.removeLogEntry(lifeTracker, scanner);
                    }
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
