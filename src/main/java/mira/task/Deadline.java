package mira.task;

/**
 * Represents tasks with a deadline.
 * A {@code Deadline} object is a task with a description and deadline.
 */
public class Deadline extends Task {

    protected String by;

    public Deadline(String description, boolean isDone, String by) {
        super(description);
        this.isDone = isDone;
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String convertToFile(){
        return "D" + super.convertToFile() + " | " + by + "\n";
    }
}
