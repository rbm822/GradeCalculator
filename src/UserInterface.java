import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Robert B. Mittnight III
 * Date: 5/15/2022
 * Purpose:
 */

public class UserInterface {
    private GradeCalculator gradeCalculator;
    private AssignmentList assignments;
    private List<InputView> inputViewPanels;

    public UserInterface() {
        this.assignments = new AssignmentList();
        this.gradeCalculator = new GradeCalculator(assignments);
        this.inputViewPanels = new ArrayList<>();
    }

    public void start() {
        // Configure the main frame
        JFrame mainFrame = new JFrame("Grade Calculator");
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configure Input Panel
        buildInputPanels(inputViewPanels, 5);
        displayPanels(mainFrame, inputViewPanels);

        // Output Panel
        JPanel outputPnl = new JPanel();
        JLabel currentGradeLbl = new JLabel("Current Grade: ");
        JLabel desiredGradeLbl = new JLabel("Required Grade for an 'A': ");
        JLabel currentGradeResultsLbl = new JLabel();
        JLabel desiredGradeResultsLbl = new JLabel();
        outputPnl.add(currentGradeLbl);
        outputPnl.add(currentGradeResultsLbl);
        outputPnl.add(desiredGradeLbl);
        outputPnl.add(desiredGradeResultsLbl);
        mainFrame.add(outputPnl);

        // Button Panel
        JPanel btnPnl = new JPanel();
        JButton calcGradeBtn = new JButton("Calculate Grade");
        JButton clearBtn = new JButton("Clear");
        btnPnl.add(calcGradeBtn);
        btnPnl.add(clearBtn);
        mainFrame.add(btnPnl);

        // Event Listeners
        calcGradeBtn.addActionListener(e -> {
            try {
                buildAssignmentList();
            } catch (NumberFormatException exception) {}

            gradeCalculator.calculateGrades(90);
            displayGrade(currentGradeResultsLbl, gradeCalculator.getCurrentGrade());
            displayGrade(desiredGradeResultsLbl, gradeCalculator.getGradeNeededForDesiredGrade());
        });

        clearBtn.addActionListener(e -> {
        });

        // Display the main JFrame.
        mainFrame.setVisible(true);
    }

    public void displayGrade(JLabel label, double grade) {
        label.setText(label.getText() + " " + grade);
    }

    public void buildAssignmentList() {
        for (InputView inputView : inputViewPanels) {
            this.assignments.add(new Assignment(inputView.getGrade(), inputView.getWeight()));
        }
    }

    public void displayPanels(JFrame jFrame, List<InputView> inputViewPanels) {
        for (InputView inputPnl : inputViewPanels) {
            jFrame.add(inputPnl.getNewInputPnl());
        }
    }

    public void buildInputPanels(List<InputView> inputViewPanels, int numOfPanels) {
        for (int i = 0; i < numOfPanels; i++) {
            inputViewPanels.add(new InputView());
        }
    }
}
