package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Customer.Customer;
import Flight.Flight;
import Ticket.PriceCalculator;

public class DisplayPriceFrame extends JFrame implements ActionListener {

    PriceCalculator pc = new PriceCalculator();
    Flight flight;
    Customer customer;
    String classType;

    /**
     * A method to receive inputs from the previous frame.
     * @param info A list of Flight, Customer, and String instances that have info[0] = the Flight instance,
     *             info[1] = Customer instance, info[2] = classType.
     */
    public void getInfo(ArrayList<Object> info) {
        flight = (Flight) info.get(0);
        customer = (Customer) info.get(1);
        classType = (String) info.get(2);
    }

    int price = pc.CalculatePrice(flight, customer, classType);


    JButton buttonPrev = new JButton("Prev");
    JButton buttonLoad = new JButton("Load balance");
    JButton buttonNext = new JButton("Next");

    JLabel label = new JLabel("Price Summary");
    JLabel label2 = new JLabel("Air transportation charges: $" + price);

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    DisplayPriceFrame() {

        // set up label: Price Summary
        // label2: Air transportation charges: Ticket.PriceCalculator.calculatePrice(Flight f, Customer c, String
        // ClassType)

        label.setFont(new Font("Times", Font.BOLD,40));
        label.setForeground(Color.white);

        label2.setFont(new Font("Times", Font.PLAIN,20));

        buttonPrev.addActionListener(this);
        buttonLoad.addActionListener(this);
        buttonNext.addActionListener(this);


        // set up the panel
        panel1.setBounds(250, 250, 250, 200);
        panel1.setBackground(Color.white);
        panel1.add(label2);

        panel2.setBackground(new Color(0, 76, 153));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel2.add(label);

        panel3.setBackground(Color.white);
        panel3.setPreferredSize(new Dimension(100, 50));
        panel3.add(buttonPrev);
        panel3.add(buttonLoad);
        panel3.add(buttonNext);


        // set up the frame
        this.setTitle("U-Ticket Booking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(panel1);
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new DisplayPriceFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonPrev == e.getSource()) {
            this.dispose();
            // create a new instance of eg. PickSeatFrame
            Frame1 fm1 = new Frame1();
        }
        else if (buttonLoad == e.getSource()) {
            // create a new instance of eg. LoadBalanceFrame
            this.dispose();
        }
        boolean booked = true;
        // create a new instance of BookTicketFrame
        // a method in BookTicketFrame to receive "booked"
        // set BookTicketFrame visible
        this.dispose();
    }
}
