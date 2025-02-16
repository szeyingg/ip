import java.util.Scanner;
import mira.task.*;
import mira.text.*;

public class Mira {
    public static final int MAX_TASKS = 100;
    public static final Task[] tasks = new Task[MAX_TASKS];
    public static int listLength = 0;

    public static void intro() {
        System.out.println(Text.LINE);
        System.out.println(Text.INTRO);
        System.out.println(Text.LINE);
    }

    public static void exit() {
        System.out.println(Text.BYE);
        System.exit(0);
    }

    //TODO: move functions into classes
    public static void reportTaskAdded(Task t) {
        System.out.println("Ta-da! A new task has been conjured: ");
        System.out.println(t);
        System.out.println("Phew! A total of " + (listLength + 1) + " magical tasks awaits you!");
    }

    public static void addTodo(String command) {
        tasks[listLength] = new Todo(command);
        reportTaskAdded(tasks[listLength]);
        listLength++;
    }

    public static void addDeadline(String command) {
        String[] parts = command.split(" /by ", 2);

        if (parts.length != 2) {
            System.out.println(Text.MISSING_PARAM + "\n" + Text.HELP);
        } else {
            String description = parts[0];
            String by = parts[1];

            tasks[listLength] = new Deadline(description, by);
            reportTaskAdded(tasks[listLength]);
            listLength++;
        }
    }

    public static void addEvent(String command) {
        String[] parts = command.split(" /from | /to ", 3);
        if (parts.length != 3) {
            System.out.println(Text.MISSING_PARAM + "\n" + Text.HELP);
        } else {
            String description = parts[0];
            String from = parts[1];
            String to = parts[2];

            tasks[listLength] = new Event(description, from, to);
            reportTaskAdded(tasks[listLength]);
            listLength++;
        }
    }

    public static void printList() {
        if (listLength == 0) {
            System.out.println(Text.LIST_EMPTY);
        } else {
            System.out.println("Abra-Cadabra! Here's your task list:");
            for (int i = 1; i < listLength + 1; i++) {
                Task t = tasks[i-1];
                System.out.print(i + ".");
                System.out.println(t);
            }
        }
    }

    public static void markTask(String num) {
        int idx = Integer.parseInt(num);
        Task t = tasks[idx - 1];
        t.setDone(true);
        System.out.println("Presto, you did it! Task " + idx + " has been conquered!");
        System.out.println(t);
    }

    public static void unmarkTask(String num) {
        int idx = Integer.parseInt(num);
        Task t = tasks[idx -1];
        t.setDone(false);
        System.out.println("Tough luck! Task " + idx + " has come back stronger!");
        System.out.println(t);
    }

    public static void main(String[] args) {
        intro();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(Text.PENDING_INPUT);
            String in = input.nextLine();


            String[] command = in.split(" ", 2);
            String action = command[0];
            String param = (command.length > 1) ? command[1] : ""; //empty if no param

            switch (action) {
                case "bye" -> exit();
                case "list" -> printList();
                case "todo" -> addTodo(param);
                case "deadline" -> addDeadline(param);
                case "event" -> addEvent(param);
                case "mark" -> markTask(param);
                case "unmark" -> unmarkTask(param);
                case "help" -> System.out.println(Text.COMMAND_LIST);
                default -> System.out.println(Text.INVALID_COMMAND + "\n" + Text.HELP);
            }
            System.out.println(Text.LINE);
        }
    }
}
