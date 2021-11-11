package GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {
    JButton button;
    Frame1(){
        button = new JButton();
        button.setBounds(200,100,100,50);
        button.setText("Click this button");
        /*button.addActionListener(this);*/ //will call the actionPerformed method
        button.addActionListener(e -> System.out.println("Clicked"));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);

    }

    /* Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("Clicked.");
        }

    }
}



