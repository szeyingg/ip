package mira.task;

import mira.exception.EmptyListException;
import mira.exception.MissingParamException;
import mira.text.Text;
import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;

    public static final int MAX_TASKS = 100;
    public static ArrayList<Task> tasks = new ArrayList<>();

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
        if (tasks.size() >= MAX_TASKS) {
            System.out.println(Text.LIST_FULL);
            return;
        }
        tasks.add(task);
        reportTaskAdded(task);
    }

    public static void reportTaskAdded(Task t) {
        System.out.println("Ta-da! A new task has been conjured: ");
        System.out.println(t);
        System.out.println(Text.LIST_SIZE_1 + (tasks.size()) + Text.LIST_SIZE_2);
    }

    public static void printList() throws EmptyListException {
        if (tasks.isEmpty()) {
            throw new EmptyListException();
        } else {
            System.out.println(Text.PRINT_LIST);
            for (int i = 1; i < tasks.size() + 1; i++) {
                Task t = tasks.get(i-1);
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
        if (tasks.isEmpty()) {
            throw new EmptyListException();
        }
        if (num.isEmpty()) {
            throw new MissingParamException();
        }
        try {
            int i = Integer.parseInt(num);
            if (i <= 0 || i > tasks.size()) {
                throw new NumberFormatException();
            }
            Task t = tasks.get(i - 1);
            t.setDone(isDone);

            String actionText = isDone ? "been conquered" : "come back stronger";
            System.out.print(isDone ? "Presto, you did it! " : "Tough luck! ");
            System.out.println("Task " + i + " has " + actionText + "!");
            System.out.println(t);
        } catch (NumberFormatException e) {
            System.out.println(Text.INVALID_PARAM_MARK + num);
        }
    }

    public static void deleteTask(String num) throws EmptyListException, MissingParamException {
        if (tasks.isEmpty()) {
            throw new EmptyListException();
        }
        if (num.isEmpty()) {
            throw new MissingParamException();
        }
        try {
            int i = Integer.parseInt(num) - 1;
            if (i < 0 || i >= tasks.size()) {
                throw new NumberFormatException();
            }
            reportTaskDeleted(tasks.get(i));
            tasks.remove(i);
        } catch (NumberFormatException e) {
            System.out.println(Text.INVALID_PARAM_MARK + num);
        }
    }

    public static void reportTaskDeleted(Task t) {
        System.out.println("And...Poof! The task vanishes into thin air: ");
        System.out.println(t);
        System.out.println(Text.LIST_SIZE_1 + (tasks.size()-1) + Text.LIST_SIZE_2);
    }

    public String convertToFile(){
        return " | " + (isDone ? "1" : "0") + " | " + description;
    }
}
