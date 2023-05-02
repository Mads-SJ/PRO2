package queueopgaver;

import java.util.NoSuchElementException;

public class CircularArrayDeque implements DequeI {
    private int first;
    private int last;
    private int size = 0;
    private Object[] elements = new Object[10];

    public CircularArrayDeque() {
        first = 0;
        last = 1;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Object newElement) {
        if (size == elements.length) {
            grow();
        }
        if (!isEmpty()) {
            if (first == 0) {
                first = elements.length - 1;
            } else {
                first--;
            }
        }
        elements[first] = newElement;
        size++;
    }

    @Override
    public void addLast(Object newElement) {
        if (size == elements.length) {
            grow();
        }
        if (!isEmpty()) {
            last = (last + 1) % elements.length;
        }
        elements[last] = newElement;
        size++;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object removedElement = elements[first];
        elements[first] = null;
        first = (first + 1) % elements.length;
        size--;
        return removedElement;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object removedElement = elements[last];
        elements[last] = null;
        if (last == 0) {
            last = elements.length - 1;
        } else {
            last--;
        }
        size--;
        return removedElement;
    }

    @Override
    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[first];
    }

    @Override
    public Object getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[last];
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        Object[] newQueue = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = elements[i];
        }
        elements = newQueue;
    }
}
