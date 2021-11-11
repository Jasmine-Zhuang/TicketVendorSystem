package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TexFieldFrame extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    TexFieldFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);

        button = new JButton("Submit");
        button.addActionListener(this);
        this.add(button);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150,40));
        textField.setFont(new Font("Consolas",Font.PLAIN,30));
        textField.setForeground(Color.WHITE);//input string's color
        textField.setBackground(Color.BLACK);//text field's background color
        textField.setCaretColor(Color.WHITE);// outside this text field's color
       /* textField.setEditable(false);//can change editable to false if you don't want user to edit*/
        textField.setText("Username");//initial value in the text field, can change when user type in new things
        this.add(textField);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            String tx = textField.getText();
            System.out.println("Hi!"+tx);

        }

    }
}
