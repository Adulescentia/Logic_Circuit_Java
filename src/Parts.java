public class Parts {
    Direction[] direction;
    int xPos;
    int yPos;

    int size = 2;
    Parts (Direction[] direction, int xPos, int yPos) {
        this.direction = direction;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    Parts (Direction[] direction, int[] position) {
        this.direction = direction;
        this.xPos = position[0];
        this.yPos = position[1];
    }

    void move (int x, int y) {
        xPos = x;
        yPos = y;
    }

    void rotate (Direction[] direction) {
        this.direction = direction;
    }
}

class Wire extends Parts {
    Wire(Direction[] direction, int xPos, int yPos) {
        super(direction, xPos, yPos);
    }
    Wire(Direction[] direction, int[] position) {
        super(direction, position);
    }
}

class AndGate extends Parts {
    AndGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
    AndGate(Direction[] direction, int xPos, int yPos) {
        super(direction, xPos, yPos);
    }
}

class OrGate extends Parts {
    OrGate(Direction[] direction, int xPos, int yPos) {
        super(direction, xPos, yPos);
    }
    OrGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
}

class NotGate extends Parts {
    NotGate(Direction[] direction, int xPos, int yPos) {
        super(direction, xPos, yPos);
    }
    NotGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
}

class NAndGate extends Parts {
    NAndGate(Direction[] direction, int xPos, int yPos) {
        super(direction, xPos, yPos);
    }
    NAndGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
}

class NOrGate extends Parts {
    NOrGate(Direction[] direction, int xPos, int yPos) {
        super(direction, xPos, yPos);
    }
    NOrGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
}

class XOrGate extends Parts {
    XOrGate(Direction[] direction, int xPos, int yPos) {
        super(direction, xPos, yPos);
    }
    XOrGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
}

