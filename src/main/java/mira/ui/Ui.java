package mira.ui;

public class Ui {
    public void showWelcome() {
        System.out.println(Text.LINE + "\n" + Text.INTRO + "\n" + Text.LINE);
        System.out.println(Text.TASK_LOADING + "\n" + Text.LINE);
    }

    public void showPendingInput() {
        System.out.print(Text.PENDING_INPUT);
    }

    public void showLine() {
        System.out.println(Text.LINE);
    }

    public void showBufferLine() {
        System.out.println(Text.LINE_BUFFER);
    }

    public void exit() {
        System.out.println(Text.BYE + "\n" + Text.LINE);
        System.exit(0);
    }
}
