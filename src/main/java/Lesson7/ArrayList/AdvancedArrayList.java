package Lesson7.ArrayList;

import java.util.Iterator;

public interface AdvancedArrayList extends Iterable<Integer>{
    void set(int index, int value);
    int get(int index);
    int size();
    void append(int value);
    //void delete(int index);
    boolean contains(int value);
    void append(int [] array);
    void printAllElem();
    void remove (int index);
    void add(int value);
    void insert(int index);
    void insert(int index, int value);
    Iterator<Integer> iterator();
}
