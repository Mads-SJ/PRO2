package stack;

public class ArrayDropOutStack {
    private final Object[] array;
    private int top;
    private final int maxSize;

    public ArrayDropOutStack(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
    }

    public void push(Object element) {
        if (top == maxSize) {
            removeLast();
        }
        array[top++] = element;
    }

    public Object pop() {
        if (top == 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[--top];
    }

    public Object peek() {
        if (top == 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public boolean removeLast() {
        if (top == 0) {
            return false;
        }
        for (int i = 0; i < top - 1; i++) {
            array[i] = array[i + 1];
        }
        top--;
        return true;
    }
}
