package opg4;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jytte", 60);
        Person p2 = new Person("Bent", 75);
        Person p3 = new Person("Ib", 120);
        Person p4 = new Person("Jens", 80);
        Person p5 = new Person("Hans", 90);
        Person p6 = new Person("Jørgen", 95);

        CircularSingleLinkedList list = new CircularSingleLinkedList();
        list.addPerson(p1);
        list.addPerson(p2);
        list.addPerson(p3);
        list.addPerson(p4);
        list.addPerson(p5);
        list.addPerson(p6);

        list.print();
        System.out.println();

        System.out.println(list.remove(3));
        System.out.println();

        list.print();

        list.randomStart();
        System.out.println();

        list.print();
        System.out.println();

        System.out.println(list.remove(5));
    }
}
