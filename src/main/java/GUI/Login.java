package GUI;

import Customer.CustomerManager;
import Customer.LoginSystem;
import Customer.PHManager;
import Flight.FlightManager;
import Luggage.LuggageManager;
import Ticket.TicketManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JFrame implements ActionListener {

    JLabel label = new JLabel();
    JLabel Username = new JLabel();
    JLabel Password = new JLabel();
    JButton loginBT = new JButton();
    JButton createBT = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    FlightManager fm;
    TicketManager tm ;
    CustomerManager cm;
    PHManager phm;
    LuggageManager lm;

    Login(FlightManager fm, CustomerManager cm, TicketManager tm, PHManager phm, LuggageManager lm){
        this.fm=fm;
        this.cm=cm;
        this.tm=tm;
        this.phm=phm;
        this.lm = lm;

        label.setText("Please login, or create an account if you don't have one.");
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(0,0,400,20);
        label.setFont(new Font("Times", Font.BOLD, 13));

        Username.setText("Username");
        Username.setFont(new Font("Times", Font.PLAIN, 17));
        Username.setBounds(10,100,100,20);

        Password.setText("Password");
        Password.setFont(new Font("Times", Font.PLAIN, 17));
        Password.setBounds(10, 130, 100, 20);


        loginBT.setText("Login");
        loginBT.setBounds(50,250,100,50);
        loginBT.setFont(new Font("Times", Font.PLAIN, 17));
        loginBT.addActionListener(this);
        loginBT.setFocusable(false);


        createBT.setText("Create");
        createBT.setBounds(250,250,100,50);
        createBT.setFont(new Font("Times", Font.PLAIN, 17));
        createBT.addActionListener(this);
        createBT.setFocusable(false);

        username.addActionListener(this);
        username.setBounds(100,100,200,30);
        username.setPreferredSize(new Dimension(200, 30));
        username.setFont(new Font("Times", Font.PLAIN, 17));

        password.addActionListener(this);
        password.setBounds(100,130,200,30);
        password.setPreferredSize(new Dimension(200, 30));
        password.setFont(new Font("Times", Font.PLAIN, 17));

        this.setTitle("Login");
        this.setVisible(true);
        this.setLayout(null);
        this.setFocusable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLocation(new Point( 500,200));
        this.add(label);
        this.add(Username);
        this.add(Password);
        this.add(loginBT);
        this.add(createBT);
        this.add(username);
        this.add(password);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBT){
            try {
                if (LoginSystem.checkUser(username.getText(), String.valueOf(password.getPassword()))){
                    System.out.println("Login success!");
                    this.dispose();
                    MainMenuFrame mainMenuFrame = new MainMenuFrame(this.fm, this.cm, this.tm,
                            username.getText(),this.phm, this.lm);
                } else{
                    System.out.println("The password is wrong or the user does not exist.");
                }
            } catch (IOException ex) {
                System.out.println("error");
            }


        }
        if (e.getSource() == createBT){
            this.dispose();
            CreateAccount ca = new CreateAccount(this.fm, this.cm, this.tm, this.phm, this.lm);

        }
    }

}


