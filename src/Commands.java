
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
        return switch (command) {
            case "new" -> CommandType.NEW;
            case "execute" -> CommandType.EXECUTE;
            case "move" -> CommandType.MOVE;
            case "rotate" -> CommandType.ROTATE;
            case "connect" -> CommandType.CONNECT;
            case "delete" -> CommandType.DELETE;
            default -> {
                System.out.println("Unknown command");
                yield CommandType.NONE;
            }
        };

    }

    static PartType definePartType(String part) {
        return switch (part) {
            case "and" -> PartType.AND;
            case "or" -> PartType.OR;
            case "not" -> PartType.NOT;
            case "nand" -> PartType.NAND;
            case "nor" -> PartType.NOR;
            case "xor" -> PartType.XOR;
            case "xnor" -> PartType.XNOR;
            case "button" -> PartType.BUTTON;
            case "led" -> PartType.LED;
            default -> {
                System.out.println("Unknown part");
                yield PartType.NONE;
            }
        };

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

    static Parts[][] createPart(PartType partType, int[] position, Parts[][] parts, Map map, String SParts) {
        Parts part = null;

        switch (partType.getValue()) {
            case 1:
                part = new AndGate(position);
                break;
            case 2:
                part = new OrGate(position);
                break;
            case 3:
                part = new NotGate(position);
                break;
            case 4:
                part = new NAndGate(position);
                break;
            case 5:
                part = new NOrGate(position);
                break;
            case 6:
                part = new XOrGate(position);
                break;
            case 7:
                part = new XNOrGate(position);
                break;
            case 8:
                part = new Button(position);
                break;
            case 9:
                part = new LED(position);
                break;
            default:System.out.println("unknown command");
                break;
        }
        parts[position[0]-1][position[1]-1] = part;
        return parts;
    }

    static Parts[][] movePart(int[] originalPos, int[] pos, Parts[][] parts) {
        try {
            parts[originalPos[0]-1][originalPos[1]-1].move(pos[0]-1, pos[1]-1);
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

    static void execute(Parts[][] parts, Map map) {
        Parts[][] rotatedPart = RotateArray.rotate90(parts, map.xCoordinate, map.yCoordinate);
        for(Parts[] array : parts) {
            for(Parts k : array) {
                if (k instanceof Button) {
                    k.react(map.buttonList.indexOf(k));
                } else if (k instanceof LED) {
                    k.react(map.LEDList.indexOf(k));
                } else if (k instanceof AndGate) {
                    k.react(0);
                } else if (k instanceof OrGate) {
                    k.react(0);
                } else if (k instanceof NotGate) {
                    k.react(0);
                } else if (k instanceof NAndGate) {
                    k.react(0);
                } else if (k instanceof NOrGate) {
                    k.react(0);
                } else if (k instanceof XOrGate) {
                    k.react(0);
                }  else if (k instanceof XNOrGate) {
                    k.react(0);
                } else if (k != null) {
                    k.react(0);
                }
            }
        }
    } //Todo

    static Parts[][] connectPart(int[] outputPos, int[] inputPos, Parts[][] parts) {
        parts[inputPos[0]-1][inputPos[1]-1].outputConnect(parts[outputPos[0]-1][outputPos[1]-1]);   //input 받는 곳에 연결
        parts[outputPos[0]-1][outputPos[1]-1].inputConnect(parts[inputPos[0]-1][inputPos[1]-1]);    //output 하는 곳에 연결
        return parts;
    }

    static Parts[][] deletePart(Parts[][] parts, int[] pos) {
        parts[pos[0]][pos[1]] = null;
        return parts;
    }

}

