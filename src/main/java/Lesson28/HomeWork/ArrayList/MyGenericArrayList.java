package Lesson28.HomeWork.ArrayList;

import java.util.Iterator;

public interface MyGenericArrayList <V> extends Iterable<V> {
    void set(int index, V value);

    V get(int index);

    int size();

    void append(V value);

    void append(V[] a);

    void insert(int index, V value);
    //void insert(int index, int [] a);

    void add(V value);

    void remove(int index);
    //void delete(int index, int howMany);

    void insert(int index);

    boolean contains(V value);

    Iterator<V> iterator();
}
