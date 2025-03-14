import java.util.Scanner;

import mira.parser.Parser;
import mira.save.Storage;
import mira.task.*;
import mira.ui.*;

/**
 * Main class for running of Mira program.
 * Deals with initialisation and user input.
 */
public class Mira {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Mira(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = storage.loadTasks();
    }

    public void run() {
        ui.showWelcome();
        Scanner input = new Scanner(System.in);

        while (true) {
            ui.showPendingInput();
            String in = input.nextLine();

            ui.showBufferLine();
            Parser.parseCommand(in, tasks, ui);
            storage.saveTasks(tasks);
            ui.showLine();
        }
    }

    public static void main(String[] args) {
        new Mira(Text.FILE_PATH).run();
    }
}
