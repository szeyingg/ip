package mira.task;
import mira.exception.*;
import mira.text.*;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public static void addTodo(String command) throws MissingParamException{
        if (command.isEmpty()) {
            throw new MissingParamException();
        }
        Task.addTask(new Todo(command));
    }

    @Override
    public String convertToFile(){
        return "T" + super.convertToFile();
    }
}
