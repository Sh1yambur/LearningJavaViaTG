package lesson_21_immutable.task_1;

public final class Car {
    private final String brand;
    private final String model;
    private final int yearOfProduced;
    private final int serialNumber;

    public Car(String brand, String model, int yearOfProduced, int serialNumber) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduced = yearOfProduced;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return String.format("Car {%s %s, %d, %d}", brand, model, yearOfProduced, serialNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        return yearOfProduced == car.yearOfProduced &&
                serialNumber == car.serialNumber &&
                brand.equals(car.brand) &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (brand == null ? 0 : brand.hashCode());
        result = 31 * result + (model == null ? 0 : model.hashCode());
        result = 31 * result + yearOfProduced;
        result = 31 * result + serialNumber;

        return result;
    }
}
