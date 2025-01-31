import java.util.Scanner;

public class Mira {
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

    public static void echo(String command) {
        line();
        System.out.println(command);
        line();
    }

    public static void main(String[] args) {
        intro();

        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.nextLine();
            if (command.equals("bye")) {
                exit();
            } else {
                echo(command);
            }
        }
    }
}
