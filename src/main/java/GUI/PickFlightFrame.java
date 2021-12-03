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

public class PickFlightFrame extends JFrame implements ActionListener {
    JButton submitButton;
    JButton showButton;
    JButton backButton;

    FlightManager fm;
    TicketManager tm;
    CustomerManager cm;

    String dCity;
    String aCity;
    String username;
    PHManager phm;
    LuggageManager lm;

    JComboBox flightNumsComoBox;
    JLabel flightInfoLabel;

    PickFlightFrame(String dCity,String aCity,FlightManager fm,CustomerManager cm, TicketManager tm,String username,
                    PHManager phm, LuggageManager lm){
        this.fm=fm;
        this.cm=cm;
        this.tm=tm;
        this.dCity = dCity;
        this.aCity = aCity;
        this.username=username;
        this.phm=phm;
        this.lm = lm;



        submitButton = new JButton("Submit flight picked.");
        submitButton.setSize(100,100);
        submitButton.addActionListener(this);
        showButton = new JButton("Show information of flight picked.");
        showButton.addActionListener(this);
        submitButton.setSize(100,100);
        backButton =new JButton("Back to Route Selection Menu");
        backButton.addActionListener(this);
        backButton.setSize(100,100);

        //flightNumsComoBox setup
        ArrayList<String> matchedFlights = fm.getFlightByRoute(dCity,aCity);//array list of flight nums
        JLabel la= new JLabel(matchedFlights.toString());

        String[] matchedFlightNums = new String[matchedFlights.size()];
        for(int i = 0; i < matchedFlights.size(); i++) {
            matchedFlightNums[i] = matchedFlights.get(i);
        }
        flightNumsComoBox = new JComboBox(matchedFlightNums);
        flightNumsComoBox.setBounds(50, 50, 100, 20);
//        flightNumsComoBox.addActionListener(this);



        //flight info display setup
       /* flightNumPicked= flightNumsComoBox.getItemAt(flightNumsComoBox.getSelectedIndex());*/
        /*ArrayList<String> flightArraylist = new ArrayList<>();
        flightArraylist.add(flightNumPicked);*/
        flightInfoLabel = new JLabel();
        JPanel panel = new JPanel();
        panel.add(flightNumsComoBox);

        panel.add(flightInfoLabel);

        panel.add(submitButton);
        panel.add(showButton);
        panel.add(backButton);
        panel.add(la);

        //frame setup
        this.add(panel);
        this.setTitle("Pick your flight");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(350, 350));
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
      /*  if(e.getSource() == flightNumsComoBox){

        }*/
        if(e.getSource()==submitButton){
            this.dispose();
            String flightNumPicked= (String) flightNumsComoBox.getItemAt(flightNumsComoBox.getSelectedIndex());
            PickSeatFrame pickSeatFrame = new PickSeatFrame(this.fm,this.cm,this.tm,flightNumPicked,
                    this.username,this.phm, this.lm);
        }else if(e.getSource() == showButton){
            String flightNumPicked= (String) flightNumsComoBox.getItemAt(flightNumsComoBox.getSelectedIndex());
            flightInfoLabel.setText(fm.displayFlightInfoInGUI(flightNumPicked));
        }
        else if(e.getSource() == backButton){
            String flightNumPicked= (String) flightNumsComoBox.getItemAt(flightNumsComoBox.getSelectedIndex());
            flightInfoLabel.setText(fm.displayFlightInfoInGUI(flightNumPicked));
        }

    }

}
