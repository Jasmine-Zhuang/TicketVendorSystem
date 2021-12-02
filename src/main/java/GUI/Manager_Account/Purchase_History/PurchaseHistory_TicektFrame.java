package GUI.Manager_Account.Purchase_History;

import Customer.PHManager;
import Flight.FlightManager;
import GUI.BookTicketMenuFrame;
import GUI.Manager_Account.ManageAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Customer.CustomerManager;
import Ticket.TicketManager;
import Ticket.Ticket;


public class PurchaseHistory_TicektFrame extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("Booked Ticket History");

    String instruction = "<html>Your booked ticket history are shown below:";
    JLabel label2 = new JLabel(instruction);
    JButton button2 = new JButton("Back to Manage Account Menu");

    JButton back_pre = new JButton("Back to Purchase History Menu");
    JButton cancelButton = new JButton("Cancel Ticket");
    JButton changeButton = new JButton("Change Ticket");
    JTextField ticketID = new JTextField("Please input the ticket id of ticket that you want to change or cancel.");

    Color darkRed = new Color(101,15,43);
    Color lightPink = new Color(218,198,205);
    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    String username;
    PHManager phm;

    PurchaseHistory_TicektFrame(CustomerManager customerManager, FlightManager flightManager,
                                TicketManager ticketManager, String username,PHManager phm) {
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.username=username;
        this.phm=phm;
        cancelButton.addActionListener(this);
        changeButton.addActionListener(this);
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


        ArrayList<Ticket> Ticket_historylist = this.phm.getTickets(this.cm.showCustomer(this.username));
        if (Ticket_historylist != null) {
            String[] Ticket_Array = new String[Ticket_historylist.size()];
            for (int i = 0; i < Ticket_historylist.size(); i++) {
                String one_ticket = "<html> Passenger Name: " + Ticket_historylist.get(i).getPassenger_name() +
                        "<br/> Flight Number: " + Ticket_historylist.get(i).getFlightNumber() +
                        "<br/> From: " + Ticket_historylist.get(i).getDeparture_city()+
                        "<br/> To: " + Ticket_historylist.get(i).getArrival_city() +
                        "<br/> Seat Number: " + Ticket_historylist.get(i).getSeat_number() +
                        "<br/> Ticket ID: " + Ticket_historylist.get(i).getTicket_id() +
                        "<html>";
                Ticket_Array[i] = one_ticket;
            }
            JComboBox<String> Ticket_Box = new JComboBox<>(Ticket_Array);
            Ticket_Box.setBounds(50, 50, 100, 20);

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(Box.createHorizontalGlue());
            /*
            panel.add(Ticket_Label);

             */
            panel.add(Box.createRigidArea(new Dimension(10, 10)));
            panel.add(Ticket_Box);
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        button2.setFont(new Font("Times", Font.PLAIN,25));
        button2.setForeground(darkRed);
        button2.addActionListener(this);

        back_pre.setFont(new Font("Times", Font.PLAIN,25));
        back_pre.setForeground(darkRed);
        back_pre.addActionListener(this);


        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(back_pre);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(button2);
        panel.setBackground(lightPink);
        panel.add(Box.createHorizontalGlue());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(ticketID);
        panel.add(cancelButton);
        panel.add(changeButton);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(350, 320));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);
    }
    /*
        public static void main(String[] args) {
            new PurchaseHistory_TicektFrame(cm,fm,tm);
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button2 == e.getSource()){
            this.dispose();
            ManageAccount ManageAccountMenu = new ManageAccount(this.cm, this.fm, this.tm, this.username,this.phm);//instantiate main menu
        }
        else if (cancelButton == e.getSource()){
            String ticketId = ticketID.getText();
            if (ticketId != null){
                int result = JOptionPane.showConfirmDialog(
                    this,"Do you confirm to cancel this ticket?");
                if (result == JOptionPane.YES_OPTION) {
                    //tm.cancelTickets(tm.getTicketByID(ticketId),this.lm,this.pm,this.cm,this.fm,this.pc);
                    JOptionPane.showMessageDialog(null, "You have successfully canceled ticket"
                        + ticketId);
                    this.dispose();
                    PurchaseHistory_TicektFrame purchaseHistory_ticektFrame = new PurchaseHistory_TicektFrame(this.cm,
                            this.fm,this.tm,this.username,this.phm);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Warning: No ticket ID entered.","warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource() == changeButton){
            String ticketId = ticketID.getText();
            int result = JOptionPane.showConfirmDialog(
                    this,"Sure? You want to change this ticket?");
            if (ticketId != null){
                if (result == JOptionPane.YES_OPTION) {
                    //tm.cancelTickets(tm.getTicketByID(ticketId),this.lm,this.pm,this.cm,this.fm,this.pc);
                    JOptionPane.showMessageDialog(null,"You have successfully change ticket"
                                    + ticketId,"confirmation",
                            JOptionPane.PLAIN_MESSAGE);
                    BookTicketMenuFrame bookTicketMenuFrame=new BookTicketMenuFrame(this.fm,this.cm,
                            this.tm,this.username,this.phm);
                    this.dispose();

                }

            }
            else{
                JOptionPane.showMessageDialog(null,"Warning: No ticket ID entered.","warning",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(back_pre == e.getSource()){
            this.dispose();
            PurchaseHistoryFrame purchase_history = new PurchaseHistoryFrame(this.cm, this.fm, this.tm, this.username,this.phm);//instantiate main menu
        }

    }
}


