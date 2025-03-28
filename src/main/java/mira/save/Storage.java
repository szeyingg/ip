package mira.save;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import mira.task.*;
import mira.exception.*;
import mira.ui.Text;

/**
 * Deals with storage of task data in file
 * Contains methods to save, load, check, and convert task data
 */
public class Storage {
    public final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Checks if file exists in file path, creates new file otherwise
     */
    public void checkFile() {
        File f = new File(filePath);
        if (f.exists()) {
            return;
        }
        try {
            f.getParentFile().mkdirs();
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("FILE_CREATE_ERROR");
        }
    }

    /**
     * Loads tasks saved in text file.
     *
     * @return list of loaded tasks
     */
    public TaskList loadTasks() {
        checkFile();
        TaskList tasks = new TaskList();
        try {
            Scanner s = new Scanner(new File(filePath));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                convertToTask(line, tasks);
            }
        } catch (IOException e) {
            System.out.println("FILE_READ_ERROR");
        } catch (InvalidSaveException e) {
            System.out.println(Text.INVALID_SAVE_FORMAT);
        }
        return tasks;
    }

    /**
     * Converts line of text into {@code Task} objects
     *
     * @param line Text string saved in text file
     * @param tasks ArrayList for generated task to be stored in
     * @throws InvalidSaveException If saved text is not in expected format
     */
    private void convertToTask(String line, TaskList tasks) throws InvalidSaveException {
        String[] parts = line.split(" \\| ");

        if (parts.length < 3) {
            throw new InvalidSaveException();
        }
        String taskType = parts[0];
        String description = parts[2];

        boolean isDone = switch (parts[1]) {
            case "1" -> true;
            case "0" -> false;
            default -> throw new InvalidSaveException();
        };

        Task t;
        switch (taskType) {
            case "T":
                t = new Todo(description, isDone);
                break;

            case "D":
                if (parts.length != 4) {
                    throw new InvalidSaveException();
                }
                t = new Deadline(description, isDone, parts[3]);
                break;

            case "E":
                if (parts.length != 5) {
                    throw new InvalidSaveException();
                }
                t = new Event(description, isDone, parts[3], parts[4]);
                break;

            default:
                throw new InvalidSaveException();
        }
        tasks.addTask(t, true);
    }

    /**
     * Saves task list as a text file
     *
     * @param tasks ArrayList of tasks to be saved
     */
    public void saveTasks(TaskList tasks) {
        checkFile();
        try {
            FileWriter fw = new FileWriter(filePath, false);
            for (Task t : tasks.getTasks()) {
                fw.write(t.convertToFile());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("FILE_SAVE_ERROR");
        }
    }
}
