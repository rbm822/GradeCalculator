
/**
 * Author: Robert B. Mittnight III
 * Date: 5/10/2022
 * Purpose:
 */

public class GradeCalculator {
    private double currentGrade;
    private double gradeNeededForDesiredGrade;
    private AssignmentList assignments;

    public GradeCalculator(AssignmentList assignments) {
        this.assignments = assignments;
    }

    public void calculateGrades(double desiredGrade) {
        calcCurrentGrade();
        calcDesiredFinalGrade(desiredGrade);
    }

    public double getCurrentGrade() {
        return currentGrade;
    }

    public double getGradeNeededForDesiredGrade() {
        return gradeNeededForDesiredGrade;
    }

    public void clearGrades() {
        this.currentGrade = 0;
        this.gradeNeededForDesiredGrade = 0;
    }

    private void calcCurrentGrade() {
        double weightedGrade = 0;
        for (Assignment assignment : assignments.getAssignments()) {
            weightedGrade += assignment.getWeight() * assignment.getGrade();
        }

        this.currentGrade = weightedGrade / assignments.getCurrentTotalWeight();
    }

    private void calcDesiredFinalGrade(double desiredGrade) {
        int finalExamWeight = 100 - assignments.getCurrentTotalWeight();
        double weight = convertWeightToDecimal(finalExamWeight);
        this.gradeNeededForDesiredGrade = (desiredGrade - (1 - weight) * currentGrade) / weight;
    }

    private double convertWeightToDecimal(int weight) {
        return (double) weight / 100;
    }
}
