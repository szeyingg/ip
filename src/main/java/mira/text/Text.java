package mira.text;

public class Text {

    public static final String LINE = "*......*......*......*......*......*......*......*......*......*";
    public static final String LINE_BUFFER = "  *------------------------------------------------------------*";

    public static final String INTRO = """
            Greetings! I'm Mira, your enchanted task-keeper!
            \\(='_'=)--*
            Looking forward to the wonders you would accomplish today!""";
    public static final String BYE = "Whoosh! I'm off~ But don't worry, I'm just a spell away!";

    public static final String PENDING_INPUT = """
            What spell would you like to cast?
            --*\040""";
    public static final String HELP = "Cast \"help\" if you wish to refer to your book of spells!";
    public static final String PRINT_LIST = "Abra-Cadabra! Here's your task list:";
    public static final String LIST_SIZE_1 =  "Phew! A total of ";
    public static final String LIST_SIZE_2 = " magical tasks awaits you!";

    public static final String COMMAND_LIST = """
            MIRA Book of Spells:
            1. list
               - displays list of tasks
            2. todo <description>
               - adds todo task to list
            3. deadline /by <deadline>
               - adds todo task to list
            4. event /from <start> /to <end>
               - adds todo task to list
            5. mark <list number>
               - marks task as done
            6. unmark <list number>
               - marks task as undone
            7. delete <list number>
               - deletes task from list
            8. bye
               - closes program""";

    //error messages
    public static final String INVALID_COMMAND = "Oh no... That spell didnt work, try something else?";
    public static final String MISSING_PARAM = "So close! Seems like you are missing some key ingredients...";
    public static final String LIST_EMPTY = "Hmm, your list is empty... Use your powers to conjure a task!";
    public static final String LIST_FULL = "Too many tasks! My powers have reached its limits...";
    public static final String INVALID_PARAM_MARK = "Zzzt! Can't seem to find task number: ";
}
