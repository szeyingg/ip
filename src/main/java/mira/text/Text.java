package mira.text;

public class Text {

    public static final String LINE = "____________________________________________________________";
    public static final String INTRO = """
                Greetings! I'm Mira, your enchanted task-keeper!
                What wonders would you like to accomplish today?""";
    public static final String BYE = "And... Poof! I'm off~ But don’t worry, I’m just a spell away!";
    public static final String COMMAND_LIST = """
            MIRA Book of Spells:
            1. bye
            2. list
            3. todo <description>
            4. deadline /by <deadline>
            5. event /from <start> /to <end>
            6. mark <list number>
            7. unmark <list number>""";

    public static final String PENDING_INPUT = """
    What spell would you like to cast?
    ━☆₊･""";
    public static final String HELP = "Use \"help\" if you wish to refer to your book of spells!";
    public static final String INVALID_COMMAND = "Oh no... That spell didnt work, try something else?";
    public static final String MISSING_PARAM = "So close! Seems like you are missing some key ingredients...";
    public static final String LIST_EMPTY = "Hmm, your list is empty... Use your powers to conjure a task!";
}
