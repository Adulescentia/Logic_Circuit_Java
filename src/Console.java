import java.util.*;


public class Console {
    Scanner scanner = new Scanner(System.in);
    String command = scanner.nextLine();
    String[] splittedCommand = command.split(" ");
    int[] position;


    ArrayList<Parts> parts = new ArrayList<>();

    //enums
    CommandType commandType;
    PartType partType;
    Direction[] direction;
    //dummy
    Parts dummy = new Parts(direction, 0, 0);

    void excute() {
        switch (commandType.getValue()) {
            case 0:
                System.out.println("Unknown command");
                break;
            case 1:
                parts = Commands.createParts(partType, direction, new int[]{1, 3});
                break;
            case 2:
                break;
            case 3:
                movePart(dummy, 0, 0);
                break;
            case 4:
                rotatePart(dummy, 0, 0);
                break;
            //T0-D0

        }
    }
}