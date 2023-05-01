package opg4;

public class CircularSingleLinkedList {
    private Node first;
    private int size;

    public void addPerson(Person p) {
        Node node = new Node(p);
        if (first == null) {
            node.next = node;
            first = node;
        } else {
            node.next = first.next;
            first.next = node;
        }
        size++;
    }

    public void print() {
        Node curr = first;
        for (int i = 0; i < size; i++) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public void randomStart() {
        Node curr = first;
        for (int i = 0; i < (int) (Math.random() * size); i++) {
            curr = curr.next;
        }
        first = curr;
    }

    public Person remove(int count) {
        Node curr = first;
        for (int i = 0; i < count - 1; i++) {
            curr = curr.next;
        }
        Person p = curr.next.data;
        curr.next = curr.next.next;
        first = curr.next;
        size--;
        return p;
    }

    class Node {
        public Person data;
        public Node next;

        public Node(Person data) {
            this.data = data;
        }
    }
}
