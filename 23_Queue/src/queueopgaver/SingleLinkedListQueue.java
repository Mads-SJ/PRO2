package queueopgaver;

import java.util.NoSuchElementException;

public class SingleLinkedListQueue implements QueueI {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object newElement) {
        Node node = new Node(newElement);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    @Override
    public Object dequeue() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node node = head;
        head = node.next;
        size--;
        return node.data;
    }

    @Override
    public Object getFront() {
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    class Node {
        public Object data;
        public Node next;
        public Node(Object element) {
            data = element;
        }
    }
}
