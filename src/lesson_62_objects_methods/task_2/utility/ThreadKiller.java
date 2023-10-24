package lesson_62_objects_methods.task_2.utility;

public class ThreadKiller {
    private boolean isAlive = true;

    public boolean isAlive() {
        return isAlive;
    }

    public void kill() {
        isAlive = false;
    }
}
