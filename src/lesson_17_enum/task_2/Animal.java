package lesson_17_enum.task_2;

public enum Animal {
    DOG("woof"),
    CAT("meow"),
    COW("moo");

    private final String sound;

    Animal(String sound) {
        this.sound = sound;
    }

    public void say() {
        System.out.println(sound);
    }
}