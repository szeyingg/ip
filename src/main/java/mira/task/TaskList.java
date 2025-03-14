package mira.task;

import mira.exception.EmptyListException;
import mira.exception.MissingParamException;
import mira.ui.*;

import java.util.ArrayList;

/**
 * Represents list of tasks.
 * Contains methods to add, delete, print, mark or unmark tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks;
    private Ui ui;
    public static final int MAX_TASKS = 100;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds task to task list, reports the addition if task is added manually.
     *
     * @param task {@code Task} object to be added to list
     * @param isFromStorage Boolean to indicate if task is added automatically from storage
     */
    public void addTask(Task task, boolean isFromStorage) {
        if (tasks.size() >= MAX_TASKS) {
            System.out.println(Text.LIST_FULL);
            return;
        }
        tasks.add(task);

        if (!isFromStorage) {
            ui.reportTaskAdded(task, tasks);
        }
    }

    /**
     * Prints full task list with indices.
     *
     * @throws EmptyListException If task list is empty
     */
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

    /**
     * Marks task as done or undone.
     *
     * @param num Input string with index of task to be updated
     * @param isDone Boolean to indicate status of task to set to
     * @throws EmptyListException If task list is empty
     * @throws MissingParamException If input number is missing
     * @throws NumberFormatException If input is not a valid number
     */
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

    /**
     * Deletes task from task list.
     *
     * @param num Input string with index of task to be deleted
     * @throws EmptyListException If task list is empty
     * @throws MissingParamException If input number is missing
     * @throws NumberFormatException If input is not a valid number
     */
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
            ui.reportTaskDeleted(tasks.get(i), tasks);
            tasks.remove(i);
        } catch (NumberFormatException e) {
            System.out.println(Text.INVALID_PARAM_MARK + num);
        }
    }

    public void findTask(String keyword) {
        ArrayList<Task> foundTasks = new ArrayList<>();
        ArrayList<Integer> foundIndices = new ArrayList<>();

        for (int i = 1; i < tasks.size() + 1; i++) {
            if (tasks.get(i-1).description.contains(keyword)) {
                foundTasks.add(tasks.get(i-1));
                foundIndices.add(i);
            }
        }

        if (foundTasks.isEmpty()) {
            System.out.println(Text.SEARCH_NOT_FOUND);
        } else {
            System.out.println(Text.SEARCH_FOUND);
            for (int i = 1; i < foundTasks.size() + 1; i++) {
                System.out.print(foundIndices.get(i-1) + ". ");
                Task t = foundTasks.get(i-1);
                System.out.println(t);
            }
        }
    }
}
