package GUI;

import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Ticket.TicketManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickRoutesFrame extends JFrame implements ActionListener {
    JFrame f = new JFrame("Pick your routes");
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel labelDepartureDis = new JLabel("Please select departure city");
    JLabel labelArrivalDis = new JLabel("Please select destination city");
    String[] dCities = {"Vancouver", "Toronto", "Montreal", "Ottawa"};
    String[] aCities = {"Vancouver", "Toronto", "Montreal", "Ottawa"};
    JButton button1 = new JButton("SHOW");
    JButton confirmButton = new JButton("Confirm");
    JComboBox<String> dCb = new JComboBox<>(dCities);
    JComboBox<String> aCb = new JComboBox<>(aCities);
    FlightManager fm;
    TicketManager tm;
    CustomerManager cm;
    String username;
    PHManager phm;

    PickRoutesFrame(FlightManager fm, CustomerManager cm, TicketManager tm, String username, PHManager phm) {
        this.fm = fm;
        this.tm=tm;
        this.cm=cm;
        this.username=username;
        this.phm=phm;

        dCb.setBounds(50, 50, 100, 20);
        f.add(dCb);
        f.setLayout(null);
        f.setSize(400, 500);
        f.setVisible(true);

        aCb.setBounds(50, 100, 100, 20);
        f.add(aCb);
        f.setLayout(null);
        f.setSize(400, 500);
        f.setVisible(true);

        label2.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);

        label1.setBounds(100, 200, 200, 20);
        label2.setBounds(100, 250, 200, 20);

        labelDepartureDis.setBounds(100, 10, 200, 20);
        labelArrivalDis.setBounds(100, 70, 200, 20);

        button1.setBounds(200, 300, 100, 30);
        button1.addActionListener(this);
        confirmButton.setBounds(200, 350, 100, 30);
        confirmButton.addActionListener(this);

        f.add(label2);
        f.add(label1);
        f.add(button1);
        f.add(labelArrivalDis);
        f.add(labelDepartureDis);
        f.add(confirmButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            //switch to select a flight from flights given based on routes
           this.dispose();
           PickFlightFrame pickFlightFrame= new PickFlightFrame(dCb.getItemAt(dCb.getSelectedIndex()),
                   dCb.getItemAt(aCb.getSelectedIndex()),this.fm,this.cm,this.tm,this.username,this.phm);

        } else if (e.getSource() == button1) {
            String data1 = "Departure selected "
                    + dCb.getItemAt(dCb.getSelectedIndex());
            label1.setText(data1);
            String data2 = "Destination selected "
                    + dCb.getItemAt(aCb.getSelectedIndex());
            label2.setText(data2);
        }
    }
}
