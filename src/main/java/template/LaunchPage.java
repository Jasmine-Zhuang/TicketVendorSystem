package template;

import GUI.Window1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This page only has a button; by clicking it, it will launch a next page
public class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("New Window");

    LaunchPage(){
        button.setBounds(100,160,200,40);
        button.setFocusable(false);
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button);

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button == e.getSource()){
            frame.dispose();
           /* Window1 w1 = new Window1();*/
        }

    }
}
