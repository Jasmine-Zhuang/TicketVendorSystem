package GUI.Manager_Account.Load_Balance;
import Customer.CMSerialization;
import Customer.PHManager;
import Flight.FlightManager;
import GUI.Manager_Account.ManageAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Customer.CustomerManager;
import Ticket.TicketManager;

public class Load_BalanceFrame extends JFrame implements ActionListener {
    FlightManager fm;
    TicketManager tm;
    CustomerManager cm;
    PHManager phm;
    String username;

    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("Load Account Balance");

    String instruction = "<html>To load your account balance, please enter the amount you want to load:";
    JLabel label2 = new JLabel(instruction);
    JButton button1 = new JButton("Join Membership");
    JButton button2 = new JButton("Back to Manage Account Menu");
    Color darkRed = new Color(101,15,43);
    Color lightPink = new Color(218,198,205);

    // create a new frame to store text field and button
    JFrame textfield = new JFrame("textfield");

    // create a label to display text
    JLabel nothinglabel = new JLabel("nothing entered");

    // create a new button
    JButton submitb = new JButton("submit");

    // create a object of JTextField with 16 columns and a given initial text
    JTextField initalttext = new JTextField("enter the amount", 16);


    // default constructor
    public Load_BalanceFrame(CustomerManager customerManager, FlightManager flightManager, TicketManager ticketManager,
                             String username, PHManager phm) {
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.phm=phm;
        this.username=username;

        button1.setFont(new Font("Times", Font.PLAIN,25));
        button1.setForeground(darkRed);
        button1.addActionListener(this);

        button2.setFont(new Font("Times", Font.PLAIN,25));
        button2.setForeground(darkRed);
        button2.addActionListener(this);

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

        nothinglabel.setBounds(50,50,300,300);
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        textfield.add(initalttext);
        panel.add(initalttext);
        panel.add(submitb);
        submitb.addActionListener(this);
        panel.add(nothinglabel);
        textfield.setSize(new Dimension(2,2));
        textfield.add(panel);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(button2);

        panel.setBackground(lightPink);
        panel.add(Box.createHorizontalGlue());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // set the size of frame
        textfield.setSize(20, 20);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(350, 320));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);
    }
    /*
        public static void main(String[] args) {
            // create a object of the text class
            new Load_BalanceFrame(cm, fm,tm);
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(submitb == e.getSource()){
            this.dispose();
            String textFieldValue = initalttext.getText();

            int load_amount = Integer.parseInt(textFieldValue);
            this.cm.incrBalance(load_amount, this.cm.showCustomer(this.username));
            CMSerialization cmSerialization = new CMSerialization();
            cmSerialization.saveCM(this.cm, "CMManager.ser");
            Load_BalanceSuccess load_balance= new Load_BalanceSuccess(this.cm, this.fm, this.tm, this.username,this.phm);//instantiate next page for routes picking

        }else if(button2 == e.getSource()){
            this.dispose();
            ManageAccount ManageAccountMenu = new ManageAccount(this.cm, this.fm, this.tm,
                    this.username,this.phm);//instantiate main menu
        }
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            nothinglabel.setText(initalttext.getText());

            // set the text of field to blank
            nothinglabel.setText("  ");
        }
    }
}

