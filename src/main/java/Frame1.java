import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    Frame1(){
    //setup button
        button = new JButton();
        button.setBounds(100,100,250,250);
        //set image for button
        ImageIcon icon = new ImageIcon("src/main/java/flight_ticket.png");
        int NEW_WIDTH = 50;
        int NEW_HEIGHT = 50;
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newImg);
        button.setIcon(icon);
        //set text for button
        button.setText("Click this button");
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD,25));
        button.setIconTextGap(-15);
        button.setForeground(Color.RED);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());

        /*button.addActionListener(this);*/ //will call the actionPerformed method
        button.addActionListener(e -> System.out.println("Clicked"));
        button.setFocusable(false);// get rid of the line around the button box

    //setup label
        label = new JLabel();
        label.setIcon(icon);
        label.setBounds(150,250,150,150);
        label.setVisible(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

  /* Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("Clicked.");
            button.setEnabled(false);// button can be clicked only once
            label.setVisible(true);//after click, display the label
        }

    }
}

