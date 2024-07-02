public class Wires {
    Direction[] direction;

    void defineDirections (String directions) {
        int index = 0;
        for (String d : directions.split(",")) {
            switch (d) {
                case "n":   this.direction[index] = Direction.NORTH;
                            break;
                case "e":   this.direction[index] = Direction.EAST;
                            break;
                case "s":   this.direction[index] = Direction.SOUTH;
                            break;
                case "w":   this.direction[index] = Direction.WEST;
                            break;
                default:    this.direction[index] = Direction.NONE;
                            System.out.println("There is no direction ->"+d);
                            break;
            }
            if(index >= 4) {
                System.out.println("The number of directions is incorrect.");
                break;
            }
            index++;
        }
        if (direction.length < 4) {
            for (int i = index; i==3; i++) {
                direction[i] = Direction.NONE;
            }
        }
    }
}
