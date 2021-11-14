package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Customer.PHManager;
import Customer.Customer;
import Customer.CustomerManager;
import Flight.FlightManager;
import Ticket.TicketManager;

public class BookTicketFrame extends JFrame implements ActionListener {
    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    String flightNum;
    String customer_user;
    String classType;
    int ticketPrice;
    String seatNum;
    Customer customer;
    PHManager phm;


    JButton buttonBook = new JButton("Confirm");
    JButton buttonBack = new JButton("Back");
    JLabel label = new JLabel("Confirm Information");
    JLabel label2 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    BookTicketFrame(FlightManager fm, CustomerManager cm, TicketManager tm,
                    String flightNum, String c, String classType, int ticketPrice, String seatNum, PHManager phm) {
        this.cm = cm;
        this.fm = fm;
        this.tm = tm;
        this.phm=phm;
        this.flightNum = flightNum;
        this.customer_user = c;
        this.ticketPrice = ticketPrice;
        this.classType = classType;
        this.seatNum = seatNum;
        this.customer = cm.showCustomer(c);
        String msg = "<html> Passenger Name: " + customer.getName() +
                "<br/> Flight Number: " + flightNum +
                "<br/> From: " + fm.getFlightByNum(flightNum).getOriginCity() +
                "<br/> To: " + fm.getFlightByNum(flightNum).getDestinationCity() +
                "<br/> Class: " + classType +
                "<br/> Ticket Price: $" + ticketPrice +
                "<br/> Balance after consumption: $" + (customer.getBalance() - ticketPrice) +
                "<br/> Please confirm your Ticket  information." +
                "<html>";
        label2.setText(msg);
        label.setFont(new Font("Times", Font.BOLD, 40));
        label.setForeground(Color.white);
        label2.setFont(new Font("Times", Font.PLAIN, 20));


        buttonBook.addActionListener(this);
        buttonBack.addActionListener(this);

        panel1.setBounds(250, 250, 250, 200);
        panel1.setBackground(Color.white);
        panel1.add(label2);

        panel2.setBackground(new Color(0, 76, 153));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel2.add(label);

        panel3.setBackground(Color.white);
        panel3.setPreferredSize(new Dimension(100, 50));
        panel3.add(buttonBook);
        panel3.add(buttonBack);

        this.setTitle("U-Ticket Booking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
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
            DisplayPriceFrame dpf = new DisplayPriceFrame(cm, fm, tm, seatNum, customer.getUsername(),this.phm);
        } else {
            this.dispose();
            DisplayTicketFrame dtf = new DisplayTicketFrame(fm, cm, tm, flightNum,
                    fm.getFlightByNum(flightNum).getOriginCity(), fm.getFlightByNum(flightNum).getDestinationCity(),
                    fm.getFlightByNum(flightNum).getDepartureTime(), fm.getFlightByNum(flightNum).getArrivalTime(),
                    fm.getFlightByNum(flightNum).getBoardingGate(), seatNum, customer, classType, ticketPrice,this.phm);
        }

    }

}