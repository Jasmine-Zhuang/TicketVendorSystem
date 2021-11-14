package GUI;
import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Ticket.TicketManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookTicketMenuFrame extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("BOOK TICKET MENU");
    String instruction = "<html>To book your desired ticket, you will need to:" +
            "<br/>-> select your routes" +
            "<br/>-> pick your flight" +
            "<br/>-> pick seat class" +
            "<br/>-> pick your seat" +
            "<br/>-> submit booking<html>";
    JLabel label2 = new JLabel(instruction);
    JButton button1 = new JButton("Book flight ticket");
    JButton button2 = new JButton("Back to main menu");
    Color darkRed = new Color(101,15,43);
    Color lightPink = new Color(218,198,205);
    FlightManager fm;
    TicketManager tm;
    CustomerManager cm;
    String username;
    PHManager phm;

    BookTicketMenuFrame(FlightManager fm,CustomerManager cm, TicketManager tm, String username,PHManager phm) {
        this.fm =fm;
        this.tm=tm;
        this.cm=cm;
        this.phm=phm;
        this.username = username;
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
        panel.add(Box.createRigidArea(new Dimension(20,20)));
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(20,10)));
        panel.add(label2);
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

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button1 == e.getSource()){
            this.dispose();
            PickRoutesFrame pickRoutesFrame= new PickRoutesFrame(this.fm,this.cm,this.tm,this.username,this.phm);//instantiate next page for routes picking
        }else if(button2 == e.getSource()){
            this.dispose();
            MainMenuFrame mainMenu = new MainMenuFrame(this.fm,this.cm,this.tm, this.username,this.phm);//instantiate main menu
        }
    }
}


