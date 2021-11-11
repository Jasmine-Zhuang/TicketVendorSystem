import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String args[]){
        JFrame frame = new JFrame("UTicket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
       /* JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame*/
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(255,255,255));
    }
}
