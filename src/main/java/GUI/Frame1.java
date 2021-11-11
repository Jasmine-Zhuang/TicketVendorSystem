package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {
    JButton button;
    Frame1(){
    //setup button
        button = new JButton();
        button.setBounds(100,100,250,250);

        //set image for button
        ImageIcon icon = new ImageIcon("src/main/java/flight_ticket.png");
        int NEW_WIDTH = 50;
        int NEW_HEIGHT = 50;
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon( newimg );
        button.setIcon(icon);

        //set text for button
        button.setText("Click this button");
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD,25));

        /*button.addActionListener(this);*/ //will call the actionPerformed method
        button.addActionListener(e -> System.out.println("Clicked"));
        button.setFocusable(false);// get rid of the line around the button box





        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);

    }

  /* Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("Clicked.");
        }

    }
}

