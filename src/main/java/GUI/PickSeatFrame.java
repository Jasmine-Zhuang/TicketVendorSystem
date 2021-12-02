package GUI;

import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Luggage.LuggageManager;
import Ticket.TicketManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PickSeatFrame extends JFrame implements ActionListener {
    JButton submitButton = new JButton();
    JTextField inputSeatNum;
    JTextField inputSeatClass;
    FlightManager fm;
    TicketManager tm;
    CustomerManager cm;
    String flightNum;
    String seatNumber;
    String seatClass;
    String username;
    PHManager phm;
    LuggageManager lm;


    PickSeatFrame(FlightManager fm,CustomerManager cm, TicketManager tm, String flightNum, String username,
                  PHManager phm, LuggageManager lm){
        this.fm=fm;
        this.flightNum =flightNum;
        this.username=username;
        this.cm=cm;
        this.tm=tm;
        this.phm=phm;
        this.lm = lm;

        JPanel panel = new JPanel();
        submitButton.setText("Submit seat picked");
        submitButton.setBounds(200, 300, 100, 30);
        submitButton.addActionListener(this);

        ArrayList<ArrayList<String>> availableSeatArrayList = fm.printAvailableSeat(flightNum);
        JLabel seatDisplayLabel = new JLabel(availableSeatArrayList.toString());
        String[] availableSeatArray = new String[availableSeatArrayList.size()];
        for(int i = 0; i < availableSeatArrayList.size(); i++) {
            availableSeatArray[i] = String.valueOf(availableSeatArrayList.get(i));
        }
        JComboBox<String> SeatsComoBox = new JComboBox<>(availableSeatArray);
        SeatsComoBox.setBounds(50, 50, 100, 20);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(Box.createHorizontalGlue());
        panel.add(seatDisplayLabel);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(SeatsComoBox);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(submitButton);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(inputSeatClass);
        panel.add(inputSeatClass);


        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 500));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);
        this.seatNumber = inputSeatNum.getText();
        this.seatClass=inputSeatClass.getText();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButton){
            this.dispose();
            DisplayPriceFrame displayPriceFrame = new DisplayPriceFrame(this.cm,this.fm,this.tm,this.seatNumber,
                    this.username,this.phm, this.lm);
            //flight num, customer usertype, seat type
            displayPriceFrame.getInfo(flightNum,this.seatClass);
        }

    }

}
