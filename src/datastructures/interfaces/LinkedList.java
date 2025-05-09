package datastructures.interfaces;

public interface LinkedList<T> extends List{
    void addFirst(T t);
    void addLast(T t);
    boolean add(Object t);
    T removeFirst();
    T removeLast();
    T getFirst();
    T getLast();
    void clear();

    T set(int index, Object element);
}
