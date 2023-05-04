package opg3;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>> {
    private T name;

    public Person(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Person<T> o) {
        return name.compareTo(o.name);
    }
}
