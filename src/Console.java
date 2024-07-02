import java.util.*;


public class Console {
    Scanner scanner = new Scanner(System.in);
    String command = scanner.nextLine();
    String[] splittedCommand = command.split(" ");
    CommandType commandType;

    void defineCommandType() {
        switch (splittedCommand[0]) {
            case "new":     commandType = CommandType.NEW;
                            break;
            case "execute": commandType = CommandType.EXECUTE;
                            break;
            case "move":    commandType = CommandType.MOVE;
                            break;
            case "rotate":  commandType = CommandType.ROTATE;
                            break;
            default:        commandType = CommandType.NONE;
                            System.out.println("Unknown command");
                            break;
        }
    }

    void excute() {
        switch (commandType.getValue()) {
            case 0:break;
            case 1:break;
            case 2:break;
            case 3:break;
            case 4:break;
            //T0-D0

        }

    }
}
