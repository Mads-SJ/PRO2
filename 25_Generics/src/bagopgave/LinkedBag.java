package bagopgave;

public class LinkedBag implements Bag {
    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(Object newEntry) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public boolean remove(Object anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(Object anEntry) {
        return 0;
    }

    @Override
    public boolean contains(Object anEntry) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    class Node {
        public Object data;
        public Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
