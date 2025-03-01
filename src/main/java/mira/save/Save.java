package mira.save;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import mira.task.*;
import mira.exception.*;

public class Save {
    public static final String FILE_PATH = "./data/MiraTasks.txt";

    public static void checkFile() {
        File f = new File(FILE_PATH);
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

    public static void loadTasks() throws  InvalidSaveException {
        checkFile();
        try {
            Scanner s = new Scanner(new File(FILE_PATH));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                convertToTask(line);
            }
        } catch (IOException e) {
            System.out.println("FILE_READ_ERROR");
        }
    }

    public static void convertToTask(String line) throws InvalidSaveException {
        String[] parts = line.split("\\| ");
        String taskType = parts[0];
        String isDone = parts[1];
        String description = parts[2];

        if (isDone.isEmpty() || description.isEmpty()) {
            throw new InvalidSaveException();
        }

        switch (taskType) {
            case "T":
                new Todo(description);
                break;

            case "D":
                if (parts.length != 4) {
                    throw new InvalidSaveException();
                }
                new Deadline(description, parts[3]);
                break;

            case "E":
                if (parts.length != 5) {
                    throw new InvalidSaveException();
                }
                new Event(description, parts[3], parts[4]);
                break;

            default:
                throw new InvalidSaveException();
        }
    }

    public static void saveTasks(Task[] tasks) {
        checkFile();
        try {
            FileWriter fw = new FileWriter(FILE_PATH, false);
            for (Task t : tasks) {
                fw.write(t.convertToFile());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("FILE_SAVE_ERROR");
        }
    }
}
