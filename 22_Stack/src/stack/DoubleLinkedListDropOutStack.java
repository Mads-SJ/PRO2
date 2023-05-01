package stack;

import java.util.NoSuchElementException;

public class DoubleLinkedListDropOutStack {
    private Node top;
    private Node bottom;
    private int size;
    private int maxSize;

    public DoubleLinkedListDropOutStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(Object element) {
        if (size == maxSize) {
            removeLast();
        }
        Node n = new Node(element);
        if (top == null) {
            top = n;
            bottom = n;
        } else {
            n.next = top;
            top.previous = n;
            top = n;
        }
        size++;
    }

    public Object pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        Object o = top.data;
        top = top.next;
        if (top != null) {
            top.previous = null;
        } else {
            bottom = null;
        }
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

    public Object removeLast() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        if (top.next == null) {
            Object o = top.data;
            top = null;
            size--;
            return o;
        }
        Node n = top;
        while (n.next.next != null) {
            n = n.next;
        }
        Object o = n.next.data;
        n.next = null;
        size--;
        return o;
    }

    private class Node {
        public Object data;
        public Node next;
        public Node previous;

        public Node(Object data) {
            this.data = data;
        }
    }
}
