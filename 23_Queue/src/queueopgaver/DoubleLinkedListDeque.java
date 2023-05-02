package queueopgaver;

import java.util.NoSuchElementException;

public class DoubleLinkedListDeque implements DequeI {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedListDeque() {
        head = new Node(null);
        tail = new Node(null);
        tail.next = head;
        head.prev = tail;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Object newElement) {
        Node node = new Node(newElement);
        if (isEmpty()) {
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
        } else {
            node.next = head;
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;
        }
        size++;
    }

    @Override
    public void addLast(Object newElement) {
        Node node = new Node(newElement);
        if (isEmpty()) {
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
        } else {
            node.prev = tail;
            node.next = tail.next;
            tail.next.prev = node;
            tail.next = node;
        }
        size++;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) { throw new NoSuchElementException(); }

        Object o = head.prev.data;
        head = head.prev;
        size--;
        return o;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) { throw new NoSuchElementException(); }

        Object o = tail.next.data;
        tail = tail.next;
        size--;
        return o;
    }

    @Override
    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.prev.data;
    }

    @Override
    public Object getLast() {
        if (isEmpty()) { throw new NoSuchElementException(); }

        return tail.next.data;
    }

    @Override
    public int size() {
        return size;
    }

    class Node {
        public Object data;
        public Node next;
        public Node prev;
        public Node(Object element) {
            data = element;
        }
    }
}
