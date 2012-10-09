package se.fronix.rita;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
 
 
public class PositiveCartesianUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
             
            @Override
            public void run() {
                PositiveCartesianFrame frame = new PositiveCartesianFrame();
                frame.showUI();
            }
        });
    }
}
 
class PositiveCartesianFrame extends JFrame {
    PositiveCartesianPanel panel;
     
    public PositiveCartesianFrame() {
        panel = new PositiveCartesianPanel();
        getContentPane().add(panel);
    }
     
    public void showUI() {
        setTitle("Basic user interface program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setVisible(true);
    }
}
 
class PositiveCartesianPanel extends JPanel {
    PositiveCartesian cartesian;
     
    public PositiveCartesianPanel() {
 
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
         
        cartesian = new PositiveCartesian(450, 450);
        cartesian.populateAxisWithAdditionalNumbers(true);
        cartesian.drawCartesian(g);
        
        g2.draw(new Line2D.Double(50, 500, 100, 400));
    }
}