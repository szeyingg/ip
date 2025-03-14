package mira.ui;

import mira.task.Task;

import java.util.ArrayList;

/**
 * Deals with user interactions
 * Contains methods to print appropriate outputs
 */
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

    /**
     * Reports addition of task and updated list size
     *
     * @param t {@code Task} object to be added
     * @param tasks ArrayList of tasks
     */
    public void reportTaskAdded(Task t, ArrayList<Task> tasks) {
        System.out.println("Ta-da! A new task has been conjured: ");
        System.out.println(t);
        System.out.println(Text.LIST_SIZE_1 + (tasks.size()) + Text.LIST_SIZE_2);
    }

    /**
     * Reports deletion of task and updated list size
     *
     * @param t {@code Task} object to be deleted
     * @param tasks ArrayList of tasks
     */
    public void reportTaskDeleted(Task t, ArrayList<Task> tasks) {
        System.out.println("And...Poof! The task vanishes into thin air: ");
        System.out.println(t);
        System.out.println(Text.LIST_SIZE_1 + (tasks.size()-1) + Text.LIST_SIZE_2);
    }
}
