import java.util.ArrayList;
public class LifeTracker {
    private ArrayList<LogEntry> entries;

    public LifeTracker() {
        entries = new ArrayList<>();
    }
    public void addEntry(LogEntry entry) {
        entries.add(entry);
    }

    public void removeEntry(int index) {
        if (index >= 0 && index < entries.size()) {
            entries.remove(index);
            System.out.println("Entry removed successfully.");
        } else {
            System.out.println("Invalid index. No entry removed.");
        }
    }
    
    public void displayAllEntries() {
        int logCounter = 1;
        for (LogEntry entry : entries) {
            System.out.println("Log Entry #" + logCounter+ "\n");
            entry.displayEntry();
            System.out.println("--------------------");
            logCounter++;
        }
    }
    public void getNumberOfEntries() {
        System.out.println("Total number of entries: " + entries.size());
    }

    public void isEmpty(){
        if(entries.isEmpty()){
            System.out.println("No entries found.");
        } else {
            System.out.println("Entries found.");
        }

    }
}
