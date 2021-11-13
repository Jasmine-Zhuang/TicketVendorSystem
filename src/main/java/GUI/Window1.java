package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Window1 extends JFrame implements ActionListener {
    JLabel label = new JLabel("Hi!");
    JButton button = new JButton("button");

    Window1(){
        button.setBounds(200, 100, 100, 50);
        button.addActionListener(this);
        label.setBounds(0,0,100,150);
        label.setFont(new Font(null,Font.PLAIN,25));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);
        this.add(label);
        this.add(button);

    }

    public static void main(String[] args) {
        new Window1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DisplayPriceFrame dpf = new DisplayPriceFrame();
        dpf.getInfo(2500);
        this.dispose();

    }
}
