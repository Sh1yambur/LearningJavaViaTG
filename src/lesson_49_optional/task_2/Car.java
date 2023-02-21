package lesson_49_optional.task_2;

public class Car {
    //    Уникальным идентификатором будет объект immutable класса CarIdentifier
    private final CarIdentifier identifier;

    private String color;
    private boolean actualTechnicalInspection;
    private Person owner;

    public Car(String number, int year, String color, boolean actualTechnicalInspection, Person owner) {
        this(new CarIdentifier(number, year), color, actualTechnicalInspection, owner);
    }

    public Car(CarIdentifier identifier, String color, boolean actualTechnicalInspection, Person owner) {
        this.identifier = identifier;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;
        this.owner = owner;
    }

    public CarIdentifier getIdentifier() {
        return identifier;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActualTechnicalInspection() {
        return actualTechnicalInspection;
    }

    public void setActualTechnicalInspection(boolean actualTechnicalInspection) {
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
//        Метод formatted() у String позволяет создать строку с использованием спецификаторов
//        (как в System.out.printf()). До Java 15 вместо него использовался статический метод String.format().
//        Здесь он использован для большей наглядности кода, менее красиво, но с тем же успехом,
//        можно было обойтись обычной конкатенацией строк
        return """
                number: %s
                year: %d
                color: %s
                actualTechnicalInspection: %s
                owner: %s
                """.formatted(
                identifier.getNumber(), identifier.getYear(), color,
                actualTechnicalInspection ? "actual" : "not actual",
                owner.getName());
    }
}
