package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;

public class GUI {
    public static void main(String[] args){
        //enable frame icon display
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //label setup
        Border border = BorderFactory.createLineBorder(Color.green,3);
        JLabel label = new JLabel();
        label.setText("Welcome to UTicket!");//input text to be displayed
        label.setHorizontalTextPosition(JLabel.CENTER); //left,center,right of image icon
        label.setVerticalTextPosition(JLabel.TOP);//top,center,bottom
        label.setForeground(Color.black);// or new Color(rgb, or hex)
        label.setFont(new Font("MV Boli", Font.PLAIN,20));//font name, font style, and size
        label.setIconTextGap(-10);// set gap of text to image
        label.setBackground(Color.ORANGE);// set background color of label
        label.setOpaque(true);
        label.setBorder(border);// set border for the label
        label.setVerticalAlignment(JLabel.CENTER);// set position of text and image within label
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(10,10,350,350);// set x,y position within frame as well as dimensions

        // Panel setup
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,450,450);
        redPanel.setLayout(null);
        redPanel.add(label); // add label

        //frame setup
        JFrame frame = new JFrame("UTicket");
        /*ImageIcon image = new ImageIcon("flight_ticket.png");//input icon file name
        frame.setIconImage(image.getImage());*/
        Image icon = Toolkit.getDefaultToolkit().getImage("src/main/java/GUI/flight_ticket.png");
        frame.setIconImage(icon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.setLocation(new Point(500, 500));
        frame.setSize(550,550);
        frame.setLayout(null);
        frame.add(redPanel);
        /*frame.pack();
        // adjust sizes of the components automatically as you adjust the size of the frame;
        //if it's used, delete label.setBounds, frame.setLayout, frame.setSize*/



    }
}
