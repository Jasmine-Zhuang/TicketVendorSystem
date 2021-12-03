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

public class PickSeatFrame extends JFrame{
    JButton submitButton = new JButton();
    FlightManager fm;
    TicketManager tm;
    CustomerManager cm;
    String flightNum;
    String username;
    PHManager phm;
    LuggageManager lm;
    String seatNumber;


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
       /* submitButton.addActionListener(this);*/



        ArrayList<ArrayList<String>> availableSeatArrayList = fm.printAvailableSeat(flightNum);
        JLabel seatDisplayLabel = new JLabel(availableSeatArrayList.toString());
        String[] availableSeatArray = new String[availableSeatArrayList.size()];
        for(int i = 0; i < availableSeatArrayList.size(); i++) {
            availableSeatArray[i] = String.valueOf(availableSeatArrayList.get(i));
        }
        JComboBox<String> SeatsComboBox = new JComboBox<>(availableSeatArray);
        SeatsComboBox.setBounds(50, 50, 100, 20);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(Box.createHorizontalGlue());
        panel.add(seatDisplayLabel);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(SeatsComboBox);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(submitButton);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);




        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 500));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);
        submitButton.addActionListener(e -> {
            String SeatAndClass = SeatsComboBox.getItemAt(SeatsComboBox.getSelectedIndex());
            PickSeatFrame.this.seatNumber = SeatAndClass.substring(1,SeatAndClass.indexOf(","));
            String Class = SeatAndClass.substring(SeatAndClass.indexOf(",")+2, SeatAndClass.indexOf("]"));
            PickSeatFrame.this.dispose();
            DisplayPriceFrame displayPriceFrame =
                    new DisplayPriceFrame(PickSeatFrame.this.cm,PickSeatFrame.this.fm,
                            PickSeatFrame.this.tm,PickSeatFrame.this.seatNumber,PickSeatFrame.this.username,
                            PickSeatFrame.this.phm, PickSeatFrame.this.lm);
            displayPriceFrame.getInfo(PickSeatFrame.this.flightNum,Class);
        });



    }

//    /**
//     * Invoked when an action occurs.
//     *
//     * @param e the event to be processed
//     */
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==submitButton){
//
//            this.dispose();
//            DisplayPriceFrame displayPriceFrame = new DisplayPriceFrame(this.cm,this.fm,this.tm,seatNumber,
//                    this.username,this.phm, this.lm);
//            //flight num, customer usertype, seat type
//            displayPriceFrame.getInfo(this.flightNum,"First");
//        }
//
//    }

}
