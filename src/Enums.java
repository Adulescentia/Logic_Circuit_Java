enum CommandType {
    NONE(0), NEW(1),EXECUTE(2),MOVE(3), ROTATE(4), CONNECT(5), DELETE(6);

    private final int value;
    CommandType(int value) { this.value = value; }

    public int getValue() {return value;}
}

enum Direction {
    NONE(0),NORTH(1), EAST(2), SOUTH(3), WEST(4);

    private final int value;
    Direction(int value) { this.value = value; }

    public int getValue() {return value;}
}

enum PartType {
    NONE(0), AND(1), OR(2), NOT(3), NAND(4), NOR(5), XOR(6), XNOR(7), BUTTON(8), LED(9),;

    private final int value;
    PartType(int value) { this.value = value; }

    public int getValue() {return value;}
}

