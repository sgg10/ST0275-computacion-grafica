package Workshops.W01_Bresenham;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Bresenham {

    public void main() {
        // SwingUtilities.invokeLater(Bresenham::run);
    }

    public void run() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setTitle("Bresenham");

        Panel panel = new Panel();
        panel.addMouseListener(panel);

        f.getContentPane().add(panel);
        f.pack();

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
