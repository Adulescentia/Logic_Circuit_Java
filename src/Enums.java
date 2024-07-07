import javax.swing.*;
import java.awt.*;
import java.util.Objects;

enum CommandType {
    NONE(0), NEW(1),EXECUTE(2),MOVE(3), ROTATE(4), CONNECT(5), DELETE(6);

    private final int value;
    CommandType(int value) {
        this.value = value;
    }

    public int getValue() {return value;}
}

enum Direction {
    NONE(0),NORTH(1), EAST(2), SOUTH(3), WEST(4);

    private final int value;
    Direction(int value) { this.value = value; }

}

enum PartType {
    NONE(0, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/NONE.png")))),
    AND(1, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/AND.png")))),
    OR(2, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/OR.png")))),
    NOT(3, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/NOT.png")))),
    NAND(4, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/NAND.png")))),
    NOR(5, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/NOR.png")))),
    XOR(6, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/XOR.png")))),
    XNOR(7, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/XNOR.png")))),
    BUTTON(8, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/BUTTON.png")))),
    LED(9, new ImageIcon(Objects.requireNonNull(Main.class.getResource("images/LED.png")))),
    ;

    private final int value;
    private final ImageIcon image;
    PartType(int value, ImageIcon image) {
        this.value = value;
        this.image = image;
    }
    public int getValue() {return value;}
    public ImageIcon getImage() {return image;}
}

