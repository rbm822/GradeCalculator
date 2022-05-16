import javax.swing.*;

/**
 * Author: Robert B. Mittnight III
 * Date: 5/15/2022
 * Purpose:
 */

public class InputView {
    private JPanel inputPnl;
    private JLabel gradeLbl, weightLbl;
    private JTextField gradeInput, weightInput;

    public InputView() {
        this.inputPnl = new JPanel();
        this.gradeLbl = new JLabel("Grade: ");
        this.weightLbl = new JLabel("Weight: ");
        this.gradeInput = new JTextField(5);
        this.weightInput = new JTextField(5);

        this.inputPnl.add(gradeLbl);
        this.inputPnl.add(gradeInput);
        this.inputPnl.add(weightLbl);
        this.inputPnl.add(weightInput);
    }

    public double getGrade() {
        return Double.parseDouble(this.gradeInput.getText());
    }

    public int getWeight() {
        return Integer.parseInt(this.weightInput.getText());
    }

    public JTextField getGradeInput() {
        return this.gradeInput;
    }

    public JTextField getWeightInput() {
        return this.weightInput;
    }

    public JPanel getNewInputPnl() {
       return this.inputPnl;
    }
}
