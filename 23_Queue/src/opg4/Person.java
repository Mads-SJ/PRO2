package opg4;

public class Person {
    private String name;

    private int weight;

    public Person(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + ", " + weight + "kg";
    }
}
