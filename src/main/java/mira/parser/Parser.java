package mira.parser;

import mira.task.*;
import mira.exception.*;
import mira.ui.*;

/**
 * Parses user input to execute respective commands
 */
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

    /**
     * Adds {@code Todo} object to task list
     *
     * @param param Input string that corresponds to description of task
     * @param tasks ArrayList of tasks
     * @throws MissingParamException If input is missing description
     */
    public static void addTodo(String param, TaskList tasks) throws MissingParamException{
        if (param.isEmpty()) {
            throw new MissingParamException();
        }
        tasks.addTask(new Todo(param, false), false);
    }

    /**
     * Adds {@code Deadline} object to task list.
     *
     * @param param Input string consisting of description and deadline of task
     * @param tasks ArrayList of tasks
     * @throws MissingParamException If input is missing description or deadline
     */
    public static void addDeadline(String param, TaskList tasks) throws MissingParamException {
        String[] parts = param.split(" /by ", 2);
        if (parts.length != 2) {
            throw new MissingParamException();
        } else {
            String description = parts[0];
            String by = parts[1];
            tasks.addTask(new Deadline(description, false, by), false);
        }
    }

    /**
     * Adds {@code Event} object to task list.
     *
     * @param param Input string consisting of description, start and end of event
     * @param tasks ArrayList of tasks
     * @throws MissingParamException If input is missing description, start, or end
     */
    public static void addEvent(String param, TaskList tasks) throws MissingParamException {
        String[] parts = param.split(" /from | /to ", 3);
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
