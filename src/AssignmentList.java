import java.util.ArrayList;
import java.util.List;

/**
 * Author: Robert B. Mittnight III
 * Date: 5/9/2022
 * Purpose:
 */

public class AssignmentList {
    private List<Assignment> assignments;
    private final int MAX_WEIGHT;
    private int currentTotalWeight;

    public AssignmentList() {
        this.assignments = new ArrayList<>();
        this.MAX_WEIGHT = 100;
        this.currentTotalWeight = 0;
    }

    public boolean maxWeightWillBeExceeded(Assignment assignment) {
        return this.currentTotalWeight + assignment.getWeight() > MAX_WEIGHT;
    }

    public boolean weightIsLessThanZero(Assignment assignment) {
        return assignment.getWeight() <= 0;
    }

    public int getCurrentTotalWeight() {
        return currentTotalWeight;
    }

    public void add(Assignment assignment) {
        if (maxWeightWillBeExceeded(assignment) || weightIsLessThanZero(assignment)) {
            return;
        }

        this.currentTotalWeight += assignment.getWeight();
        this.assignments.add(assignment);
    }

    public void remove(Assignment assignment) {
        if (this.assignments.contains(assignment)) {
            currentTotalWeight -= assignment.getWeight();
            this.assignments.remove(assignment);
        }
    }

    public List<Assignment> getAssignments() {
        return this.assignments;
    }
}
