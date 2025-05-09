package datastructures.queues;

import datastructures.interfaces.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    @Override
    public boolean add(Object o) {
        if (o == null) throw new NullPointerException();
        list.addLast((T) o);
        return true;
    }

    @Override
    public boolean offer(T t) {
        if (t == null) return false;
        list.addLast(t);
        return true;
    }

    @Override
    public T remove() {
        if (list.isEmpty()) throw new NoSuchElementException();
        return list.removeFirst();
    }

    @Override
    public T poll() {
        return list.isEmpty() ? null : list.removeFirst();
    }

    @Override
    public T element() {
        if (list.isEmpty()) throw new NoSuchElementException();
        return list.getFirst();
    }

    @Override
    public T peek() {
        return list.isEmpty() ? null : list.getFirst();
    }

    @Override
    public boolean isEmpty() { return list.isEmpty(); }

    @Override
    public int size() { return list.size(); }
}
