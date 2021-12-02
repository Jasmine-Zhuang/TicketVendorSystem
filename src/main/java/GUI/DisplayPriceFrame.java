package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Customer.CustomerManager;
import Flight.FlightManager;
import GUI.Manager_Account.Load_Balance.Load_BalanceFrame;
import Luggage.LuggageManager;
import Ticket.TicketManager;
import Ticket.PriceCalculator;
import Customer.PHManager;

public class DisplayPriceFrame extends JFrame implements ActionListener {

    PriceCalculator pc = new PriceCalculator();
    CustomerManager cm;
    FlightManager fm;
//    Customer c = new Customer("abcdedf", "sdcsjdhc36273", "Olivia");
    TicketManager tm;
    PHManager phm;
    String flightNum;
    String seat;
    String username;
//    String ticketID;
    String classType;
    int ticketPrice;
    int penalty = 0;

    JButton buttonPrev = new JButton("Back to Book Ticket");
    JButton buttonLoad = new JButton("Load balance");
    JButton buttonNext = new JButton("Next");

    JLabel label = new JLabel("Price Summary");
    JLabel label2 = new JLabel();

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    DisplayPriceFrame(CustomerManager customerManager, FlightManager flightManager, TicketManager ticketManager,
                      String seatNum, String username, PHManager phm, LuggageManager) {

        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.phm = phm;
        this.seat = seatNum;
        this.username = username;

        // set up label: Price Summary
        // label2: Air transportation charges: Ticket.PriceCalculator.calculatePrice(Flight f, Customer c, String
        // ClassType)

        label.setFont(new Font("Times", Font.BOLD,40));
        label.setForeground(Color.white);

        label2.setFont(new Font("Times", Font.PLAIN,20));

        buttonPrev.addActionListener(this);
        buttonLoad.addActionListener(this);
        buttonNext.addActionListener(this);


        // set up the panel
        panel1.setBounds(250, 250, 250, 200);
        panel1.setBackground(Color.white);
        panel1.add(label2);

        panel2.setBackground(new Color(0, 76, 153));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel2.add(label);

        panel3.setBackground(Color.white);
        panel3.setPreferredSize(new Dimension(100, 50));
        panel3.add(buttonPrev);
        panel3.add(buttonLoad);
        panel3.add(buttonNext);


        // set up the frame
        this.setTitle("U-Ticket Booking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocation(500, 300);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(panel1);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.SOUTH);

    }

    /**
     * A method to receive inputs from the previous frame, so that it could calculate the ticket price and the penalty
     * charges.
     * @param flightNum A list of Flight, Customer, and String instances that have info[0] = the Flight instance,
     *             info[1] = Customer instance, info[2] = classType.
     */
    public void getInfo(String flightNum, String classType) {
//        flight = (Flight) info.get(0);
        this.flightNum=flightNum;

        ticketPrice = pc.calculatePrice(fm.getFlightByNum(flightNum), cm.showCustomer(this.username), classType);
        int total = ticketPrice + penalty;
        String msg = "<html> Air transportation charges: $" + ticketPrice +
//                "<br/> Late return/change charges: $" + penalty +
                "<br/> Grand Total: $" + total +
                "<html>";
        label2.setText(msg);
    }

//    public static void main(String[] args) {
//        new DisplayPriceFrame();
//
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonPrev == e.getSource()) {
            BookTicketMenuFrame bookTicketMenuFrame = new BookTicketMenuFrame(fm, cm, tm,this.username,this.phm);
            bookTicketMenuFrame.setVisible(true);
            this.dispose();
/*            PickSeatFrame psf = new PickSeatFrame();*/
        }
        else if (buttonLoad == e.getSource()) {
            // create a new instance of eg. LoadBalanceFrame
            Load_BalanceFrame lbf = new Load_BalanceFrame(this.cm, this.fm, this.tm, this.username, this.phm);
            this.dispose();
        }else if (buttonNext == e.getSource()){
        // create a new instance of BookTicketFrame
        // a method in BookTicketFrame to receive all info needed to call generateTicket
        // like btf.getInfo(Flight, Customer, classType, price)
        this.dispose();
        BookTicketFrame btf = new BookTicketFrame(fm, cm, tm, flightNum, this.username, classType, ticketPrice,
                seat, this.phm);
        btf.setVisible(true);
        }
    }
}

