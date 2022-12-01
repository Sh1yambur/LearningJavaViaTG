package lesson_13_inheritance.task_2;

public class Animal {
    private final String type;
    private String sound;

    public Animal() {
        this.type = "animal";
    }

    protected Animal(String type, String sound) {
        this.type = type;
        this.sound = sound;
    }

    public String getType() {
        return type;
    }

    protected void say() {
        System.out.println(sound);
    }
}