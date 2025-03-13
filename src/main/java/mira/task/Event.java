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

    @Override
    public String convertToFile(){
        return "E" + super.convertToFile() + " | " + from + " | " + to + "\n";
    }
}
