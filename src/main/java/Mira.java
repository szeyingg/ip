import java.util.Arrays;
import java.util.Scanner;

public class Mira {
    private static Task[] tasks;
    private static int listLength;

    public static void line() {
        System.out.println("____________________________________________________________");
    }

    public static void intro() {
        line();
        System.out.print("""
                Greetings! I'm Mira, your enchanted task-keeper!
                What wonders would you like to accomplish today?
                """);
        line();
    }

    public static void exit() {
        System.out.println("And... Poof! I'm off~ But don’t worry, I’m just a spell away!");
        System.exit(0);
    }

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
        int byIndex = command.indexOf(" /by ");

        if (byIndex == -1) {
            System.out.println("invalid");
        } else {
            String description = command.substring(0, byIndex);
            String by = command.substring(byIndex + 5);

            tasks[listLength] = new Deadline(description, by);
            reportTaskAdded(tasks[listLength]);
            listLength++;
        }
    }

    public static void addEvent(String command) {
        int fromIndex = command.indexOf(" /from ");
        int toIndex = command.indexOf(" /to ");

        if (fromIndex == -1 || toIndex == -1 || fromIndex > toIndex) {
            System.out.println("invalid");
        } else {
            String description = command.substring(0, fromIndex);
            String from = command.substring(fromIndex + 7, toIndex);
            String to = command.substring(toIndex + 5);

            tasks[listLength] = new Event(description, from, to);
            reportTaskAdded(tasks[listLength]);
            listLength++;
        }
    }


    public static void printList() {
        if (listLength == 0) {
            System.out.println("Hmm, your list is empty... Use your powers to conjure a task!");
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
    }

    public static void unmarkTask(String num) {
        int idx = Integer.parseInt(num);
        Task t = tasks[idx -1];
        t.setDone(false);
        System.out.println("Tough luck! Task " + idx + " has come back stronger!");
    }


    public static void main(String[] args) {
        intro();
        tasks = new Task[100];
        listLength = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("What spell would you like to cast?");
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
            }
            line();
        }
    }
}
