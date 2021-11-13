package GUI;

import Flight.FlightManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PickFlightFrame extends JFrame implements ActionListener {
    JButton submitButton;
    FlightManager fm;
    String flightNumPicked;
    String dCity;
    String aCity;

    PickFlightFrame(String dCity,String aCity,FlightManager fm){
        this.fm = fm;
        this.dCity = dCity;
        this.aCity = aCity;

        submitButton = new JButton("Submit flight picked.");
        submitButton.setSize(100,100);
        submitButton.addActionListener(this);

        //flightNumsComoBox setup
        ArrayList<String> matchedFlights = fm.getFlightByRoute(dCity,aCity);//array list of flight nums
        String[] matchedFlightNums = new String[matchedFlights.size()];
        for(int i = 0; i < matchedFlights.size(); i++) {
            matchedFlightNums[i] = matchedFlights.get(i);
        }
        JComboBox<String> flightNumsComoBox = new JComboBox<>(matchedFlightNums);
        flightNumsComoBox.setBounds(50, 50, 100, 20);


        //flight info display setup
        flightNumPicked= flightNumsComoBox.getItemAt(flightNumsComoBox.getSelectedIndex());
        ArrayList<String> flightArraylist = new ArrayList<>();
        flightArraylist.add(flightNumPicked);
        JLabel flightInfoLabel = new JLabel();
        flightInfoLabel.setText(fm.displayFlightInfo(flightArraylist));

        JPanel panel = new JPanel();
        panel.add(flightNumsComoBox);
        panel.add(flightInfoLabel);
        panel.add(submitButton);

        //frame setup
       this.add(panel);
        this.setTitle("Pick your flight");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(550, 550));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);

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
            PickSeatFrame pickSeatFrame = new PickSeatFrame(this.fm,flightNumPicked);
        }

    }

}
