import java.util.ArrayList;
import java.util.Arrays;

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

    static CommandType defineCommandType(String command) {
        CommandType commandType = null;
        switch (command) {
            case "new":
                commandType = CommandType.NEW;
                break;
            case "execute":
                commandType = CommandType.EXECUTE;
                break;
            case "move":
                commandType = CommandType.MOVE;
                break;
            case "rotate":
                commandType = CommandType.ROTATE;
                break;
            case "connect":
                commandType = CommandType.CONNECT;
                break;
            case "delete":
                commandType = CommandType.DELETE;
                break;
            default:
                commandType = CommandType.NONE;
                System.out.println("Unknown command");
                break;
        }
        return commandType;
    }

    static PartType definePartType(String part) {
        PartType partType;
        switch (part) {
            case "and":
                return PartType.AND;
                break;
            case "or":
                return PartType.OR;
                break;
            case "not":
                return PartType.NOT;
                break;
            case "nand":
                return PartType.NAND;
                break;
            case "nor":
                return PartType.NOR;
                break;
            case "xor":
                return PartType.XOR;
                break;
            case "xnor":
                return PartType.XNOR;
                break;
            case "button":
                return PartType.BUTTON;
                break;
            case "led":
                return PartType.LED;
                break;
            default:
                System.out.println("Unknown part");
                return PartType.NONE;
                break;

        }

    }

    //actions
    static int[] definePosition(String position) {
        String[] posStr = position.split(",");
        int[] posInt = new int[2];
        try {
            posInt[0] = Integer.parseInt(posStr[0]);
            posInt[1] = Integer.parseInt(posStr[1]);
        } catch (NumberFormatException e1) {
            return new int[]{0, 0};
        }
        return posInt;
    }

    static Parts[][] createPart(PartType partType, Direction[] d, int[] position, Parts[][] parts) {
        Parts part = null;

        switch (partType.getValue()) {
            case 1:
                part = new AndGate(d, position);
                break;
            case 2:
                part = new OrGate(d, position);
                break;
            case 3:
                part = new NotGate(d, position);
                break;
            case 4:
                part = new NAndGate(d, position);
                break;
            case 5:
                part = new NOrGate(d, position);
                break;
            case 6:
                part = new XOrGate(d, position);
                break;
            case 7:
                part = new XNOrGate(d, position);
                break;
            case 8:
                part = new Button(d, position);
                break;
            case 9:
                part = new LED(d, position);
                break;
            default:System.out.println("unknown command");
                break;
        }
        parts[position[0]][position[1]] = part;
        return parts;
    }

    static Parts[][] movePart(int[] originalPos, int[] pos, Parts[][] parts) {
        try {
            parts[originalPos[0]][originalPos[1]].move(pos[0], pos[1]);
        } catch (NullPointerException e1) {
            System.out.println("There is noting");
        }
        parts[originalPos[0]][originalPos[1]] = null;
        return parts;
    }

    static Parts[][] rotatePart(Parts part, Direction[] direction, Parts[][] parts) {
        parts[part.xPos][part.yPos].rotate(direction);
        return parts;
    }

    static Parts searchPart(Parts[][] part, int[] pos) { return part[pos[0]][pos[1]];}

    static void execute(Parts[][] parts) {
        Parts[][] rotatedPart = RotateArray.rotate90(parts);
        for(Parts[] array : rotatedPart) {
            for(Parts k : array) {
                if (k != null || !(k instanceof Button)) {
                    k.react();
                }
            }
        }
    } //Todo

    static Parts[][] connectPart(int[] outputPos, int[] inputPos, Parts[][] parts) {
        parts[inputPos[0]][inputPos[1]].outputConnect(parts[outputPos[0]][outputPos[1]]);   //input 받는 곳에 연결
        parts[outputPos[0]][outputPos[1]].inputConnect(parts[inputPos[0]][inputPos[1]]);    //output 하는 곳에 연결
        return parts;
    }

    static Parts[][] deletePart(Parts[][] parts, int[] pos) {
        parts[pos[0]][pos[1]] = null;
        return parts;
    }

}

