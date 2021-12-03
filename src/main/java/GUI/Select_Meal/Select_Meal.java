package GUI.Select_Meal;

import Customer.CMSerialization;
import Customer.CustomerManager;
import Customer.PHMSerialiazation;
import Customer.PHManager;
import Flight.FlightManager;
import GUI.Luggage_Meal_Main;
import GUI.Manager_Account.ManageAccount;
import GUI.Manager_Account.Membership.Joint_MembershipSuccess;
import GUI.Manager_Account.Purchase_History.PurchaseHistory_TicektFrame;
import Meal.*;
import Ticket.TicketManager;
import Luggage.LuggageManager;
import Ticket.TicketSerialization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Select_Meal extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("       Select Meal");

    String instruction = "<html> Please select the meal you want, you need to click the button below:";
    JLabel label2 = new JLabel(instruction);

    JButton button1 = new JButton("Diabetic");
    String Diabetic = "<html> Confirmed! You have select Diabetic meal to your ticket.";

    JButton button2 = new JButton("Gluten Intolerance");
    String Gluten = "<html> Confirmed! You have select Gluten Intolerance meal to your ticket.";

    JButton button3 = new JButton("Vegan");
    String Vegan = "<html> Confirmed! You have select Vegan meal to your ticket.";

    JButton button4 = new JButton("Low calories");
    String calories = "<html> Confirmed! You have select Low calories meal to your ticket.";

    JButton button5 = new JButton("Back to previous page");

    TicketSerialization ticketSerialization = new TicketSerialization();
    PHMSerialiazation phmSerialiazation = new PHMSerialiazation();
    CMSerialization cmSerialization = new CMSerialization();


    Color darkRed = new Color(101, 15, 43);
    Color lightPink = new Color(218, 198, 205);
    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    String username;
    PHManager phm;
    LuggageManager lm;
    String ticket_id;

    public Select_Meal(CustomerManager customerManager, FlightManager flightManager, TicketManager ticketManager,
                       String username, PHManager phm, LuggageManager lm, String ticket_id) {
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.username = username;
        this.phm = phm;
        this.lm = lm;
        this.ticket_id = ticket_id;

        button1.setFont(new Font("Times", Font.PLAIN, 25));
        button1.setForeground(darkRed);
        button1.addActionListener(this);

        button2.setFont(new Font("Times", Font.PLAIN, 25));
        button2.setForeground(darkRed);
        button2.addActionListener(this);

        button3.setFont(new Font("Times", Font.PLAIN, 25));
        button3.setForeground(darkRed);
        button3.addActionListener(this);

        button4.setFont(new Font("Times", Font.PLAIN, 25));
        button4.setForeground(darkRed);
        button4.addActionListener(this);

        button5.setFont(new Font("Times", Font.PLAIN, 25));
        button5.setForeground(darkRed);
        button5.addActionListener(this);

        label1.setBackground(lightPink);
        label1.setFont(new Font("Times", Font.BOLD, 30));
        label1.setForeground(darkRed);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setOpaque(true);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(50, 50, 100, 100);

        label2.setBackground(lightPink);
        label2.setForeground(darkRed);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.CENTER);
        label2.setOpaque(true);
        label2.setFont(new Font("Times", Font.ITALIC, 20));
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBounds(50, 50, 300, 300);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(20, 10)));
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(20, 20)));
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(20, 10)));
        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(20, 20)));
        panel.add(button3);
        panel.add(Box.createRigidArea(new Dimension(20, 10)));
        panel.add(button4);
        panel.add(Box.createRigidArea(new Dimension(20, 10)));
        panel.add(button5);
        panel.setBackground(lightPink);
        panel.add(Box.createHorizontalGlue());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(350, 320));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);
    }

//    public void main(String[] args) {
//        new Select_Meal(cm,fm,tm, username,phm,lm);
//    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (button1 == e.getSource()) {
            this.dispose();
            label2.setText(Diabetic);
            diabetic diabetic = new diabetic();
            this.tm.setMeal(this.tm.getTicketByID(ticket_id), diabetic);
            ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM

            int result = JOptionPane.showConfirmDialog(
                    this, Diabetic);
            if (result == JOptionPane.YES_OPTION) {
                ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM
                phmSerialiazation.savePHM(this.phm, "PHManager.ser");//save PHM
                cmSerialization.saveCM(this.cm, "CMManager.ser");//save cm
                JOptionPane.showMessageDialog(null, "Do you want to back to previous page?");
                this.dispose();
                select_meal_main purchaseHistory_ticektFrame = new select_meal_main(cm, fm, tm,
                        username, phm, lm, ticket_id);

            } else if (button2 == e.getSource()) {
                this.dispose();
                label2.setText(Gluten);
                gluten_intolerance Gluten = new gluten_intolerance();
                this.tm.setMeal(this.tm.getTicketByID(ticket_id), Gluten);
                ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM

                int result1 = JOptionPane.showConfirmDialog(
                        this, Gluten);
                if (result1 == JOptionPane.YES_OPTION) {
                    ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM
                    phmSerialiazation.savePHM(this.phm, "PHManager.ser");//save PHM
                    cmSerialization.saveCM(this.cm, "CMManager.ser");//save cm
                    JOptionPane.showMessageDialog(null, "Do you want to back to previous page?");
                    this.dispose();
                    select_meal_main purchaseHistory_ticektFrame = new select_meal_main(cm, fm, tm,
                            username, phm, lm, ticket_id);

                }
            } else if (button3 == e.getSource()) {
                this.dispose();
                label2.setText(Vegan);
                vegan Vegan = new vegan();
                this.tm.setMeal(this.tm.getTicketByID(ticket_id), Vegan);
                ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM

                int result2 = JOptionPane.showConfirmDialog(
                        this, Vegan);
                if (result2 == JOptionPane.YES_OPTION) {
                    ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM
                    phmSerialiazation.savePHM(this.phm, "PHManager.ser");//save PHM
                    cmSerialization.saveCM(this.cm, "CMManager.ser");//save cm
                    JOptionPane.showMessageDialog(null, "Do you want to back to previous page?");
                    this.dispose();
                    select_meal_main purchaseHistory_ticektFrame = new select_meal_main(cm, fm, tm,
                            username, phm, lm, ticket_id);

                }
            } else if (button4 == e.getSource()) {
                this.dispose();
                label2.setText(calories);
                low_calories low_calories = new low_calories();
                this.tm.setMeal(this.tm.getTicketByID(ticket_id), low_calories);
                ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM

                int result4 = JOptionPane.showConfirmDialog(
                        this, calories);
                if (result4 == JOptionPane.YES_OPTION) {
                    ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM
                    phmSerialiazation.savePHM(this.phm, "PHManager.ser");//save PHM
                    cmSerialization.saveCM(this.cm, "CMManager.ser");//save cm
                    JOptionPane.showMessageDialog(null, "Do you want to back to previous page?");
                    this.dispose();
                    select_meal_main purchaseHistory_ticektFrame = new select_meal_main(cm, fm, tm,
                            username, phm, lm, ticket_id);
                }
            } else if (button5 == e.getSource()) {
                this.dispose();
                ticketSerialization.saveTM(this.tm, "TicketManager.ser");//save TM
                select_meal_main select_meal_main = new select_meal_main(this.cm, this.fm, this.tm, this.username, this.phm,
                        this.lm, this.ticket_id);
                //instantiate main menu
            }
        }
    }
}

