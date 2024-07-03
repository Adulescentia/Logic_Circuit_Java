enum CommandType {
    NONE(0), NEW(1),EXECUTE(2),MOVE(3), ROTATE(4);

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
    NONE(0),WIRE(1), AND(2), OR(3), NOT(4), NAND(5), NOR(6), XOR(7);

    private final int value;
    PartType(int value) { this.value = value; }

    public int getValue() {return value;}
}

