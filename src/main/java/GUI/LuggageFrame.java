package GUI;

import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Ticket.TicketManager;
import Luggage.LuggageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LuggageFrame extends JFrame implements ActionListener {

    JLabel label = new JLabel("U-Ticket Booking System");
    JLabel weight = new JLabel();
    JButton backBT = new JButton("Back");
    JButton continueBT = new JButton("Confirm");

    JTextField l_weight = new JTextField();

    FlightManager fm;
    TicketManager tm ;
    CustomerManager cm;
    PHManager phm;
    LuggageManager lm;

    LuggageFrame(FlightManager fm, CustomerManager cm, TicketManager tm,PHManager phm, LuggageManager lm){
        this.fm = fm;
        this.tm = tm;
        this.cm = cm;
        this.phm = phm;
        this.lm = lm;

        label.setText("Please input ur Luggage weight(Max: 30kg)");
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(0,0,400,20);

        weight.setText("Weight: ");
        weight.setBounds(10,100,100,20);

        backBT.setText("Back");
        backBT.setBounds(250,250,100,50);
        backBT.addActionListener(this);
        backBT.setFocusable(false);


        continueBT.setText("Confirm");
        continueBT.setBounds(50,250,100,50);
        continueBT.addActionListener(this);
        continueBT.setFocusable(false);




        l_weight.addActionListener(this);
        l_weight.setBounds(100,100,200,20);


        this.setTitle("Luggage");
        this.setVisible(true);
        this.setLayout(null);
        this.setFocusable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLocation(new Point( 500,200));
        this.add(label);
        this.add(weight);

        this.add(continueBT);
        this.add(backBT);
        this.add(l_weight);



    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        FlightManager fm = new FlightManager();
        CustomerManager cm = new CustomerManager();
        TicketManager tm = new TicketManager();
        PHManager phm = new PHManager();
        LuggageManager lm = new LuggageManager();
        new LuggageFrame(fm,cm,tm,phm,lm);
    }
}
