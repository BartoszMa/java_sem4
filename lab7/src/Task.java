import java.time.LocalTime;

public class Task extends Event {

    private Status status;

    enum Status {PLANNED, CONFIRMED, IN_PROGRESS, DONE, NOT_GIVEN}

    public Task(String description, LocalTime meetingStart, LocalTime meetingEnd, int status) {
        super(description, meetingStart, meetingEnd);
        this.status = setStatus(status);
    }

    public Status getStatus() {
        return this.status;
    }


    public static Status setStatus(int stat) {
        if (stat == 0) {
            return Status.PLANNED;
        } else if (stat == 1) {
            return Status.CONFIRMED;
        } else if (stat == 2) {
            return Status.IN_PROGRESS;
        } else if (stat == 3) {
            return Status.DONE;
        }
        return Status.NOT_GIVEN;
    }

    @Override
    public String toString() {
        return "description: " + this.description + "\nstart: " + this.meetingStart + "\nend: " + this.meetingEnd + "\nstatus: " + this.status + "\n";
    }

}