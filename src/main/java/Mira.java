import java.util.Arrays;
import java.util.Scanner;

public class Mira {
    private static Task[] list;

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
    }

    public static void addTask(String command) {
        System.out.println("New task conjured: " + command);
        int idx = list.length;
        Task[] newList = Arrays.copyOf(list, idx+1);
        newList[idx] = new Task(command);
        list = newList;
    }

    public static void printList() {
        if (list.length == 0) {
            System.out.println("Hmm, your list is empty... Use your powers to conjure a task!");
        } else {
            System.out.println("Abra-Cadabra! Here's your task list:");
            for (int i = 1; i < list.length + 1; i++) {
                Task t = list[i-1];
                System.out.println(i + ". [" + t.getStatusIcon() + "] " + t.description);
            }
        }
    }

    public static void markTask(int idx) {
        Task t = list[idx - 1];
        t.markAsDone();
        System.out.println("Presto, you did it! Task " + idx + " is done and dusted!");
    }

    public static void unmarkTask(int idx) {
        Task t = list[idx -1];
        t.markAsUndone();
        System.out.println("Tough luck! Task " + idx + " has come back stronger!");
    }


    public static void main(String[] args) {
        intro();
        list = new Task[0];
        Scanner input = new Scanner(System.in);
        while (true) {
            String in = input.nextLine();
            String[] command = in.split(" ");
            String action = command[0];
            int param = -1;
            //if (command.length >1)

            switch (action) {
                case "bye": exit(); break;
                case "list": printList(); break;
                case "mark":
                    param = Integer.parseInt(command[1]);
                    markTask(param);
                    break;
                case "unmark":
                    param = Integer.parseInt(command[1]);
                    unmarkTask(param);
                    break;
                default: addTask(in);
            }
            line();
        }
    }
}
