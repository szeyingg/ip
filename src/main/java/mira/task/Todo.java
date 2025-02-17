package mira.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public static void addTodo(String command) {
        Task.addTask(new Todo(command));
    }
}
