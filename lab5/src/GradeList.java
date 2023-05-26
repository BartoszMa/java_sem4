import java.util.ArrayList;
import java.util.Collections;

public class GradeList {
    private final ArrayList<Double> grades = new ArrayList<>();

    public GradeList() {
    }

    public void addGrade(double newGrade) {
        this.grades.add(newGrade);
    }

    public boolean isArrayEmpty() {
        return this.grades.isEmpty();
    }

    public double averageGrade() {
        double helperSum = 0;
        for (double grade : grades) {
            helperSum += grade;
        }
        return helperSum / grades.size();
    }

    public double maxGrade() {
        return Collections.max(grades);
    }

    public double minGrade() {
        return Collections.min(grades);
    }
}