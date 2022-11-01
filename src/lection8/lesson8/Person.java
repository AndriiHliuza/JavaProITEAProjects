package lection8.lesson8;

public class Person {
    private int age;
    private String name;

    private CloneTest.Car car;

    public Person(int age, String name, CloneTest.Car car) {
        this.age = age;
        this.name = name;
        this.car = car;
    }

    public Person(Person person) {
        this(person.age, person.name, new CloneTest.Car(person.car.color));
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest.Car car = new CloneTest.Car("Green");
        Person person = new Person( 25, "Mike", car);

        Person clone = new Person(person);

        System.out.println(person);
        System.out.println(clone);

        clone.name = "Ivan";
        clone.car.color = "red";

        System.out.println(person);
        System.out.println(clone);
    }
}
