package stack;

import java.util.NoSuchElementException;

public class SingleLinkedListDropOutStack {
    private Node top;
    private int size;
    private final int maxSize;

    public SingleLinkedListDropOutStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(Object element) {
        if (size == maxSize) {
            removeLast();
        }
        Node n = new Node(element);
        n.next = top;
        top = n;
        size++;
    }

    public Object pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        Object o = top.data;
        top = top.next;
        size--;
        return o;
    }

    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public boolean removeLast() {
        if (top == null) {
            return false;
        } else if (top.next == null) {
            top = null;
        } else {
            Node temp = top;
            Node prev = null;
            while(temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }
        return true;
    }

    private class Node {
        public Object data;
        public Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
