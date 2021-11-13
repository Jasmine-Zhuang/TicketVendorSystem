package GUI;

import Flight.FlightManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PickSeatFrame extends JFrame implements ActionListener {
    JButton submitButton = new JButton();
    PickSeatFrame(FlightManager fm, String flightNum){
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

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 500));
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
            Window1 w1=new Window1();//display price


        }

    }

}
