import javax.swing.*;
import java.awt.*;

public class Map {
    int xCoordinate;
    int yCoordinate;
    PartType partType;
    JButton[][] grid;
    JFrame frame = new JFrame();
    Map(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        grid = new JButton[xCoordinate][yCoordinate];
        frame.setLayout(new GridLayout(yCoordinate, xCoordinate, 0, 0)); //행, 열 , 좌우 간격, 상하 간격
    }

    void createGrid () {
        for (int yPos = yCoordinate; yPos >= 1; yPos--) {
            for (int xPos = 1; xPos <= xCoordinate; xPos++) {
                grid[xPos -1][yPos -1] = new JButton(xPos + "," + yPos);
            }
        }
    }

    JFrame createMap() {
        for (int yPos = yCoordinate; yPos >= 1; yPos--) {
            for (int xPos = 1; xPos <= xCoordinate; xPos++) {
                frame.add(grid[xPos -1][yPos -1]);
            }
        }
        return frame;
    }
    void mapping() {} //Todo
    void visualizationParts(int xPos, int yPos, String part) {
        partType = Commands.definePartType(part);
        grid[xPos-1][yPos-1] = new JButton(Commands.definePartType(part).getImage());
    }
}
