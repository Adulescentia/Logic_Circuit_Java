import java.util.*;

public class Console {

    //vars
    int xCoordinate = 10; //창 넓이
    int yCoordinate = 8; //창 넓이
    Parts[][] parts;
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
    String[] splitCommand;


    //생성자
    Console (int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.parts = new Parts[xCoordinate][yCoordinate];

    }



    //methods
    void run () {
        splitCommand = scanner.nextLine().split(" ");
        switch (Commands.defineCommandType(splitCommand[0]).getValue()) {
            case 0:
                System.out.println("Unknown command");
                break;
            case 1:
                this.parts[Commands.definePosition(splitCommand[3])[0]][Commands.definePosition(splitCommand[3])[1]] = Commands.createParts(Commands.definePartType(splitCommand[1]), Commands.defineDirections(splitCommand[2]), Commands.definePosition(splitCommand[3])); //temp
                break;
            case 2:
                Commands.execute(); //Todo
                break;
            case 3:
                parts = Commands.movePart(Commands.definePosition(splitCommand[1]), Commands.definePosition(splitCommand[2]),parts);
                break;
            case 4:
                Commands.rotatePart(Commands.searchPart(parts, Commands.definePosition(splitCommand[1])), Commands.defineDirections(splitCommand[2])); //temp
                break;
            case 5:
                Commands.deletePart(parts, Commands.definePosition(splitCommand[1]));
                break;
        }
                    //T0-D0
        for(Parts[] array : parts) {
            for(Parts k : array) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
