package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String args[]){
        JFrame frame = new JFrame("UTicket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.setLocation(new Point(500, 300));

        JLabel label = new Label();

    }
}
