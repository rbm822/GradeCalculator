/**
 * Author: Robert B. Mittnight III
 * Date: 5/9/2022
 * Purpose:
 */

public class GradeCalculatorMain {
    public static void main(String[] args) {
        AssignmentWarehouse assignmentWarehouse = new AssignmentWarehouse();
        Assignment assignment1 = new Assignment(50, 100);
        Assignment assignment2 = new Assignment(50, 35);
        Assignment assignment3 = new Assignment(50, 10);
        Assignment assignment4 = new Assignment(50, 15);

        assignmentWarehouse.add(assignment1);
        assignmentWarehouse.add(assignment2);
        assignmentWarehouse.add(assignment3);
        assignmentWarehouse.add(assignment4);

        System.out.println(assignmentWarehouse.getAssignments().size());
    }
}
