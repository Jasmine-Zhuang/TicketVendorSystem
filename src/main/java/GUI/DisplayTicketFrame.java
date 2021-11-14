package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Customer.PHManager;
import Customer.PHMSerialiazation;
import Customer.CMSerialization;
import Customer.CustomerManager;
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
    String username;
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
                       LocalDateTime a_time, String b_gate, String seat_num, String username,
                       String classType, int ticketPrice, PHManager phm){
        this.cm = cm;
        this.fm = fm;
        this.tm = tm;
        this.phm=phm;
        this.username = username;
        this.flightNum = flightNum;
        this.ticketPrice = ticketPrice;
        this.classType = classType;
        this.d_city = d_city;
        this.a_city = a_city;
        this.d_time = d_time;
        this.a_time = a_time;
        this.boardingGate = b_gate;
        this.seatNum = seat_num;

        Ticket t = tm.generateTicket(flightNum, d_city, a_city, fm.getFlightByNum(flightNum).getDepartureTime(),
                fm.getFlightByNum(flightNum).getArrivalTime(), b_gate, seat_num,
                ticketPrice, cm.showCustomer(username).getName(), username, classType);
        tm.bookTickets(t);
        this.cm.decrBalance(ticketPrice,cm.showCustomer(this.username));
        this.cm.incrMillage(this.tm.getMileage(t,this.fm),cm.showCustomer(username));
        this.cm.calculateRedeemPoint(cm.showCustomer(username));
        fm.reserveSeat(flightNum, seat_num);
        cm.showCustomer(this.username).getPurchaseHistory().addPurchasedTickets(t);
        this.phm.updateHistory(cm.showCustomer(this.username).getPurchaseHistory());// update purchase history

        flightSerialization.saveFM(this.fm,"FlightManager.ser"); // save FM
        ticketSerialization.saveTM(this.tm,"TicketManager.ser");//save TM
        phmSerialiazation.savePHM(this.phm,"PHManager.ser");//save PHM
        cmSerialization.saveCM(this.cm, "CMManager.ser");

        //        String msg = t.toString();
        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("yyyy MMM dd  HH:mm:ss");
        String formattedArrivalTime = fm.getFlightByNum(flightNum).getArrivalTime().format(FormatObj);
        String formattedDepartureTime = fm.getFlightByNum(flightNum).getDepartureTime().format(FormatObj);
        String msg = "<html> --------Air Ticket--------" +
                "<br/> Name of Passenger: " + cm.showCustomer(username).getName() +
                "<br/> Flight: " + flightNum +
                "  Seat: " + seat_num + "  Class Type: " + classType +
                "<br/> From " + d_city + " to " + a_city +
                "<br/> Departure time: " + formattedDepartureTime +
                "<br/> Estimate arrival time: " + formattedArrivalTime +
                "<br/> Boarding Gate: " + b_gate +
                "<br/> Price: $" + ticketPrice +
                "<br/> Boarding time will be one hour before departure." +
                "<br/> And gate closes 20 minutes before departure." +
                "<br/> Have a nice trip!" +
                "-----------------------<html>";
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
        MainMenuFrame mainMenu = new MainMenuFrame(this.fm,this.cm,this.tm, username,this.phm);
    }

}
