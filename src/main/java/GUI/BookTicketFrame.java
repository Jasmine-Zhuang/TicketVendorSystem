package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Customer.PHManager;
import Customer.CustomerManager;
import Flight.FlightManager;
import GUI.Manager_Account.Load_Balance.Insufficient_Balance;
import Luggage.LuggageManager;
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
    PHManager phm;
    LuggageManager lm;


    JButton buttonBook = new JButton("Confirm");
    JButton buttonBack = new JButton("Back");
    JLabel label = new JLabel("Confirm Information");
    JLabel label2 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    BookTicketFrame(FlightManager fm, CustomerManager cm, TicketManager tm,String flightNum, String c, String classType,
                    int ticketPrice, String seatNum, PHManager phm, LuggageManager lm) {
        this.cm = cm;
        this.fm = fm;
        this.tm = tm;
        this.phm = phm;
        this.lm = lm;
        this.flightNum = flightNum;
        this.customer_user = c;
        this.ticketPrice = ticketPrice;
        this.classType = classType;//seat type
        this.seatNum = seatNum;
//        this.customer = cm.showCustomer(c);
        String msg = "<html> Passenger Name: " + cm.showCustomer(customer_user).getName() +
                "<br/><br/> Flight Number: " + flightNum +
                "<br/> <br/>From: " + this.fm.getFlightByNum(flightNum).getOriginCity() +
                "<br/><br/> To: " + this.fm.getFlightByNum(flightNum).getDestinationCity() +
                "<br/><br/> Class: " + classType +
                "<br/> <br/>Ticket Price: $" + ticketPrice +
                "<br/> <br/>Balance after consumption: $" + (cm.showCustomer(customer_user).getBalance() - ticketPrice) +
                "<br/> <br/>Please confirm your Ticket  information." +
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
        this.setSize(500, 500);
        this.setLocation(new Point(500, 300));
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
            DisplayPriceFrame dpf = new DisplayPriceFrame(this.cm, this.fm, this.tm,
                    this.seatNum, this.customer_user,this.phm,this.lm);
        }
        else {
            if (cm.showCustomerBalance(this.customer_user) >= this.ticketPrice) {
                DisplayTicketFrame dtf = new DisplayTicketFrame(this.fm, this.cm, this.tm, this.flightNum,
                        this.fm.getFlightByNum(this.flightNum).getOriginCity(),
                        this.fm.getFlightByNum(this.flightNum).getDestinationCity(),
                        this.fm.getFlightByNum(this.flightNum).getDepartureTime(),
                        this.fm.getFlightByNum(this.flightNum).getArrivalTime(),
                        this.fm.getFlightByNum(this.flightNum).getBoardingGate(), this.seatNum,
                        this.customer_user, this.classType, this.ticketPrice,
                        this.phm, this.lm);
            }else{JOptionPane.showMessageDialog(null,"Warning: insufficient balance.","warning",
                    JOptionPane.WARNING_MESSAGE);

                Insufficient_Balance insufficient_balance = new Insufficient_Balance(this.cm,this.fm,this.tm,
                        customer_user,this.phm,this.lm);
            }
            this.dispose();
            /*MainMenuFrame mainMenuFrame = new MainMenuFrame(fm,cm,tm,this.customer_user,phm);*/

        }

    }

}