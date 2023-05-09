package opg3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonTest {
    public static void main(String[] args) {
        Navn n1 = new Navn("Mads", "Sønderstrup");
        Navn n2 = new Navn("Lasse", "Kjær");
        Navn n3 = new Navn("Emil", "Egelund");


        Person<String> p1 = new Person<>("Mads Sønderstrup-Jensen");
        Person<Navn> p2 = new Person<>(n1);
        Person<Navn> p3 = new Person<>(n2);
        Person<Navn> p4 = new Person<>(n3);

        ArrayList<Person<Navn>> personer = new ArrayList<>();
        personer.add(p2);
        personer.add(p3);
        personer.add(p4);

//        ArrayList<Person<String>> personer2 = new ArrayList<>();
//        personer2.add(p1);

        // print(personer2);

        print(personer);
        System.out.println();

        Collections.sort(personer);

        print(personer);
    }

    public static <T> void print(List<T> items) {
        for (T p : items) {
            System.out.println(p);
        }
    }
}