/**
 * Author: Robert B. Mittnight III
 * Date: 5/9/2022
 * Purpose:
 */

public class GradeCalculatorMain {
    public static void main(String[] args) {
        GradeCalculator gradeCalculator = new GradeCalculator();
        AssignmentList assignmentList = new AssignmentList();
        assignmentList.add(new Assignment(80, 40));
        assignmentList.add(new Assignment(65, 20));
        assignmentList.add(new Assignment(65, 20));

        System.out.println("Current grade: " + gradeCalculator.getWeightedGrade(assignmentList));
        System.out.println("Grade needed: " + gradeCalculator.calcFinalGrade(assignmentList, 90));
    }
}
