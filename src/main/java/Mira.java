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
                Greetings! I'm Mira, your enchanted task-keeper!
                What wonders would you like to accomplish today?
                """);
        line();
    }

    public static void exit() {
        System.out.println("And... Poof! I'm off~ But don’t worry, I’m just a spell away!");
        line();
    }

    public static void addTask(String command) {
        System.out.println("New task conjured: " + command);
        int idx = list.length;
        String[] newList = Arrays.copyOf(list, idx+1);
        newList[idx] = command;
        list = newList;
        line();
    }

    public static void printList() {
        if (list.length == 0) {
            System.out.println("Hmm, your list is empty... Use your powers to conjure a task!");
        } else {
            System.out.println("Abra-Cadabra! Here's your task list:");
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
