package GUI;

import Customer.CMSerialization;
import Customer.CustomerManager;
import Customer.PHMSerialiazation;
import Customer.PHManager;
import Flight.FlightManager;
import Flight.FlightSerialization;
import Luggage.LuggageManager;
import Luggage.LuggageSerialization;
import Ticket.TicketManager;
import Ticket.TicketSerialization;

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
    String u_name;
    String t_id;
    FlightSerialization flightSerialization = new FlightSerialization();
    TicketSerialization ticketSerialization = new TicketSerialization();
    PHMSerialiazation phmSerialiazation = new PHMSerialiazation();
    CMSerialization cmSerialization = new CMSerialization();
    LuggageSerialization luggageSerialization = new LuggageSerialization();

    LuggageFrame(FlightManager fm, CustomerManager cm, TicketManager tm,PHManager phm, LuggageManager lm,
                 String username, String tck_id){
        this.fm = fm;
        this.tm = tm;
        this.cm = cm;
        this.phm = phm;
        this.lm = lm;
        this.u_name = username;
        this.t_id = tck_id;

        label.setText("Please input ur Luggage weight(0kg~30kg)");
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
        if (e.getSource() == backBT) {
            this.dispose();
            MainMenuFrame mainMenu = new MainMenuFrame(this.fm, this.cm, this.tm, cm.showCustomer(u_name).getName(), this.phm);

        }
        if (e.getSource() == continueBT) {
            try {
                int wt = Integer.parseInt(l_weight.getText());
                if (wt > 0 && wt <= 30) {
                    lm.generateLuggage(wt, tm.getTicketByID(t_id).getFlightNumber(),
                            tm.getTicketByID(t_id).getSeat_number());
                     String luggageId = tm.getTicketByID(t_id).getFlightNumber() +
                        tm.getTicketByID(t_id).getSeat_number();
                    tm.getTicketByID(t_id).setLuggage(luggageId);
                    ticketSerialization.saveTM(this.tm,"TicketManager.ser");//save TM
                    luggageSerialization.saveLM(this.lm, "LuggageManager.ser");
                    this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Warning: insufficient input.", "warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Warning: insufficient input.", "warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        FlightManager fm = new FlightManager();
        TicketManager tm = new TicketManager();
        CustomerManager cm = new CustomerManager();
        PHManager phm = new PHManager();
        LuggageManager lm = new LuggageManager();
        String u_name = "sb";
        String t_id = "CZ01101A";
        LuggageFrame gui = new LuggageFrame(fm, cm, tm, phm, lm, u_name, t_id);
    }

}
