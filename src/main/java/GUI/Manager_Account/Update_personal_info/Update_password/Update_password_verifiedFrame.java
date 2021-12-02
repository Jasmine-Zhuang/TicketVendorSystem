package GUI.Manager_Account.Update_personal_info.Update_password;


import Customer.CMSerialization;
import Customer.LoginSystem;
import Flight.FlightManager;
import GUI.Manager_Account.ManageAccount;
import GUI.Manager_Account.Update_personal_info.Update_PersonalinfoFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Customer.CustomerManager;
import Ticket.TicketManager;
import Customer.PHManager;


public class Update_password_verifiedFrame extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("Update account password");

    String instruction = "<html>Verified! Your password is in system, please enter your new password below:";
    JLabel label2 = new JLabel(instruction);
    JButton button1 = new JButton("Back to Personal Information Menu");
    JButton button2 = new JButton("Back to Manage Account Menu");
    Color darkRed = new Color(101,15,43);
    Color lightPink = new Color(218,198,205);

    // create a new frame to store text field and button
    JFrame textfield = new JFrame("textfield");

    // create a new button
    JButton submitb = new JButton("submit");

    // create an object of JTextField with 16 columns and a given initial text
    JTextField initialText = new JTextField("Please enter your new password", 16);

    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    PHManager phm;
    String username;
    String password;


    // default constructor
    Update_password_verifiedFrame(CustomerManager customerManager, FlightManager flightManager,
                                  TicketManager ticketManager, String username, String pswd, PHManager phm) {
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.username=username;
        this.password = pswd;
        this.phm = phm;

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

        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(initialText);
        panel.add(submitb);
        submitb.addActionListener(this);
        textfield.setSize(new Dimension(2,2));
        textfield.add(panel);


        panel.add(Box.createRigidArea(new Dimension(20,20)));
        panel.add(button1);

        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(button2);

        panel.setBackground(lightPink);
        panel.add(Box.createHorizontalGlue());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // set the size of frame
        textfield.setSize(20, 20);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 320));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);
    }
    /*
        public static void main(String[] args) {
            // create a object of the text class
            new Update_password_verifiedFrame(cm,fm,tm);
        }
    
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(submitb == e.getSource()){
            String newPassword = initialText.getText();
            if(LoginSystem.changePassword(this.username, this.password, newPassword)){
                this.dispose();
                this.cm.changePassword(this.password, newPassword, this.cm.showCustomer(this.username));
                CMSerialization cmSerialization = new CMSerialization();
                cmSerialization.saveCM(this.cm, "CMManager.ser");
                Update_passwordsuccessFrame change_password= new Update_passwordsuccessFrame(this.cm, this.fm, this.tm, this.username, this.phm);//instantiate next page for routes picking
            }
        }
        if(button1 == e.getSource()){
            this.dispose();
            Update_PersonalinfoFrame personal_info = new Update_PersonalinfoFrame(this.cm, this.fm, this.tm,
                    this.username, this.phm);//instantiate main menu
        }
        if(button2 == e.getSource()){
            this.dispose();
            ManageAccount ManageAccountMenu = new ManageAccount(this.cm, this.fm, this.tm, this.username, this.phm);//instantiate main menu
        }
    }
}

