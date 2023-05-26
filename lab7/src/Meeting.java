import java.time.LocalTime;

public class Meeting extends Event {

    private Priority priority;

    enum Priority {NOT_GIVEN, LOW, MEDIUM, HIGH}

    public Meeting(String description, LocalTime meetingStart, LocalTime meetingEnd, int prior) {
        super(description, meetingStart, meetingEnd);
        this.priority = setPriority(prior);
    }

    public Priority getPriority() {
        return this.priority;
    }

    public static Priority setPriority(int prior) {
        if (prior == 0) {
            return Priority.LOW;
        } else if (prior == 1) {
            return Priority.MEDIUM;
        } else if (prior == 2) {
            return Priority.HIGH;
        }
        return Priority.NOT_GIVEN;
    }

    @Override
    public String toString() {
        return "description: " + this.description + "\nstart: " + this.meetingStart + "\nend: " + this.meetingEnd + "\npriority: " + this.priority + "\n";
    }
}