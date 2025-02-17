package mira.task;

import mira.exception.*;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public static void addDeadline(String command) throws MissingParamException {
        String[] parts = command.split(" /by ", 2);
        if (parts.length != 2) {
            throw new MissingParamException();
        } else {
            String description = parts[0];
            String by = parts[1];
            Task.addTask(new Deadline(description, by));
        }
    }
}
