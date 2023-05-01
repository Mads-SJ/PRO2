package stack;

import java.util.ArrayList;

public class ArrayListStack implements StackI {
    private final ArrayList<Object> list = new ArrayList<>();
    @Override
    public void push(Object element) {
        list.add(element);
    }

    @Override
    public Object pop() {
        if (list.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public Object peek() {
        if (list.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
