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
    Parts dummy = new Parts(direction,0,0);

    void excute() {
        switch (commandType.getValue()) {
            case 0: System.out.println("Unknown command");
                    break;
            case 1: createParts(partType, direction);
                    break;
            case 2:
                    break;
            case 3: movePart(dummy,0,0);
                    break;
            case 4:break;
            //T0-D0

        }

    }

    void createParts (PartType part, Direction[] d, int[] position) {
        int xPos = position[0];
        int yPos = position[1];
        switch (part.getValue()) {
            case 1: parts.add(new Wire(d, xPos, yPos));
                    break;
            case 2: parts.add(new AndGate(d, xPos, yPos));
                    break;
            case 3: parts.add(new OrGate(d, xPos, yPos));
                    break;
            case 4: parts.add(new NotGate(d, xPos, yPos));
                    break;
            case 5: parts.add(new NAndGate(d, xPos, yPos));
                    break;
            case 6: parts.add(new NOrGate(d, xPos, yPos));
                    break;
            case 7: parts.add(new XOrGate(d, xPos, yPos));
                    break;
            default:System.out.println("unknown command");
                    break;
        }
    }

    void movePart(Parts part, int xPos, int yPos) {

    }
    void rotatePart (Parts part, )
}
