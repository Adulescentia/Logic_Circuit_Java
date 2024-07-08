import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        int xCoordinate = 10;
        int yCoordinate = 8;
        Console console = new Console(xCoordinate, yCoordinate);
        while (console.enabled) {
            console.run();
        }
        Map map = console.map;
        JFrame frame = map.frame;


        //basic settings
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Logic_Circuit");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
