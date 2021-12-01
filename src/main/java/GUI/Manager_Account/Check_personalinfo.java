package GUI.Manager_Account;

import Customer.Customer;
import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import GUI.DisplayPriceFrame;
import GUI.DisplayTicketFrame;
import Ticket.TicketManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check_personalinfo extends JFrame implements ActionListener {
    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    PHManager phm;
    String username;


//    JButton buttonBook = new JButton("Confirm");
    JButton buttonBack = new JButton("Back to Manage Account Menu");
    JLabel label = new JLabel("Check Personal Information");
    JLabel label2 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    Check_personalinfo(CustomerManager customerManager, FlightManager flightManager,
                    TicketManager ticketManager, String username, PHManager phm) {
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.phm=phm;
        this.username = username;
        /*
        this.cm.showCustomer(this.username).calculateRedeemPoint();

         */
        String msg = "<html> Passenger Name: " + this.cm.showCustomer(this.username).getName() +
                "<br/> Passenger username: " + this.cm.showCustomer(this.username).getUsername() +
                "<br/> Account Balance: " + this.cm.showCustomerBalance(this.username) +
                "<br/> Current mileage: " + this.cm.showCustomer(this.username).getMileage() +
                "<br/> Membership status: " + this.cm.showCustomer(this.username).checkMembership() +
                "<br/> Membership level: " + this.cm.showCustomer(this.username).checkMembershiplevel() +
                "<br/> Redeem points: " + this.cm.showCustomer(this.username).getRedeem_points()  +
                "<html>";

        label2.setText(msg);
        label.setFont(new Font("Times", Font.BOLD, 40));
        label.setForeground(Color.white);
        label2.setFont(new Font("Times", Font.PLAIN, 20));


//        buttonBook.addActionListener(this);
        buttonBack.addActionListener(this);

        panel1.setBounds(250, 250, 250, 200);
        panel1.setBackground(Color.white);
        panel1.add(label2);

        panel2.setBackground(new Color(0, 76, 153));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel2.add(label);

        panel3.setBackground(Color.white);
        panel3.setPreferredSize(new Dimension(100, 50));
//        panel3.add(buttonBook);
        panel3.add(buttonBack);

        this.setTitle("U-Ticket Booking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setLocation(new Point(500, 200));
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(panel1);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBack) {
            this.dispose();
            ManageAccount ManageAccountMenu = new ManageAccount(this.cm, this.fm, this.tm, this.username, this.phm);//instantiate main menu
        }
    }

}