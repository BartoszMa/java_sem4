import java.time.LocalTime;

abstract class Event {

    public static final LocalTime TIME = LocalTime.of(8, 0);
    protected String description;
    protected LocalTime meetingStart;
    protected LocalTime meetingEnd;

    public Event(String description, LocalTime meetingStart, LocalTime meetingEnd) {
        this.description = description;
        this.meetingStart = meetingStart;
        this.meetingEnd = meetingEnd;
    }

    public LocalTime getStartTime() {
        return this.meetingStart;
    }

    public LocalTime getEndTime() {
        return this.meetingEnd;
    }
}