import java.time.LocalDateTime;

public class LogEntry{

    LocalDateTime dateTime = LocalDateTime.now();
    private float hoursStudied;
    private boolean exerciseDone;
    private float moodRating;
    private String notes;

    public LogEntry(float hoursStudied, boolean exerciseDone, float moodRating, String notes) {
        this.hoursStudied = hoursStudied;
        this.exerciseDone = exerciseDone;
        this.moodRating = moodRating;
        this.notes = notes;
    }

    public void displayEntry() {
        System.out.println("Date and Time: " + getDateTime());
        System.out.println("Hours Studied: " + hoursStudied);
        System.out.println("Exercise Done: " + (exerciseDone ? "Yes" : "No"));
        System.out.println("Mood Rating: " + moodRating);
        System.out.println("Notes: " + notes);
    }
    /* Getters method */
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public float getHoursStudied() {
        return hoursStudied;
    }
    public boolean getExerciseDone() {
        return exerciseDone;
    }
    public float getMoodRating() {
        return moodRating;
    }
    public String getNotes() {
        return notes;
    }
    
    /* Setters method */
    public void setHoursStudied(float hoursStudied) {
        this.hoursStudied = hoursStudied;
    }
    public void setExerciseDone(boolean exerciseDone) {
        this.exerciseDone = exerciseDone;
    }
    public void setMoodRating(int moodRating) {
        this.moodRating = moodRating;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

}