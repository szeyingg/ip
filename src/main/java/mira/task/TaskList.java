package mira.task;

import mira.exception.EmptyListException;
import mira.exception.MissingParamException;
import mira.ui.Text;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;
    public static final int MAX_TASKS = 100;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task, boolean isFromStorage) {
        if (tasks.size() >= MAX_TASKS) {
            System.out.println(Text.LIST_FULL);
            return;
        }
        tasks.add(task);

        if (!isFromStorage) {
            reportTaskAdded(task);
        }
    }

    public void reportTaskAdded(Task t) {
        System.out.println("Ta-da! A new task has been conjured: ");
        System.out.println(t);
        System.out.println(Text.LIST_SIZE_1 + (tasks.size()) + Text.LIST_SIZE_2);
    }

    public void printList() throws EmptyListException {
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

    public void markTask(String num) throws EmptyListException, MissingParamException {
        updateTaskStatus(num, true);
    }

    public void unmarkTask(String num) throws EmptyListException, MissingParamException {
        updateTaskStatus(num, false);
    }

    private void updateTaskStatus(String num, boolean isDone) throws EmptyListException, MissingParamException {
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

    public void deleteTask(String num) throws EmptyListException, MissingParamException {
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

    public void reportTaskDeleted(Task t) {
        System.out.println("And...Poof! The task vanishes into thin air: ");
        System.out.println(t);
        System.out.println(Text.LIST_SIZE_1 + (tasks.size()-1) + Text.LIST_SIZE_2);
    }
}
