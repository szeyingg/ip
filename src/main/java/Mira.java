import java.util.Arrays;
import java.util.Scanner;

public class Mira {
    private static String[] list;

    public static void line() {
        System.out.println("____________________________________________________________");
    }

    public static void intro() {
        line();
        System.out.print("""
                Hello! I'm Mira
                What can I do for you?
                """);
        line();
    }

    public static void exit() {
        line();
        System.out.println("Bye. Hope to see you again soon!");
        line();
    }

    public static void addTask(String command) {
        line();
        System.out.println("Task added " + command);
        int idx = list.length;
        String[] newList = Arrays.copyOf(list, idx+1);
        newList[idx] = command;
        list = newList;
        line();
    }

    public static void printList() {
        line();
        if (list.length == 0) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Here are the tasks in your list: ");
            for (int i = 1; i < list.length + 1; i++) {
                System.out.println(i + "." + list[i - 1]);
            }
        }
        line();
    }

    public static void main(String[] args) {
        intro();
        list = new String[0];
        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.nextLine();
            switch (command) {
                case "bye": exit(); break;
                case "list": printList(); break;
                default: addTask(command);
            }
        }
    }
}
