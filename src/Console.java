import java.util.*;

public class Console {

    //vars
    boolean enabled = true;
    int xCoordinate; //창 넓이
    int yCoordinate; //창 넓이
    Parts[][] parts;
    int[] position;
    Map map;

    //temps

    //scanner
    Scanner scanner = new Scanner(System.in);
    String[] splitCommand;


    //생성자
    Console (int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.parts = new Parts[xCoordinate][yCoordinate];
        this.map = new Map(xCoordinate,yCoordinate);
        this.map.createGrid();
    }



    //methods
    void run () {
        splitCommand = scanner.nextLine().split(" ");
        position = Commands.definePosition(splitCommand[1]);
        switch (Commands.defineCommandType(splitCommand[0]).getValue()) {
            case 0: //exception
                System.out.println("Unknown command");
                break;
            case 1: //new
                parts = Commands.createPart(Commands.definePartType(splitCommand[2]), position, parts, map, splitCommand[2]);
                map.visualizationParts(position, Commands.definePartType(splitCommand[2]));
                if (splitCommand[2].equals("button")) {
                    map.buttonList.add((Button) parts[position[0]-1][position[1]-1]);
                } else if (splitCommand[2].equals("led")) {
                    map.LEDList.add((LED) parts[position[0]-1][position[1]-1]);
                }
                for(Parts[] array : parts) {
                    for(Parts k : array) {
                        System.out.print(k + " ");
                    }
                    System.out.println();//temp
                }
                break;
            case 2: //execute
                map.createMap();
                Commands.execute(parts,map);//Todo
                this.enabled = false;
                break;
            case 3: //move
                Commands.movePart(position, Commands.definePosition(splitCommand[2]), parts);
                break;
            case 4: //rotate
                Commands.rotatePart(Commands.searchPart(parts, position), Commands.defineDirections(splitCommand[2]), parts);
                break;
            case 5: //connect
                Commands.connectPart(position, Commands.definePosition(splitCommand[2]), parts);
                break;
            case 6: //delete
                parts = Commands.deletePart(parts, Commands.definePosition(splitCommand[1]));
                break;
        }
                    //T0-D0

    }
}
