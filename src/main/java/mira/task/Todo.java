package mira.task;

/**
 * Represents to-do tasks.
 * A {@code Todo} object is a task with a description.
 */
public class Todo extends Task {

    public Todo(String description, boolean isDone) {
        super(description);
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String convertToFile(){
        return "T" + super.convertToFile() + "\n";
    }
}
