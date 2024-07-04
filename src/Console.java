import java.util.*;

public class Console {

    //vars
    int xCoordinate; //창 넓이
    int yCoordinate; //창 넓이


    int[] position;

    //enums
    CommandType commandType;
    PartType partType;
    Direction[] direction;

    //temps
    String inputPosition;
    Parts dummy = new Parts(direction, 0, 0);

    //scanner
    Scanner scanner = new Scanner(System.in);
    String command = scanner.nextLine();
    String[] splittedCommand = command.split(" ");

    //생성자
    Console (int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    Parts[][] parts = new Parts[xCoordinate][yCoordinate];

    //methods
    void run () {
        switch (commandType.getValue()) {
            case 0:
                System.out.println("Unknown command");
                break;
            case 1: parts = Commands.createParts(Commands.definePartType(splittedCommand[1]), Commands.defineDirections(splittedCommand[2]), Commands.definePosition(splittedCommand[3])); //temp
                    break;
            case 2: Commands.execute(); //Todo
                    break;
            case 3: Commands.movePart(Commands.searchPart(parts, Commands.definePosition(splittedCommand[1])), Commands.definePosition(splittedCommand[2]));
                    break;
            case 4: Commands.rotatePart(Commands.searchPart(parts, Commands.definePosition(splittedCommand[1])), Commands.defineDirections(splittedCommand[2])); //temp
                    break;
            case 5: Commands.deletePart(parts, Commands.definePosition(splittedCommand[1]));
            //T0-D0

        }
    }
}