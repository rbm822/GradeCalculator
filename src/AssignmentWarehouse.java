import java.util.ArrayList;
import java.util.List;

/**
 * Author: Robert B. Mittnight III
 * Date: 5/9/2022
 * Purpose:
 */

public class AssignmentWarehouse {
    private List<Assignment> assignments;
    private final int MAX_WEIGHT;
    private int currentTotalWeight;

    public AssignmentWarehouse() {
        this.assignments = new ArrayList<>();
        this.MAX_WEIGHT = 100;
        this.currentTotalWeight = 0;
    }

    private boolean maxWeightWillBeExceeded(Assignment assignment) {
        return this.currentTotalWeight + assignment.getWeight() > MAX_WEIGHT;
    }

    /**
     * Adds a new assignment if the weight of the assignment does not exceed the MAX_WEIGHT (100).
     * @param assignment
     */
    public void add(Assignment assignment) {
        if (maxWeightWillBeExceeded(assignment)) {
            System.out.println("Weight will exceed max weight of 100!");
            return;
        }

        this.currentTotalWeight += assignment.getWeight();
        this.assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return this.assignments;
    }
}
