package queueopgaver;

public class DequeDemo {
    public static void main(String[] args) {
        // DequeI dq = new DoubleLinkedListDeque();
        DequeI dq = new CircularArrayDeque();
        System.out.println(dq.size() + " " + dq.isEmpty());
        System.out.println();

        dq.addLast("A");
        dq.addLast("B");
        dq.addFirst("C");
        System.out.println(dq.size() + " " + dq.isEmpty());
        System.out.println(dq.getFirst());
        System.out.println();

        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.removeLast());
    }
}
