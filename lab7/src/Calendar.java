import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {

    private ArrayList<Meeting>[] week;

    public Calendar() {
        this(7);
    }

    public Calendar(int days) {
        this.week = new ArrayList[days];
        for (int i = 0; i < days; i++) {
            week[i] = new ArrayList<>();
        }
    }

    public void addMeeting(int day, String description, LocalTime meetingStart, LocalTime meetingEnd, int priority) {
        week[day].add(new Meeting(description, meetingStart, meetingEnd, priority));
    }

    public void deleteMeeting(int day, int numMeeting) {
        week[day].remove(numMeeting);
    }

    public ArrayList<Meeting> printDayWith(int day, Predicate<Meeting> condition){
        ArrayList<Meeting> dayFinal = new ArrayList<>();
        for (int i = 0; i < this.week[day].size(); i++) {
            if (condition.test(this.week[day].get(i))) {
                dayFinal.add(this.week[day].get(i));
            }
        }
        return dayFinal;
    }
}