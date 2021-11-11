package GUI;

import javax.swing.*;
import java.awt.*;

public class Window1 {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hi!");
    Window1(){
        label.setBounds(0,0,100,150);
        label.setFont(new Font(null,Font.PLAIN,25));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);

    }
}
