public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void setDone(boolean isDone){
        this.isDone = isDone;
    }

    public static void markTask(String num) {
        int idx = Integer.parseInt(num);
        Task t = Mira.tasks[idx - 1];
        t.setDone(true);
        System.out.println("Presto, you did it! Task " + idx + " has been conquered!");
        System.out.println(t);
    }

    public static void unmarkTask(String num) {
        int idx = Integer.parseInt(num);
        Task t = Mira.tasks[idx -1];
        t.setDone(false);
        System.out.println("Tough luck! Task " + idx + " has come back stronger!");
        System.out.println(t);
    }
}
