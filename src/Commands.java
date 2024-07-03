import java.util.ArrayList;

class Commands {

    Direction[] defineDirections(String directions) {
        int index = 0;
        Direction[] direction = new Direction[4];
        for (String d : directions.split(",")) {
            switch (d) {
                case "n":
                    direction[index] = Direction.NORTH;
                    break;
                case "e":
                    direction[index] = Direction.EAST;
                    break;
                case "s":
                    direction[index] = Direction.SOUTH;
                    break;
                case "w":
                    direction[index] = Direction.WEST;
                    break;
                default:
                    direction[index] = Direction.NONE;
                    System.out.println("There is no direction ->" + d);
                    break;
            }
            index++;
        }
        return direction;
    }

    CommandType defineCommandType(String command) {
        CommandType commandType = null;
        switch (command) {
            case "new":     commandType = CommandType.NEW;
                break;
            case "execute": commandType = CommandType.EXECUTE;
                break;
            case "move":    commandType = CommandType.MOVE;
                break;
            case "rotate":  commandType = CommandType.ROTATE;
                break;
            default:        commandType = CommandType.NONE;
                System.out.println("Unknown command");
                break;
        }
        return commandType;
    }

    static PartType definePartType(String part) {
        PartType partType = null;
        switch (part) {
            case "wire":    partType = PartType.WIRE;
                break;
            case "and":     partType = PartType.AND;
                break;
            case "or":      partType = PartType.OR;
                break;
            case "not":     partType = PartType.NOT;
                break;
            case "nand":    partType = PartType.NAND;
                break;
            case "nor":     partType = PartType.NOR;
                break;
            case "xor":     partType = PartType.XOR;
                break;
            default:        System.out.println("Unknown part");
                break;
        }
        return partType;
    }

    //actions
    static int[] definePosition(String position) {
        String[] posStr = position.split(",");
        int[] posInt = new int[2];
        posInt[0] = Integer.parseInt(posStr[0]);
        posInt[1] = Integer.parseInt(posStr[1]);
        return posInt;
    }

    static ArrayList<Parts> createParts(PartType part, Direction[] d, int[] position) {
        int xPos = position[0];
        int yPos = position[1];
        ArrayList<Parts> parts = new ArrayList<Parts>();
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
        return parts;
    }

    void movePart(Parts part, int xPos, int yPos) {

    }
//    void rotatePart (Parts part, )
}

