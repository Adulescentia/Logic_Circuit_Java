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

    Parts ( int[] position ) {
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
    AndGate(int[] position) {
        super( position);
    }
    void react (int i) {
        result = outputConnects.get(0).result && outputConnects.get(1).result;
    }


}

class OrGate extends Parts {
    OrGate(int[] position) {
        super(position);

    }
    void react (int i) {
        result = outputConnects.get(0).result || outputConnects.get(1).result;
    }
}

class NotGate extends Parts {
    NotGate(int[] position) {
        super(position);
    }
    void react (int i) {
        result = !outputConnects.get(0).result;
    }
}

class NAndGate extends Parts {
    NAndGate(int[] position) {
        super(position);
    }
    void react (int i) {
        result = !(outputConnects.get(0).result && outputConnects.get(1).result);
    }
}

class NOrGate extends Parts {
    NOrGate(int[] position) {
        super(position);
    }
    void react (int i) {
        result = !(outputConnects.get(0).result || outputConnects.get(1).result);
    }
}

class XOrGate extends Parts {
    XOrGate(int[] position) {
        super(position);
    }
    void react (int i) {
        result = outputConnects.get(0).result ^ outputConnects.get(1).result;
    }
}

class XNOrGate extends Parts {
    XNOrGate(int[] position) {
        super(position);
    }
    void react (int i) {
        result = !(outputConnects.get(0).result ^ outputConnects.get(1).result);
    }

}

//ETCs
class Button extends Parts {
    Scanner scanner = new Scanner(System.in);
    Button(int[] position) {
        super(position);
    }

    void react (int index) {
        System.out.println("Button " + (index + 1) + " >>>");
        result = scanner.nextBoolean();
    }
}

class LED extends Parts {

    LED(int[] position) {
        super(position);
    }

    void react (int index) {
        result = outputConnects.get(0).result;
        System.out.println("LED " + (index + 1) + ">>> " + result);
    }



}