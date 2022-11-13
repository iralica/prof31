package Lesson28.HomeWork.LinkedList;

import java.util.Iterator;

public interface LinkedListGeneric<V> extends Iterable<V>{
    boolean isEmpty();

    void add(V value);

    void add(int index, V value);

    void set(int index, V value);

    boolean contains(V value);

    V get(int index);

    void remove(int index);

    int size();

    Iterator<V> iterator();

    void addFirst(V value);

    void removeFirst();

    V getFirst();
}
