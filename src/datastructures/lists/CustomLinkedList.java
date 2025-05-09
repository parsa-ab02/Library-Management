package datastructures.lists;

import datastructures.interfaces.LinkedList;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next, prev;
        Node(T data) { this.data = data; }
    }
    private Node<T> head, tail;
    private int size = 0;
    @Override
    public void addFirst(T t) {
        if (t == null) throw new NullPointerException();
        Node<T> node = new Node<>(t);
        if (isEmpty()) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    @Override
    public void addLast(T t) {
        if (t == null) throw new NullPointerException();
        Node<T> node = new Node<>(t);
        if (isEmpty()) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        T val = head.data;
        if (head == tail) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return val;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        T val = tail.data;
        if (head == tail) head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return val;
    }
    @Override
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.data;
    }
    @Override
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return tail.data;
    }
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
    @Override
    public int size() { return size; }
    @Override
    public boolean isEmpty() { return size == 0; }
    @Override
    public boolean contains(Object o) {
        return false;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean add(Object t) {
        if (t == null) throw new NullPointerException();
        addLast((T) t);
        return true;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    @Override
    public T set(int index, Object element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T oldData = current.data;
        current.data = (T) element;
        return oldData;
    }

}
