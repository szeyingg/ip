package mira.parser;

import mira.task.*;
import mira.exception.*;
import mira.ui.*;

public class Parser {
    public static void parseCommand(String input, TaskList tasks, Ui ui) {
        String[] command = input.split(" ", 2);
        String action = command[0];
        String param = (command.length > 1) ? command[1] : "";

        try {
            switch (action) {
                case "bye" -> ui.exit();
                case "list" -> tasks.printList();
                case "todo" -> addTodo(param, tasks);
                case "deadline" -> addDeadline(param, tasks);
                case "event" -> addEvent(param, tasks);
                case "mark" -> tasks.markTask(param);
                case "unmark" -> tasks.unmarkTask(param);
                case "help" -> System.out.println(Text.COMMAND_LIST);
                case "delete" -> tasks.deleteTask(param);
                default -> throw new InvalidCommandException();
            }
        } catch (MissingParamException e) {
            System.out.println(Text.MISSING_PARAM + "\n" + Text.HELP);
        } catch (InvalidCommandException e) {
            System.out.println(Text.INVALID_COMMAND + "\n" + Text.HELP);
        } catch (EmptyListException e) {
            System.out.println(Text.LIST_EMPTY);
        }
    }

    public static void addTodo(String command, TaskList tasks) throws MissingParamException{
        if (command.isEmpty()) {
            throw new MissingParamException();
        }
        tasks.addTask(new Todo(command, false), false);
    }

    public static void addDeadline(String command, TaskList tasks) throws MissingParamException {
        String[] parts = command.split(" /by ", 2);
        if (parts.length != 2) {
            throw new MissingParamException();
        } else {
            String description = parts[0];
            String by = parts[1];
            tasks.addTask(new Deadline(description, false, by), false);
        }
    }

    public static void addEvent(String command, TaskList tasks) throws MissingParamException {
        String[] parts = command.split(" /from | /to ", 3);
        if (parts.length != 3) {
            throw new MissingParamException();
        } else {
            String description = parts[0];
            String from = parts[1];
            String to = parts[2];
            tasks.addTask(new Event(description, false, from, to), false);
        }
    }
}
