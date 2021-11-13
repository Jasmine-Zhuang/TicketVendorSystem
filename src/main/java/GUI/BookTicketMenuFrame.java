package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookTicketMenuFrame extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("BOOK TICKET MENU");
    String instruction = "<html>To book you desired ticket, you will need to:" +
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

    BookTicketMenuFrame() {
        button1.setFont(new Font("Times", Font.PLAIN,25));
        button1.setForeground(darkRed);
        button2.setFont(new Font("Times", Font.PLAIN,25));
        button2.setForeground(darkRed);

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
        this.setPreferredSize(new Dimension(350, 350));
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BookTicketMenuFrame();
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
            new Window1();//instantiate next page for routes picking
        }else if(button2 == e.getSource()){
            this.dispose();
            new MainMenuFrame();//instantiate main menu
        }
    }
}


