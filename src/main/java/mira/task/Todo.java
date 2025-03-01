package mira.task;
import mira.exception.*;

public class Todo extends Task {

    public Todo(String description, boolean isDone) {
        super(description);
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public static void addTodo(String command) throws MissingParamException{
        if (command.isEmpty()) {
            throw new MissingParamException();
        }
        Task.addTask(new Todo(command, false));
    }

    @Override
    public String convertToFile(){
        return "T" + super.convertToFile() + "\n";
    }
}
