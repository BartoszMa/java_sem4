import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {

    private ArrayList<Event>[] week;

    public Calendar() {
        this(7);
    }

    public Calendar(int days) {
        this.week = new ArrayList[days];
        for (int i = 0; i < days; i++) {
            week[i] = new ArrayList<>();
        }
    }

    public void addEvent(int day, Meeting meeting) {
        week[day].add(meeting);
    }

    public void addEvent(int day, Task task) {
        week[day].add(task);
    }

    public <T> void deleteMeeting(int day, Predicate<T> condition) {
        for (int i = 0; i < this.week[day].size(); i++) {
            if (condition.test((T) this.week[day].get(i))) {
                week[day].remove(i);
            }
        }
    }

    public <T> ArrayList<T> printDayWith(int day, Predicate<T> condition) {
        ArrayList<T> dayFinal = new ArrayList<>();
        for (int i = 0; i < this.week[day].size(); i++) {
            if (condition.test((T) this.week[day].get(i))) {
                dayFinal.add((T) this.week[day].get(i));
            }
        }
        return dayFinal;
    }

}