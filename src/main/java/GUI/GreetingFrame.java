package GUI;
import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Luggage.LuggageManager;
import Ticket.TicketManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GreetingFrame extends JFrame implements ActionListener {
    //logo img resize
    int NEW_WIDTH = 250;
    int NEW_HEIGHT = 250;
    //button img resize
    int NEW_WIDTH1 = 50;
    int NEW_HEIGHT1 = 50;
    Font titleFont = new Font("Times", Font.PLAIN,50);
    Color LightBlue = new Color(148, 187,232);
    JLabel logoLabel = new JLabel();
    JLabel greetingLabel = new JLabel("Welcome to UTicket!");
    JButton button = new JButton();
    JPanel panel = new JPanel();
    FlightManager fm;
    TicketManager tm;
    CustomerManager cm;
    PHManager phm;
    LuggageManager lm;

    GreetingFrame(FlightManager fm, CustomerManager cm, TicketManager tm, PHManager phm, LuggageManager lm) {
        this.fm=fm;
        this.cm=cm;
        this.tm=tm;
        this.phm =phm;
        this.lm = lm;

        button.setText("Start");
        button.setFont(new Font("Times", Font.PLAIN,25));
        button.setForeground(LightBlue);
        button.addActionListener(this);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
/*        ImageIcon icon = new ImageIcon("Images/start.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( NEW_WIDTH1, NEW_HEIGHT1,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newImg);
        button.setIcon(icon);*/

        logoLabel.setBackground(Color.white);
        logoLabel.setOpaque(true);
        logoLabel.setVerticalAlignment(JLabel.CENTER);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        logoLabel.setBounds(50,50,100,100);
        ImageIcon icon1 = new ImageIcon("Images/img_1.png");
        Image img1 = icon1.getImage();
        Image newImg1 = img1.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH) ;
        icon1 = new ImageIcon(newImg1);
        logoLabel.setIcon(icon1);

        greetingLabel.setFont(titleFont);
        greetingLabel.setForeground(Color.white);
        greetingLabel.setBackground(LightBlue);
        greetingLabel.setOpaque(true);
        greetingLabel.setVerticalAlignment(JLabel.CENTER);
        greetingLabel.setHorizontalAlignment(JLabel.CENTER);
        greetingLabel.setBounds(50,50,100,100);
        greetingLabel.setHorizontalTextPosition(JLabel.CENTER);
        greetingLabel.setVerticalTextPosition(JLabel.CENTER);


        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(greetingLabel);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(logoLabel);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(button);
        panel.setPreferredSize(new Dimension(150,100));
        panel.setBackground(Color.white);
        panel.add(Box.createHorizontalGlue());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(LightBlue);
        this.setPreferredSize(new Dimension(500, 800));
        this.setLocation(new Point(500, 400));
        this.add(panel);
        this.pack();

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
           Login login = new Login(this.fm,this.cm,this.tm,this.phm, this.lm);//instantiate login frame
        }
    }

}