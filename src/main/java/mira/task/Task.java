package mira.task;

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

    public void setDone(boolean isDone){
        this.isDone = isDone;
    }

    public static void addTask(Task task){
        if (listLength >= MAX_TASKS) {
            System.out.println("Oops! Task list is full.");
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
}
