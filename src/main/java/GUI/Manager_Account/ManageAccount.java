package GUI.Manager_Account;
import Flight.FlightManager;
import GUI.MainMenuFrame;
import GUI.Manager_Account.Load_Balance.Load_BalanceFrame;
import GUI.Manager_Account.Membership.Join_MembershipFrame;
import GUI.Manager_Account.Purchase_History.PurchaseHistoryFrame;
import GUI.Manager_Account.Redeem_Item.Redeem_ItemFrame;
import GUI.Manager_Account.Update_personal_info.Update_PersonalinfoFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Customer.CustomerManager;
import Luggage.LuggageManager;
import Ticket.TicketManager;
import Customer.PHManager;
import UStore.RewardsItem;
import UStore.RewardsItemFactory;


public class ManageAccount extends JFrame implements ActionListener {
    JButton check = new JButton();
    JButton update = new JButton();
    JButton membership = new JButton();
    JButton load = new JButton();
    JButton redeem = new JButton();
    JButton history = new JButton();
    JButton back = new JButton();

    CustomerManager cm;
    FlightManager fm;
    TicketManager tm;
    PHManager phm;
    LuggageManager lm;
    String username;
    RewardsItem rewardsItem;
    RewardsItemFactory rif;

    public ManageAccount(CustomerManager customerManager, FlightManager flightManager,
                         TicketManager ticketManager, String username, PHManager phm, LuggageManager lm){
        this.cm = customerManager;
        this.fm = flightManager;
        this.tm = ticketManager;
        this.phm = phm;
        this.lm = lm;
        this.username=username;
        this.rif = new RewardsItemFactory();

        check.setText("check personal info");
        check.setBounds(100,20,200,50);
        check.addActionListener(this);
        check.setFocusable(false);

        update.setText("update personal info");
        update.setBounds(100,80,200,50);
        update.addActionListener(this);
        update.setFocusable(false);

        membership.setText("Join membership");
        membership.setBounds(100,140,200,50);
        membership.addActionListener(this);
        membership.setFocusable(false);

        load.setText("load balance");
        load.setBounds(100,200,200,50);
        load.addActionListener(this);
        load.setFocusable(false);

        redeem.setText("redeem points");
        redeem.setBounds(100,260,200,50);
        redeem.addActionListener(this);
        redeem.setFocusable(false);

        history.setText("see your purchase history");
        history.setBounds(100,320,200,50);
        history.addActionListener(this);
        history.setFocusable(false);

        back.setText("Return to main menu");
        back.setBounds(100,380,200,50);
        back.addActionListener(this);
        back.setFocusable(false);
        
        this.setTitle("Manage Account");
        this.setVisible(true);
        this.setLayout(null);
        this.setFocusable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,500);
        this.setLocation(new Point( 500,200));

        this.add(check);
        this.add(update);
        this.add(membership);
        this.add(load);
        this.add(redeem);
        this.add(history);
        this.add(back);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            this.dispose();
            Check_personalinfo check_personal_info = new Check_personalinfo(this.cm, this.fm, this.tm, this.username, this.phm, this.lm);//instantiate main menu
        }

        if (e.getSource() == update){
            this.dispose();
            Update_PersonalinfoFrame personal_info = new Update_PersonalinfoFrame(this.cm, this.fm, this.tm,this.username, this.phm, this.lm);//instantiate main menu
        }
        if (e.getSource() == membership){
            this.dispose();
            Join_MembershipFrame membership = new Join_MembershipFrame(this.cm, this.fm, this.tm, this.username, this.phm, this.lm);//instantiate main menu
        }
        if (e.getSource() == load){
            this.dispose();
            Load_BalanceFrame load_balance = new Load_BalanceFrame(this.cm, this.fm, this.tm, this.username, this.phm, this.lm);//instantiate main menu
        }
        if (e.getSource() == redeem){
            this.dispose();
            Redeem_ItemFrame reedem_item = new Redeem_ItemFrame(this.cm, this.fm, this.tm, this.username, this.phm, this.rewardsItem, this.rif, this.lm);//instantiate main menu
        }
        if (e.getSource() == history){
            this.dispose();
            PurchaseHistoryFrame purchase_history = new PurchaseHistoryFrame(this.cm, this.fm, this.tm, this.username,
                    this.phm, this.lm);//instantiate main menu
        }
        if (e.getSource() == back){
            this.dispose();
            MainMenuFrame mainMenu = new MainMenuFrame(this.fm, this.cm, this.tm, this.username, this.phm, this.lm);
        }
    }
}
