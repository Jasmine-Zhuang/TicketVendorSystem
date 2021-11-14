package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import Customer.PHManager;
import Customer.PHMSerialiazation;
import Customer.Customer;
import Customer.CMSerialization;
import Customer.CustomerManager;
import Flight.Flight;
import Flight.FlightManager;
import Flight.FlightSerialization;
import Ticket.Ticket;
import Ticket.TicketManager;
import Ticket.TicketSerialization;

public class DisplayTicketFrame extends JFrame implements ActionListener{
    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    PHManager phm;
    String flightNum;
    Customer customer;
    String classType;
    int ticketPrice;
    String d_city;
    String a_city;
    LocalDateTime d_time;
    LocalDateTime a_time;
    String boardingGate;
    String seatNum;
    JButton buttonFinish = new JButton("Finish");
    JLabel label = new JLabel("Ticket Booked!!");
    JLabel label2 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    FlightSerialization flightSerialization = new FlightSerialization();
    TicketSerialization ticketSerialization = new TicketSerialization();
    PHMSerialiazation phmSerialiazation = new PHMSerialiazation();
    CMSerialization cmSerialization = new CMSerialization();

    DisplayTicketFrame(FlightManager fm, CustomerManager cm, TicketManager tm,
                       String flightNum, String d_city, String a_city, LocalDateTime d_time,
                       LocalDateTime a_time, String b_gate, String seat_num,
                       Customer c, String classType, int ticketPrice, PHManager phm){
        this.cm = cm;
        this.fm = fm;
        this.tm = tm;
        this.phm=phm;
        this.flightNum = flightNum;
        this.customer = c;
        this.ticketPrice = ticketPrice;
        this.classType = classType;
        this.d_city = d_city;
        this.a_city = a_city;
        this.d_time = d_time;
        this.a_time = a_time;
        this.boardingGate = b_gate;
        this.seatNum = seat_num;
        Flight f = fm.getFlightByNum(flightNum);
        Ticket t = tm.generateTicket(flightNum, d_city, a_city, f.getDepartureTime(),
                f.getArrivalTime(), b_gate, seat_num, ticketPrice, c.getName(), c.getUsername(), classType);
        tm.bookTickets(t);
        this.cm.decrBalance(ticketPrice,cm.showCustomer(c.getUsername()));
        this.cm.incrMillage(this.tm.getMileage(t,this.fm),cm.showCustomer(c.getUsername()));
        this.cm.calculateRedeemPoint(cm.showCustomer(c.getUsername()));
        fm.reserveSeat(t.getFlightNumber(), t.getSeat_number());
        c.getPurchaseHistory().addPurchasedTickets(t);
        this.phm.updateHistory(c.getPurchaseHistory());// update purchase history

        flightSerialization.saveFM(this.fm,"FlightManager.ser"); // save FM
        ticketSerialization.saveTM(this.tm,"TicketManager.ser");//save TM
        phmSerialiazation.savePHM(this.phm,"PHManager.ser");//save PHM
        cmSerialization.saveCM(this.cm, "CMManager.ser");

        String msg = t.toString();
        label2.setText(msg);

        label.setFont(new Font("Times", Font.BOLD,40));
        label.setForeground(Color.white);
        label2.setFont(new Font("Times", Font.PLAIN,20));

        buttonFinish.addActionListener(this);

        panel1.setBounds(250, 250, 250, 200);
        panel1.setBackground(Color.white);
        panel1.add(label2);

        panel2.setBackground(new Color(0, 76, 153));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel2.add(label);

        panel3.setBackground(Color.white);
        panel3.setPreferredSize(new Dimension(100, 50));
        panel3.add(buttonFinish);

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
        this.dispose();
        MainMenuFrame mainMenu = new MainMenuFrame(this.fm,this.cm,this.tm, customer.getUsername(),this.phm);
    }

}
