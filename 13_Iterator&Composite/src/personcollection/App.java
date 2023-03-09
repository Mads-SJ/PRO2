package personcollection;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("A");
        Person p2 = new Person("B");
        Person p3 = new Person("C");
        Person p4 = new Person("D");

        PersonCollection personCollection = new PersonCollection();
        personCollection.add(p1);
        personCollection.add(p2);
        personCollection.add(p3);
        personCollection.add(p4);

        for (Person p : personCollection) {
            System.out.println(p);
        }

        Iterator<Person> i = personCollection.iterator();
        while(i.hasNext()) {
            Person p = i.next();
//            personCollection.add(p);
            System.out.println(p);
        }
    }
}
