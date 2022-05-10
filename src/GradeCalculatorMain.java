/**
 * Author: Robert B. Mittnight III
 * Date: 5/9/2022
 * Purpose:
 */

public class GradeCalculatorMain {
    public static void main(String[] args) {
        AssignmentList assignmentList = new AssignmentList();
        GradeCalculator gradeCalculator = new GradeCalculator(assignmentList);

        assignmentList.add(new Assignment(50, 10));
        assignmentList.add(new Assignment(60, 10));
        assignmentList.add(new Assignment(70, 10));
        assignmentList.add(new Assignment(80, 10));

        System.out.println(gradeCalculator.getAverageOfAssignments());
    }
}
