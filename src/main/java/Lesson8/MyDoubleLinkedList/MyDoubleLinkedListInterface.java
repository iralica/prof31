package Lesson8.MyDoubleLinkedList;

import java.util.Iterator;

public interface MyDoubleLinkedListInterface extends Iterable<Integer>{
    int size ();
    void set(int index, int value);
    int get(int index);
    boolean isEmpty();
    int contains(int value);
    void add(int index, int value);
    void addFirst(int value);
    void addLast(int value);
    int getFirst();
    int getLast();
    void remove(int index);
    void removeFirst();
    void removeLast();

    Iterator<Integer> iterator();
}
