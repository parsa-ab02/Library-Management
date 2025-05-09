package datastructures.stacks;

import java.util.LinkedList;

public class CustomStack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T t) {
        if (t == null) throw new NullPointerException();
        list.addFirst(t);
    }

    public T pop() {
        if (list.isEmpty()) throw new java.util.NoSuchElementException();
        return list.removeFirst();
    }

    public T peek() {
        if (list.isEmpty()) throw new java.util.NoSuchElementException();
        return list.getFirst();
    }

    public boolean isEmpty() { return list.isEmpty(); }

    public int size() { return list.size(); }
}
