import java.util.Scanner;
import mira.task.*;
import mira.text.*;

public class Mira {


    public static void exit() {
        System.out.println(Text.BYE + "\n" + Text.LINE);
        System.exit(0);
    }

    public static void main(String[] args) {
        System.out.println(Text.LINE + "\n" + Text.INTRO + "\n" + Text.LINE);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(Text.PENDING_INPUT);
            String in = input.nextLine();

            String[] command = in.split(" ", 2);
            String action = command[0];
            String param = (command.length > 1) ? command[1] : ""; //empty if no param

            switch (action) {
                case "bye" -> exit();
                case "list" -> Task.printList();
                case "todo" -> Todo.addTodo(param);
                case "deadline" -> Deadline.addDeadline(param);
                case "event" -> Event.addEvent(param);
                case "mark" -> Task.markTask(param);
                case "unmark" -> Task.unmarkTask(param);
                case "help" -> System.out.println(Text.COMMAND_LIST);
                default -> System.out.println(Text.INVALID_COMMAND + "\n" + Text.HELP);
            }
            System.out.println(Text.LINE);
        }
    }
}
