package GUI;
import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import GUI.Manager_Account.ManageAccount;
import Ticket.TicketManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame implements ActionListener {

        JPanel panel = new JPanel();
        JLabel label = new JLabel("MAIN MENU");
        JButton button1 = new JButton("MANAGE ACCOUNT");
        JButton button2 = new JButton("BOOK TICKET");
        Color darkRed = new Color(101,15,43);
        Color lightPink = new Color(218,198,205);
        FlightManager fm;
        TicketManager tm;
        CustomerManager cm;
        String username;
        PHManager phm;

        public MainMenuFrame(FlightManager fm, CustomerManager cm, TicketManager tm, String username,PHManager phm) {
            this.fm=fm;
            this.cm=cm;
            this.tm=tm;
            this.username = username;
            this.phm=phm;

            button1.setFont(new Font("Times", Font.PLAIN,25));
            button1.setForeground(darkRed);
            button1.addActionListener(this);
            button2.setFont(new Font("Times", Font.PLAIN,25));
            button2.setForeground(darkRed);
            button2.addActionListener(this);

            label.setBackground(lightPink);
            label.setFont(new Font("Times", Font.BOLD,40));
            label.setForeground(darkRed);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.CENTER);
            label.setOpaque(true);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setBounds(50,50,100,100);

            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            panel.add(Box.createHorizontalGlue());
            panel.add(Box.createRigidArea(new Dimension(10,10)));
            panel.add(label);
            panel.add(button1);
            panel.add(button2);
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.setBackground(lightPink);

            this.add(panel);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setSize(500, 500);
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
        if(button1 == e.getSource()){
            this.dispose();
            ManageAccount manageAccount = new ManageAccount(this.cm, this.fm,this.tm,this.username,this.phm);
        }else if(button2 == e.getSource()){
            this.dispose();
            BookTicketMenuFrame bookTicketMenu = new BookTicketMenuFrame(this.fm,this.cm,this.tm,this.username,this.phm);//instantiate bookTicket frame
        }
    }
}

