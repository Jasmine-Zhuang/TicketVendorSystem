package GUI;
import Customer.PHManager;
import Customer.Customer;
import Customer.CustomerManager;
import Customer.LoginSystem;
import Flight.FlightManager;
import Ticket.TicketManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateAccount extends JFrame implements ActionListener {

    JLabel label = new JLabel();
    JLabel Username = new JLabel();
    JLabel Password = new JLabel();
    JLabel FullName = new JLabel();
    JButton confirm = new JButton();
    JButton back = new JButton();
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField fullName = new JTextField();
    FlightManager fm ;
    CustomerManager cm ;
    TicketManager tm;
    PHManager phm;

    CreateAccount(FlightManager fm, CustomerManager cm, TicketManager tm, PHManager phm){

        this.fm = fm;
        this.cm = cm;
        this.tm = tm;
        this.phm=phm;

        label.setText("Please enter your Username, Password, and Full Name respectively");
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(0,0,450,20);

        confirm.setText("Confirm");
        confirm.setBounds(50,250,100,50);
        confirm.addActionListener(this);
        confirm.setFocusable(false);

        back.setText("Return");
        back.setBounds(250,250,100,50);
        back.addActionListener(this);
        back.setFocusable(false);

        Username.setText("Username");
        Username.setBounds(10,100,80,20);

        username.addActionListener(this);
        username.setBounds(100,100,200,20);

        Password.setText("Password");
        Password.setBounds(10,130,80,20);

        password.addActionListener(this);
        password.setBounds(100,130,200,20);

        FullName.setText("Full Name");
        FullName.setBounds(10,160,80,20);

        fullName.addActionListener(this);
        fullName.setBounds(100,160,200,20);

        this.setTitle("Create Account");
        this.setVisible(true);
        this.setLayout(null);
        this.setFocusable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450,400);
        this.setLocation(new Point( 500,200));
        this.add(label);
        this.add(confirm);
        this.add(back);
        this.add(Username);
        this.add(Password);
        this.add(FullName);
        this.add(username);
        this.add(password);
        this.add(fullName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm){
            try {
                if (LoginSystem.checkUsername(username.getText())) {
                    LoginSystem.addUser(username.getText(), password.getText(), fullName.getText(), "users.csv");
                    Customer c = new Customer(username.getText(), password.getText(), fullName.getText());
                    this.cm.addCustomer(c);
                    this.dispose();
                    Login login = new Login(this.fm, this.cm, this.tm,this.phm);
                } else {
                    System.out.println("The username already exists, please enter a new one.");
                }
            } catch (IOException ex) {
                System.out.println("error");;
            }
        }
        if (e.getSource() == back){
            this.dispose();
            Login login = new Login(this.fm, this.cm, this.tm,this.phm);
        }
    }


}


