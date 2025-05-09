package datastructures.interfaces;

public interface List<T> extends Collection {
    boolean add(Object t);
    T get(int index);
    T set(int index, T element);
}
