import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();


        //griding   //28*20
        frame.setLayout(new GridLayout(20, 28, 0, 0)); //행, 열 , 좌우 간격, 상하 간격
        for (int ypos = 20; ypos >= 1; ypos--) {
            for (int xpos = 1; xpos <= 28; xpos++) {
                frame.add(new JButton(xpos + "," + ypos));
            }
        }

        //basic settings
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Logic_Circuit");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}