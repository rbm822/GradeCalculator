/**
 * Author: Robert B. Mittnight III
 * Date: 5/10/2022
 * Purpose:
 */

public class GradeCalculator {
    private AssignmentList assignments;

    public GradeCalculator(AssignmentList assignments) {
        this.assignments = assignments;
    }

    public double getAverageOfAssignments() {
        if (assignments.getAssignments().isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Assignment assignment : assignments.getAssignments()) {
            sum += assignment.getGrade();
        }

        return sum / assignments.getAssignments().size();
    }

    public double getFinalGrade() {
        if (assignments.getCurrentTotalWeight() != 100) {
            return 0.0;
        }

        return 0.0;
    }
}
// Gather the numbers you would like to average
// Determine the weight value of each number
// Multiply each number by its weighting factor (w)
// Add the resulting numbers together to find the weighted average
