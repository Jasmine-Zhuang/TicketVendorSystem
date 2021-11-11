package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;

public class GUI {
    public static void main(String[] args){
        //frame setup
        JFrame frame = new JFrame("UTicket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.setLocation(new Point(500, 500));

        frame.setLayout(null);


        //label setup
        Border border = BorderFactory.createLineBorder(Color.green,3);
        ImageIcon image = new ImageIcon("");//input icon file name
        JLabel label = new JLabel();
        frame.add(label);

        label.setText("");//input text to be displayed
        label.setIcon(image);

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

        label.setBounds(100,100,250,250);// set x,y position within frame as well as dimensions



    }
}
