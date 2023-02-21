package lesson_49_optional.task_2;

public class Person {
    private final String name;
    private final Person mother;
    private final Person father;
    private Person[] children;
    private Residence residence;
    private Car car;
    private String profession;

    public Person(String name, Person mother, Person father) {
        this.name = name;
        this.mother = mother;
        this.father = father;
    }

    public void setChildren(Person... children) {
        this.children = children;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person[] getChildren() {
        return children;
    }

    public Residence getResidence() {
        return residence;
    }

    public Car getCar() {
        return car;
    }

    public String getProfession() {
        return profession;
    }
}
