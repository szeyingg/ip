package mira.task;

import mira.exception.EmptyListException;
import mira.exception.MissingParamException;
import mira.text.Text;

public class Task {
    protected String description;
    protected boolean isDone;

    public static final int MAX_TASKS = 100;
    public static final Task[] tasks = new Task[MAX_TASKS];
    public static int listLength = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public static void addTask(Task task) {
        if (listLength >= MAX_TASKS) {
            System.out.println(Text.LIST_FULL);
            return;
        }
        tasks[listLength] = task;
        reportTaskAdded(task);
        listLength++;
    }

    public static void reportTaskAdded(Task t) {
        System.out.println("Ta-da! A new task has been conjured: ");
        System.out.println(t);
        System.out.println("Phew! A total of " + (listLength + 1) + " magical tasks awaits you!");
    }

    public static void printList() throws EmptyListException {
        if (listLength == 0) {
            throw new EmptyListException();
        } else {
            System.out.println(Text.PRINT_LIST);
            for (int i = 1; i < listLength + 1; i++) {
                Task t = tasks[i - 1];
                System.out.print(i + ".");
                System.out.println(t);
            }
        }
    }

    public static void markTask(String num) throws EmptyListException, MissingParamException {
        updateTaskStatus(num, true);
    }

    public static void unmarkTask(String num) throws EmptyListException, MissingParamException {
        updateTaskStatus(num, false);
    }

    private static void updateTaskStatus(String num, boolean isDone) throws EmptyListException, MissingParamException {
        if (listLength == 0) {
            throw new EmptyListException();
        }
        if (num.isEmpty()) {
            throw new MissingParamException();
        }
        try {
            int idx = Integer.parseInt(num);
            if (idx <= 0 || idx > listLength) {
                throw new NumberFormatException();
            }
            Task t = tasks[idx - 1];
            t.setDone(isDone);

            String actionText = isDone ? "conquered" : "come back stronger";
            System.out.print(isDone ? "Presto, you did it! " : "Tough luck! ");
            System.out.println("Task " + idx + " has " + actionText + "!");
            System.out.println(t);
        } catch (NumberFormatException e) {
            System.out.println(Text.INVALID_PARAM_MARK + num);
        }
    }

    public String convertToFile(){
        return " | " + (isDone ? "1" : "0") + " | " + description;
    }
}
