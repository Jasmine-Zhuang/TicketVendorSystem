package GUI;

import Customer.CMSerialization;
import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import GUI.Select_Meal.Select_Meal;
import GUI.Select_Meal.select_meal_main;
import Ticket.TicketManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Luggage.LuggageManager;


public class Luggage_Meal_Main extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("Do you want to add Meal or add Luggage to your ticket? ");

    String instruction = "<html> You need to click the button below:";
    JLabel label2 = new JLabel(instruction);
    JButton button1 = new JButton("Add Meal");
    JButton button2 = new JButton("Add Luggage");
    JButton button3 = new JButton("Skip");
    Color darkRed = new Color(101,15,43);
    Color lightPink = new Color(218,198,205);

    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    String username;
    PHManager phm;
    LuggageManager lm;
    String ticket_id;

    public Luggage_Meal_Main(CustomerManager customerManager, FlightManager flightManager, TicketManager ticketManager,
                            String username, PHManager phm, LuggageManager lm, String ticket_id) {
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.username=username;
        this.phm=phm;
        this.lm = lm;
        this.ticket_id = ticket_id;


        button1.setFont(new Font("Times", Font.PLAIN,25));
        button1.setForeground(darkRed);
        button1.addActionListener(this);

        button2.setFont(new Font("Times", Font.PLAIN,25));
        button2.setForeground(darkRed);
        button2.addActionListener(this);

        button3.setFont(new Font("Times", Font.PLAIN,25));
        button3.setForeground(darkRed);
        button3.addActionListener(this);

        label1.setBackground(lightPink);
        label1.setFont(new Font("Times", Font.BOLD,30));
        label1.setForeground(darkRed);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setOpaque(true);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(50,50,100,100);

        label2.setBackground(lightPink);
        label2.setForeground(darkRed);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.CENTER);
        label2.setOpaque(true);
        label2.setFont(new Font("Times", Font.ITALIC,20));
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBounds(50,50,300,300);

        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(20,20)));
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(button3);
        panel.setBackground(lightPink);
        panel.add(Box.createHorizontalGlue());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(350, 320));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button1 == e.getSource()){
            this.dispose();
            select_meal_main select_meal= new select_meal_main(this.cm, this.fm, this.tm,this.username,this.phm,
                    this.lm, this.ticket_id);//instantiate next page for routes picking
        }
        else if(button2 == e.getSource()){
            this.dispose();
            LuggageFrame select_luggage= new LuggageFrame(this.fm, this.cm, this.tm, this.phm,
                    this.lm, this.username,this.ticket_id);//instantiate next page for routes picking
        }
        else if(button3 == e.getSource()){
            this.dispose();
            End_or_MainFrame last_page = new End_or_MainFrame(this.cm,this.fm,this.tm,this.username,this.phm,this.lm,
                    this.ticket_id);
        }
    }
}
