package GUI.Manager_Account.Redeem_Item;


import Customer.PHManager;
import Flight.FlightManager;
import GUI.Manager_Account.ManageAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Customer.CustomerManager;
import Ticket.TicketManager;
import UStore.RewardsItem;
import UStore.RewardsItemFactory;

public class Redeem_ItemFrame extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("       Redeem Items");
    /*
    String instruction = "<html>To check your redeem items, you need to click the button below:";
    JLabel label2 = new JLabel(instruction);
     */
    JButton button1 = new JButton("Redeem Items");
    JButton button3 = new JButton("Redeem Items History");
    JButton button2 = new JButton("Back to Manage Account Menu");
    Color darkRed = new Color(101,15,43);
    Color lightPink = new Color(218,198,205);
    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    String username;
    PHManager phm;
    RewardsItem rewardsItem;
    RewardsItemFactory rif;

    public Redeem_ItemFrame(CustomerManager customerManager, FlightManager flightManager,
                            TicketManager ticketManager, String username, PHManager phm,
                            RewardsItem rewardsItem,RewardsItemFactory rif) {
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.username=username;
        this.phm=phm;
        this.rewardsItem = rewardsItem;
        this.rif = rif;

        button1.setFont(new Font("Times", Font.PLAIN,25));
        button1.setForeground(darkRed);
        button1.addActionListener(this);

        button2.setFont(new Font("Times", Font.PLAIN,25));
        button2.setForeground(darkRed);
        button2.addActionListener(this);

        button3.setFont(new Font("Times", Font.PLAIN,25));
        button3.setForeground(darkRed);
        button3.addActionListener(this);

        label1.setBackground(lightPink);
        label1.setFont(new Font("Times", Font.BOLD,30));
        label1.setForeground(darkRed);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setOpaque(true);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(50,50,100,100);

            /*
        label2.setBackground(lightPink);
        label2.setForeground(darkRed);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.CENTER);
        label2.setOpaque(true);
        label2.setFont(new Font("Times", Font.ITALIC,20));
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBounds(50,50,300,300);

             */

        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(label1);
        /*
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(label2);

         */
        panel.add(Box.createRigidArea(new Dimension(20,20)));
        panel.add(button1);

        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(button3);

        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(button2);
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
    /*
        public static void main(String[] args) {
            new Redeem_ItemFrame(cm,fm,tm);
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button1 == e.getSource()){
            this.dispose();
            Redeem_ItemListFrame reedem_item_list= new Redeem_ItemListFrame(this.cm, this.fm, this.tm, this.username,
                    this.phm, this.rewardsItem, this.rif);//instantiate next page for routes picking
        }else if(button2 == e.getSource()){
            this.dispose();
            ManageAccount ManageAccountMenu = new ManageAccount(this.cm, this.fm, this.tm, this.username,this.phm);//instantiate main menu
        }
        else if(button3 == e.getSource()){
            this.dispose();
            ReedemItem_ReedemItemFrame reedem_item_history = new ReedemItem_ReedemItemFrame(this.cm, this.fm, this.tm,
                    this.username,this.phm, this.rewardsItem, this.rif);//instantiate main menu
           }
    }
}
