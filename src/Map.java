import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map {
    int xCoordinate;
    int yCoordinate;
    PartType partType;
    JButton[][] grid;
    String part = "and";
    JFrame frame = new JFrame();
    ArrayList<LED> LEDList = new ArrayList<LED>();
    ArrayList<Button> buttonList = new ArrayList<Button>();
    Map(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        grid = new JButton[xCoordinate][yCoordinate];
        frame.setLayout(new GridLayout(yCoordinate, xCoordinate, 0, 0)); //행, 열 , 좌우 간격, 상하 간격
    }

    void createGrid () {
        for (int yPos = yCoordinate; yPos >= 1; yPos--) {
            for (int xPos = 1; xPos <= xCoordinate; xPos++) {
                grid[xPos -1][yPos -1] = new JButton("[" + xPos + "," + yPos + "]");
            }
        }
    }

    void createMap() {
        for (int yPos = yCoordinate; yPos >= 1; yPos--) {
            for (int xPos = 1; xPos <= xCoordinate; xPos++) {
                frame.add(grid[xPos -1][yPos -1]);
            }
        }
    }
    void visualizationParts(int[] position, PartType part) {
        int xPos = position[0];
        int yPos = position[1];
        grid[xPos-1][yPos-1] = new JButton("#=#" + part.getName() + "#=#");
    }
}
