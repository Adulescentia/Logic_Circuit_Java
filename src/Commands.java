import java.util.ArrayList;

class Commands {

    static Direction[] defineDirections(String directions) {
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
            case "delete":  commandType = CommandType.DELETE;
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

    static Parts[][] createParts(PartType part, Direction[] d, int[] position) {
        int xPos = position[0];
        int yPos = position[1];
        Parts[][] parts = new Parts[xPos][yPos];
        switch (part.getValue()) {
            case 1: parts[xPos-1][yPos-1] = new Wire(d, xPos, yPos);
                break;
            case 2: parts[xPos-1][yPos-1] = new AndGate(d, xPos, yPos);
                break;
            case 3: parts[xPos-1][yPos-1] = new OrGate(d, xPos, yPos);
                break;
            case 4: parts[xPos-1][yPos-1] = new NotGate(d, xPos, yPos);
                break;
            case 5: parts[xPos-1][yPos-1] = new NAndGate(d, xPos, yPos);
                break;
            case 6: parts[xPos-1][yPos-1] = new NOrGate(d, xPos, yPos);
                break;
            case 7: parts[xPos-1][yPos-1] = new XOrGate(d, xPos, yPos);
                break;
            default:System.out.println("unknown command");
                break;
        }
        return parts;
    }

    static void movePart(Parts part, int[] pos) {
        part.move(pos[0], pos[1]);
    }

    static void rotatePart(Parts part, Direction[] direction) {
        part.rotate(direction);
    }

    static Parts searchPart(Parts[][] part, int[] pos) { return part[pos[0]][pos[1]];}

    static void execute() {} //Todo

    static Parts[][] deletePart(Parts[][] parts, int[] pos) {
        parts[pos[0]][pos[1]] = null;
        return parts;
    }
}

