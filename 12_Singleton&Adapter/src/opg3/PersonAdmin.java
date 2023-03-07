package opg3;

import java.util.HashSet;
import java.util.Set;

public class PersonAdmin {
    private Set<Person> personer = new HashSet<>();
    private static PersonAdmin instance;

    private PersonAdmin() {}

    public void addPerson(Person person) {
        personer.add(person);
    }

    public static PersonAdmin getInstance() {
        if (instance == null) {
            instance = new PersonAdmin();
        }
        return instance;
    }

    public Set<Person> getPersoner() {
        return new HashSet<>(personer);
    }

    public void removePerson(Person person) {
        personer.remove(person);
    }
}
