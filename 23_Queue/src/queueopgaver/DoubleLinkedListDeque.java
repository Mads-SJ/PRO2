package queueopgaver;

import java.util.NoSuchElementException;

public class DoubleLinkedListDeque implements DequeI {
    private Node head = new Node(null);
    private Node tail = new Node(null);
    private int size;

    public DoubleLinkedListDeque() {
        tail.next = head;
        head.prev = tail;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Object newElement) {
        Node node = new Node(newElement);
        if (tail.next == head) {
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
        if (tail.next == head) {
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
        if (tail.next == head) {
            throw new NoSuchElementException();
        }
        Object o = head.data;
        head = head.prev;
        size--;
        return o;
    }

    @Override
    public Object removeLast() {
        if (tail.next == head) {
            throw new NoSuchElementException();
        }
        Object o = tail.data;
        tail = tail.next;
        size--;
        return o;
    }

    @Override
    public Object getFirst() {
        return head.data;
    }

    @Override
    public Object getLast() {
        return tail.data;
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
