package template;

import GUI.Window1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreetingFrame extends JFrame implements ActionListener {
    int NEW_WIDTH = 250;
    int NEW_HEIGHT = 250;
    Font font = new Font("Times", Font.PLAIN,20);
    JButton button = new JButton("Start");
    JLabel label = new JLabel("Welcome to UTicket!");

    JPanel panel = new JPanel();
    /*Border border = BorderFactory.createLineBorder(Color.white,1);*/
    ImageIcon icon = new ImageIcon("Images/UStore_logo.png");

    GreetingFrame(){

        button.setBounds(100,160,200,40);
        button.setFocusable(false);
        button.addActionListener(this);
        button.setFont(font);
        button.setForeground(Color.RED);
        button.setBackground(Color.lightGray);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.black);
        label.setFont(font);
        label.setIconTextGap(5);
        label.setBackground(Color.white);
        label.setOpaque(true);
        /*label.setBorder(border);*/
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(10,10,450,450);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH) ;
        icon = new ImageIcon(newImg);
        label.setIcon(icon);

        panel.setBackground(Color.lightGray);
        panel.setBounds(0,0,450,450);
        panel.setLayout(null);
        panel.add(label);
        panel.add(button);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(255,255,255));
        this.setLocation(new Point(500, 500));
        this.setSize(550,550);
        this.add(button);
        this.add(panel);
        this.add(label);
        this.setLayout(new FlowLayout());
        /*this.pack();*/

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button == e.getSource()){
            this.dispose();
        /*    Window1 w1 = new Window1();//instantiate login frame*/

    }
    }

    public static void main(String[] args) {
        new GreetingFrame();
    }
}
