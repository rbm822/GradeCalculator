import javax.swing.*;

/**
 * Author: Robert B. Mittnight III
 * Date: 5/9/2022
 * Purpose:
 */

public class GradeCalculatorMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserInterface userInterface = new UserInterface();
                userInterface.start();
            }
        });
    }
}
 