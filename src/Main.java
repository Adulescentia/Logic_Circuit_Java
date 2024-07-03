import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.util.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        Map map = new Map();
        JFrame frame = map.createMap(10,8);
        frame.setFont(new Font("System", Font.BOLD, 0));

        //basic settings
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Logic_Circuit");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
