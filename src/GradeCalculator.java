
/**
 * Author: Robert B. Mittnight III
 * Date: 5/10/2022
 * Purpose:
 */

public class GradeCalculator {

    public double calcFinalGrade(AssignmentList assignmentList, double desiredGrade) {
        double currentGrade = getWeightedGrade(assignmentList);
        int finalExamWeight = 100 - assignmentList.getCurrentTotalWeight();
        double weight = convertWeightToDecimal(finalExamWeight);
        return (desiredGrade - (1 - weight) * currentGrade) / weight;
    }

    public double getWeightedGrade(AssignmentList assignmentList) {
        double weightedGrade = 0;
        for (Assignment assignment : assignmentList.getAssignments()) {
            weightedGrade += assignment.getWeight() * assignment.getGrade();
        }

        return weightedGrade / assignmentList.getCurrentTotalWeight();
    }

    public double convertWeightToDecimal(int weight) {
        return (double) weight / 100;
    }
}
