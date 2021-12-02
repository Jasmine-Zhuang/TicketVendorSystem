package GUI.Manager_Account.Update_personal_info;

import Flight.FlightManager;
import GUI.Manager_Account.ManageAccount;
import GUI.Manager_Account.Update_personal_info.Update_name.Update_nameFrame;
import GUI.Manager_Account.Update_personal_info.Update_password.Update_passwordFrame;
import GUI.Manager_Account.Update_personal_info.Update_username.Update_usernameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Customer.CustomerManager;
import Customer.PHManager;
import Luggage.LuggageManager;
import Ticket.TicketManager;


public class Update_PersonalinfoFrame extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("Update Personal Information");

    String instruction = "<html>To update your personal information, you need to click the button below:";
    JLabel label2 = new JLabel(instruction);
    JButton change_name = new JButton("Change Name");
    JButton change_password = new JButton("Change Password");
    JButton change_username = new JButton("Change username");
    JButton back = new JButton("Back to Manage Account Menu");
    Color darkRed = new Color(101,15,43);
    Color lightPink = new Color(218,198,205);
    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    PHManager phm;
    LuggageManager lm;
    String username;

    public Update_PersonalinfoFrame(CustomerManager customerManager, FlightManager flightManager,
                                    TicketManager ticketManager, String username, PHManager phm, LuggageManager lm) {
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.phm = phm;
        this.lm = lm;
        this.username=username;

        change_name.setFont(new Font("Times", Font.PLAIN,25));
        change_name.setForeground(darkRed);
        change_name.addActionListener(this);

        change_password.setFont(new Font("Times", Font.PLAIN,25));
        change_password.setForeground(darkRed);
        change_password.addActionListener(this);

        change_username.setFont(new Font("Times", Font.PLAIN,25));
        change_username.setForeground(darkRed);
        change_username.addActionListener(this);

        back.setFont(new Font("Times", Font.PLAIN,25));
        back.setForeground(darkRed);
        back.addActionListener(this);

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
        panel.add(Box.createRigidArea(new Dimension(20,20)));
        panel.add(change_name);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(change_password);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(change_username);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(back);
        panel.setBackground(lightPink);
        panel.add(Box.createHorizontalGlue());
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 500));
        this.setLocation(new Point(500, 300));
        this.pack();
        this.setVisible(true);
    }
    /*
        public static void main(String[] args) {
            new GUI.Manager_Account.Update_personal_info.Update_PersonalinfoFrame();
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(change_name == e.getSource()){
            this.dispose();
            Update_nameFrame change_name= new Update_nameFrame(this.cm, this.fm, this.tm, this.username, this.phm, this.lm);//instantiate next page for routes picking
        }else if(change_password == e.getSource()){
            this.dispose();
            Update_passwordFrame change_password = new Update_passwordFrame(this.cm, this.fm, this.tm, this.username,
                    this.phm);//instantiate main menu
        }else if(change_username == e.getSource()){
            this.dispose();
            Update_usernameFrame change_username= new Update_usernameFrame(this.cm, this.fm, this.tm, this.username,
                    this.phm);//instantiate next page for routes picking
        }else if(back == e.getSource()){
            this.dispose();
            ManageAccount ManageAccountMenu = new ManageAccount(this.cm, this.fm, this.tm, this.username, this.phm, this.lm);//instantiate main menu
        }
    }
}


