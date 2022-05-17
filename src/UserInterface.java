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
        buildInputPanels(inputViewPanels, 3);
        displayPanels(mainFrame, inputViewPanels);

        // Output Panel
        JPanel outputPnl = new JPanel();
        JLabel resultsLbl = new JLabel("");
        outputPnl.add(resultsLbl);
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
            // Allows the list of assignments to be built if some TextFields are blank.
            try {
                buildAssignmentList();
            } catch (NumberFormatException exception) {}

            gradeCalculator.calculateGrades(90);
            resultsLbl.setText(gradeCalculator.toString());
        });

        clearBtn.addActionListener(e -> {
            // TODO Is there a better way to do this?
            for (InputView view : inputViewPanels) {
                view.getGradeInput().setText("");
                view.getWeightInput().setText("");
            }

            resultsLbl.setText("");
            assignments.clearAssignments();
            assignments.emptyWeight();
            // Sets the grades to 0 otherwise the previous grades will be in new calculations.
            gradeCalculator.clearGrades();
        });

        // Display the main JFrame.
        mainFrame.setVisible(true);
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
