package GUI;

import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Luggage.LuggageManager;
import Luggage.LuggageSerialization;
import Ticket.PriceCalculator;
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
    PriceCalculator pc;
    TicketSerialization ticketSerialization = new TicketSerialization();
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
        this.pc = new PriceCalculator();
        label.setFont(new Font("Times", Font.BOLD,15));
        label.setText("<html> Please input your luggage weight (Max: 30kg) " +
                "<br/> 1.5% of ticket price per kg penalty will be applied for luggage over 23 kg.<html>");
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(0,0,400,60);

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
            Luggage_Meal_Main lmm = new Luggage_Meal_Main(this.cm, this.fm, this.tm,
                    this.u_name, this.phm, this.lm, this.t_id);

        }
        if (e.getSource() == continueBT) {
            try {
                int wt = Integer.parseInt(l_weight.getText());
                if (wt > 0 && wt <= 30) {
                    if (wt > 23) {
                        //Check if overweight luggage should be added.
                        int penalty = pc.luggagePenalty(wt, tm.getTicketByID(t_id));
                        int result = JOptionPane.showConfirmDialog(
                                this,"Your luggage is overweight, penalty will be applied: $" + penalty);
                        if (result == JOptionPane.YES_OPTION) {
                            if(cm.showCustomer(u_name).getBalance() >= penalty){
                                cm.showCustomer(u_name).decrBalance(penalty);
                                lm.generateLuggage(wt, tm.getTicketByID(t_id).getFlightNumber(),
                                        tm.getTicketByID(t_id).getSeat_number());
                                String luggageId = tm.getTicketByID(t_id).getFlightNumber() +
                                        tm.getTicketByID(t_id).getSeat_number();
                                tm.getTicketByID(t_id).setLuggage_id(luggageId);

                                ticketSerialization.saveTM(this.tm,"TicketManager.ser");//save TM
                                luggageSerialization.saveLM(this.lm, "LuggageManager.ser");
                                this.dispose();
                                JOptionPane.showMessageDialog(null,
                                        "Successfully added your Luggage", "Congratulations",
                                        JOptionPane.INFORMATION_MESSAGE);
                                Luggage_Meal_Main lmm = new Luggage_Meal_Main(this.cm, this.fm, this.tm,
                                        this.u_name, this.phm, this.lm, this.t_id);
                            }else{
                                int result1 = JOptionPane.showConfirmDialog(
                                        this,"Insufficient balance, do you want to " +
                                                "load the outstanding fees?");
                                if (result1 == JOptionPane.YES_OPTION) {
                                    this.cm.showCustomer(this.u_name).incrBalance(penalty -
                                            this.cm.showCustomer(this.u_name).getBalance());
                                    cm.showCustomer(u_name).decrBalance(penalty);

                                    lm.generateLuggage(wt, tm.getTicketByID(t_id).getFlightNumber(),
                                            tm.getTicketByID(t_id).getSeat_number());
                                    String luggageId = tm.getTicketByID(t_id).getFlightNumber() +
                                            tm.getTicketByID(t_id).getSeat_number();
                                    tm.getTicketByID(t_id).setLuggage_id(luggageId);

                                    ticketSerialization.saveTM(this.tm,"TicketManager.ser");//save TM
                                    luggageSerialization.saveLM(this.lm, "LuggageManager.ser");
                                    this.dispose();
                                    JOptionPane.showMessageDialog(null,
                                            "Successfully added your Luggage", "Congratulations",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    Luggage_Meal_Main lmm = new Luggage_Meal_Main(this.cm, this.fm, this.tm,
                                            this.u_name, this.phm, this.lm, this.t_id);
                                }else{
                                    this.dispose();
                                    LuggageFrame select_luggage= new LuggageFrame(this.fm, this.cm, this.tm, this.phm,
                                            this.lm, this.u_name,this.t_id);
                                }

                            }
                        }else{
                            this.dispose();
                            LuggageFrame select_luggage= new LuggageFrame(this.fm, this.cm, this.tm, this.phm,
                                    this.lm, this.u_name,this.t_id);
                        }

                    }else{
                        lm.generateLuggage(wt, tm.getTicketByID(t_id).getFlightNumber(),
                                tm.getTicketByID(t_id).getSeat_number());
                        String luggageId = tm.getTicketByID(t_id).getFlightNumber() +
                                tm.getTicketByID(t_id).getSeat_number();
                        tm.getTicketByID(t_id).setLuggage_id(luggageId);

                        ticketSerialization.saveTM(this.tm,"TicketManager.ser");//save TM
                        luggageSerialization.saveLM(this.lm, "LuggageManager.ser");
                        this.dispose();
                        JOptionPane.showMessageDialog(null,
                                "Successfully added your Luggage", "Congratulations",
                                JOptionPane.INFORMATION_MESSAGE);
                        Luggage_Meal_Main lmm = new Luggage_Meal_Main(this.cm, this.fm, this.tm,
                                this.u_name, this.phm, this.lm, this.t_id);
                    }

                }else{
                    JOptionPane.showMessageDialog(null,
                            "Warning: You have reached the maximum luggage weight. Please re-enter", "warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception){
                JOptionPane.showMessageDialog(null,
                        "Warning: Invalid input.", "warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }



}
