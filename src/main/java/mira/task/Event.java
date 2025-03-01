package mira.task;

import mira.exception.*;

public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, boolean isDone, String from, String to) {
        super(description);
        this.isDone = isDone;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    public static void addEvent(String command) throws MissingParamException {
        String[] parts = command.split(" /from | /to ", 3);
        if (parts.length != 3) {
            throw new MissingParamException();
        } else {
            String description = parts[0];
            String from = parts[1];
            String to = parts[2];
            Task.addTask(new Event(description, false, from, to));
        }
    }

    @Override
    public String convertToFile(){
        return "E" + super.convertToFile() + " | " + from + " | " + to + "\n";
    }
}
