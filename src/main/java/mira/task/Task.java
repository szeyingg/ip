package mira.task;

import mira.exception.EmptyListException;
import mira.exception.MissingParamException;
import mira.ui.Text;
import java.util.ArrayList;

/**
 * Parent class of all {@code Task} objects
 */
public class Task {
    protected String description;
    protected boolean isDone;

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

    public String convertToFile(){
        return " | " + (isDone ? "1" : "0") + " | " + description;
    }
}
