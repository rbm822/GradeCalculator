import java.util.Objects;

/**
 * Author: Robert B. Mittnight III
 * Date: 5/9/2022
 * Purpose:
 */

public class Assignment {
    private double grade;
    private int weight;

    public Assignment(double grade, int weight) {
        this.grade = grade;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return Double.compare(that.grade, grade) == 0 && weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, weight);
    }
}
