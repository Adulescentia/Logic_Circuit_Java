import java.util.*;


public class Console {


    Scanner scanner = new Scanner(System.in);
    String command = scanner.nextLine();
    String[] splittedCommand = command.split(" ");
    int[] position;


    ArrayList<Parts> parts = new ArrayList<>();
    Parts[][] parts;
    //enums
    CommandType commandType;
    PartType partType;
    Direction[] direction;
    //dummy
    Parts dummy = new Parts(direction, 0, 0);

    //생성자
    Console (int xCoordinate, int yCoordinate) {
        Parts[xCoordinate][yCoordinate] parts;
    }

    void excute() {
        switch (commandType.getValue()) {
            case 0:
                System.out.println("Unknown command");
                break;
            case 1:
                parts = Commands.createParts(partType, direction, new int[]{1, 3}); //temp
                break;
            case 2:
                break;
            case 3:

                break;
            case 4:
                Commands.rotatePart(dummy, new Direction[]{Direction.WEST}); //temp
                break;
            //T0-D0

        }
    }
}