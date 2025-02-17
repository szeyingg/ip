import java.util.Scanner;

public class Mira {
    private static Task[] list;
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
        list[listLength] = new Todo(command);
        reportTaskAdded(list[listLength]);
        listLength++;
    }

    public static void addDeadline(String command) {
        int byIndex = command.indexOf(" /by ");

        if (byIndex == -1) {
            System.out.println("invalid");
        } else {
            String description = command.substring(0, byIndex);
            String by = command.substring(byIndex + 5);

            list[listLength] = new Deadline(description, by);
            reportTaskAdded(list[listLength]);
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

            list[listLength] = new Event(description, from, to);
            reportTaskAdded(list[listLength]);
            listLength++;
        }
    }


    public static void printList() {
        if (listLength == 0) {
            System.out.println("Hmm, your list is empty... Use your powers to conjure a task!");
        } else {
            System.out.println("Abra-Cadabra! Here's your task list:");
            for (int i = 1; i < listLength + 1; i++) {
                Task t = list[i-1];
                System.out.print(i + ".");
                System.out.println(t);
            }
        }
    }

    public static void markTask(String num) {
        int idx = Integer.parseInt(num);
        Task t = list[idx - 1];
        t.markAsDone();
        System.out.println("Presto, you did it! Task " + idx + " has been conquered!");
    }

    public static void unmarkTask(String num) {
        int idx = Integer.parseInt(num);
        Task t = list[idx -1];
        t.markAsUndone();
        System.out.println("Tough luck! Task " + idx + " has come back stronger!");
    }


    public static void main(String[] args) {
        intro();
        list = new Task[100];
        listLength = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("What spell would you like to cast?");
            String in = input.nextLine();

            String[] command = in.split(" ", 2);
            String action = command[0];
            String param = (command.length > 1) ? command[1] : ""; //empty if no param

            switch (action) {
                case "bye": exit(); break;
                case "list": printList(); break;
                case "todo": addTodo(param); break;
                case "deadline": addDeadline(param); break;
                case "event": addEvent(param); break;
                case "mark": markTask(param); break;
                case "unmark": unmarkTask(param); break;
                default: System.out.println("Oh no... seems like your spell " + action + " failed, try another?");
            }
            line();
        }
    }
}
