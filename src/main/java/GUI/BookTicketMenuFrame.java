package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookTicketMenuFrame extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel label = new JLabel("BOOK TICKET MENU");
    JButton button1 = new JButton("Pick routes");
    JButton button2 = new JButton("Help");
    Color darkRed = new Color(101,15,43);
    Color lightPink = new Color(218,198,205);

    BookTicketMenuFrame() {
        button1.setFont(new Font("Times", Font.PLAIN,25));
        button1.setForeground(darkRed);
        button2.setFont(new Font("Times", Font.PLAIN,25));
        button2.setForeground(darkRed);

        label.setBackground(lightPink);
        label.setFont(new Font("Times", Font.BOLD,40));
        label.setForeground(darkRed);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(50,50,100,100);

        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
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
            Window1 w1 = new Window1();//instantiate next page for routes picking
        }else if(button2 == e.getSource()){
            this.dispose();
            Window1 w1 = new Window1();//instantiate ...
        }
    }
}


