import javax.swing.*;
import java.awt.*;

public class Map {
    JFrame createMap(int xCoordinate, int yCoordinate) {
        JFrame frame = new JFrame();
        frame.setFont(new Font("System", Font.BOLD, 50));
        JButton[][] grid = new JButton[xCoordinate][yCoordinate];
        frame.setLayout(new GridLayout(yCoordinate, xCoordinate, 0, 0)); //행, 열 , 좌우 간격, 상하 간격
        for (int ypos = yCoordinate; ypos >= 1; ypos--) {
            for (int xpos = 1; xpos <= xCoordinate; xpos++) {
                grid[xpos-1][ypos-1] = new JButton(xpos + "," + ypos);
                grid[xpos-1][ypos-1].setFont(new Font("맑은고딕", Font.BOLD, 1));
                frame.add(new JButton(xpos + "," + ypos));
            }
        }
        return frame;
    }
}
