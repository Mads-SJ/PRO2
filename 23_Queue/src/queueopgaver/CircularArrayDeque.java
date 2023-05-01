package queueopgaver;

import java.util.NoSuchElementException;

public class CircularArrayDeque implements DequeI {
    private int head;
    private int tail;
    private int size = 0;
    private Object[] queue = new Object[10];

    public CircularArrayDeque() {
        head = 0;
        tail = 1;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Object newElement) {
        if (size == queue.length) {
            grow();
        }
        if ((size > 0)) {
            int index = (head - 1);
            if (index < 0) {
                head = queue.length + index;
            } else {
                head = index;
            }
        }
        queue[head] = newElement;
        size++;
    }

    @Override
    public void addLast(Object newElement) {
        if (size == queue.length) {
            grow();
        }
        if (size > 0) {
            tail = (tail + 1) % queue.length;
        }
        queue[tail] = newElement;
        size++;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object o = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        size--;
        return o;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object o = queue[tail];
        queue[tail] = null;
        int index = (tail - 1);
        if (index < 0) {
            tail = queue.length + index;
        } else {
            tail = index;
        }
        size--;
        return o;
    }

    @Override
    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[head];
    }

    @Override
    public Object getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[tail];
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        Object[] newQueue = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }
}
