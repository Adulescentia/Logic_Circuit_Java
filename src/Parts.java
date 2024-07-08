import java.util.ArrayList;
import java.util.Scanner;

//Logic gates
public abstract class Parts {
    Direction[] direction;
    int xPos;
    int yPos;
    int[] position;
    ArrayList<Parts> inputConnects = new ArrayList<>();
    ArrayList<Parts> outputConnects = new ArrayList<>();
    boolean result;

    Parts (Direction[] direction, int[] position) {
        this.direction = direction;
        this.xPos = position[0];
        this.yPos = position[1];
        this.position = position;
    }

    //actions
    void move (int x, int y) {
        xPos = x;
        yPos = y;
    }

    void rotate (Direction[] direction) { this.direction = direction; }

    void inputConnect (Parts part) { inputConnects.add(part); }

    void outputConnect (Parts part) { outputConnects.add(part); }

    void react (int index) {}


}

class AndGate extends Parts {
    AndGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
    void react () {
        result = inputConnects.get(0).result && inputConnects.get(1).result;
    }


}

class OrGate extends Parts {
    OrGate(Direction[] direction, int[] position) {
        super(direction, position);

    }
    void react () {
        result = inputConnects.get(0).result || inputConnects.get(1).result;
    }
}

class NotGate extends Parts {
    NotGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
    void react () {
        result = !inputConnects.get(0).result;
    }
}

class NAndGate extends Parts {
    NAndGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
    void react () {
        result = !(inputConnects.get(0).result && inputConnects.get(1).result);
    }
}

class NOrGate extends Parts {
    NOrGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
    void react () {
        result = !(inputConnects.get(0).result || inputConnects.get(1).result);
    }
}

class XOrGate extends Parts {
    XOrGate(Direction[] direction, int[] position) {
        super(direction, position);
    }
    void react () {
        result = inputConnects.get(0).result != inputConnects.get(1).result;
    }   //의심스러움
}

class XNOrGate extends Parts {
    XNOrGate(Direction[] direction, int[] position) {
        super(direction, position);
    }

}

//ETCs
class Button extends Parts {
    Scanner scanner = new Scanner(System.in);
    Button(Direction[] direction, int[] position) {
        super(direction, position);
    }

    void react (int index) {
        System.out.println("Button " + index + " >>>");
        result = scanner.nextBoolean();
    }
}

class LED extends Parts {

    LED(Direction[] direction, int[] position) {
        super(direction, position);
    }

    void react (int index) {
        result = inputConnects.get(0).result == inputConnects.get(1).result;
        System.out.println("LED " + index + ">>> " + result);
    }



}