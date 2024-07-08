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
                parts = Commands.createPart(Commands.definePartType(splitCommand[3]), Commands.defineDirections(splitCommand[2]), position, parts, map, splitCommand[3]);
                map.visualizationParts(position, Commands.definePartType(splitCommand[3]));
                if (splitCommand[3].equals("button")) {
                    map.buttonList.add((Button) parts[position[0]-1][position[1]-1]);
                } else if (splitCommand[3].equals("led")) {
                    map.LEDList.add((LED) parts[position[0]-1][position[1]-1]);
                }
                break;
            case 2: //execute
                map.createMap();
                Commands.execute(parts,map);//Todo
                this.enabled = false;
                break;
            case 3: //move
                parts = Commands.movePart(position, Commands.definePosition(splitCommand[2]),parts);
                break;
            case 4: //rotate
                parts = Commands.rotatePart(Commands.searchPart(parts,position), Commands.defineDirections(splitCommand[2]), parts); //temp
                break;
            case 5: //connect
                parts = Commands.connectPart(position, Commands.definePosition(splitCommand[1]), parts);
                break;
            case 6: //delete
                parts = Commands.deletePart(parts, Commands.definePosition(splitCommand[1]));
                break;
        }
                    //T0-D0
        for(Parts[] array : parts) {
            for(Parts k : array) {
                System.out.print(k + " ");
            }
            System.out.println();//temp
        }
    }
}
