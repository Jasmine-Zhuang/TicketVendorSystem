import javax.swing.*;

public class JOptionPaneDemo {
    public static void main(String[] args) {
        /*JOptionPane.showMessageDialog(null,"Warning: something goes wrong.","title",
                JOptionPane.WARNING_MESSAGE);*/
        //last parameter can switch to Question,Error, Plain,Information message, which will display different icon


        /*
        int answer = JOptionPane.showConfirmDialog(null,"Do you have lunch?","My title",
                JOptionPane.YES_NO_CANCEL_OPTION);//Yes:0, No:1, Cancel:2, Exit:-1
        String name = JOptionPane.showInputDialog("What is your name?");
        System.out.println(answer);
        System.out.println(name);*/


        ImageIcon image = new ImageIcon("src/main/java/flight_ticket.png");
        String[] responses = {"Let's start!","Exit"};
        JOptionPane.showOptionDialog(null,"Ready to start?","title1",JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,image,responses,0);



    }
}
