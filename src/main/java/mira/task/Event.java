package mira.task;

import mira.text.Text;

public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    public static void addEvent(String command) {
    String[] parts = command.split(" /from | /to ", 3);
        if (parts.length != 3) {
        System.out.println(Text.MISSING_PARAM + "\n" + Text.HELP);
    } else {
        String description = parts[0];
        String from = parts[1];
        String to = parts[2];
        Task.addTask(new Event(description, from, to));
        }
    }
}
