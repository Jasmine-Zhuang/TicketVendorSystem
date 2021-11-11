import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Frame2Demo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        //flow layout allows components to flows to next rows if it runs out of room
        frame.setLayout(new FlowLayout(FlowLayout.LEADING, 5,5));
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");

        for(Component b: new ArrayList<>(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8))){
            frame.add(b);
        }

        frame.setVisible(true);

    }

}
