package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GreetingFrame1 extends JFrame implements ActionListener {
    //logo img resize
    int NEW_WIDTH = 250;
    int NEW_HEIGHT = 250;
    //button img resize
    int NEW_WIDTH1 = 50;
    int NEW_HEIGHT1 = 50;

    Font titleFont = new Font("Times", Font.PLAIN,50);
    Font font = new Font("Times", Font.PLAIN,20);
    Color LightBlue = new Color(148, 187,232);
    JLabel logoLabel = new JLabel();
    JLabel greetingLabel = new JLabel("Welcome to UTicket!");
    JButton button = new JButton();


    GreetingFrame1() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        button.setBounds(100,160,200,40);
        button.setFocusable(false);
        button.addActionListener(this);
       /* button.setBorder(BorderFactory.createEtchedBorder());*/
       /* button.setBackground(Color.lightGray);*/
        ImageIcon icon = new ImageIcon("Images/start.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance( NEW_WIDTH1, NEW_HEIGHT1,  java.awt.Image.SCALE_SMOOTH ) ;
        icon = new ImageIcon(newImg);
        button.setIcon(icon);

        logoLabel.setBackground(Color.white);
        logoLabel.setOpaque(true);
        logoLabel.setVerticalAlignment(JLabel.CENTER);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        logoLabel.setBounds(50,50,100,100);
        ImageIcon icon1 = new ImageIcon("Images/img_1.png");
        Image img1 = icon1.getImage();
        Image newImg1 = img1.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH) ;
        icon1 = new ImageIcon(newImg1);
        logoLabel.setIcon(icon1);

        greetingLabel.setFont(titleFont);
        greetingLabel.setForeground(Color.white);
        greetingLabel.setVerticalAlignment(JLabel.CENTER);
        greetingLabel.setHorizontalAlignment(JLabel.CENTER);
        greetingLabel.setBounds(100, 100, greetingLabel.getPreferredSize().width,
                greetingLabel.getPreferredSize().height);
        greetingLabel.setHorizontalTextPosition(JLabel.CENTER);
        greetingLabel.setVerticalTextPosition(JLabel.CENTER);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
/*        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();*/
        panel1.setBackground(LightBlue);
        panel2.setBackground(Color.white);
/*        panel3.setBackground(Color.white);
        panel4.setBackground(Color.white);*/
        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(150,100));
/*        panel3.setPreferredSize(new Dimension(150,100));
        panel4.setPreferredSize(new Dimension(100,100));*/
        panel1.add(greetingLabel);
        panel2.add(logoLabel);
        panel2.add(button);

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);
/*        this.add(panel3,BorderLayout.EAST);
        this.add(panel4,BorderLayout.CENTER);*/
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button == e.getSource()){
            this.dispose();
            Window1 w1 = new Window1();//instantiate login frame
        }
    }

    public static void main(String[] args) {
        new GreetingFrame1();
    }
}