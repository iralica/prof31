package Lesson28.HomeWork.deque;

import java.util.Iterator;

public interface GenericDeque <T> {
    void addFirst(T i); // добавление в начало

    abstract T getFirst();
    int removeFirst() throws IndexOutOfBoundsException; // получение 1 элемента и удаление

    void addLast(T i); // добавление в конец
    T getLast() throws IndexOutOfBoundsException; // получение последнего элемента без удаления
  //  int removeLast() throws IndexOutOfBoundsException; // получение последнего с удалением

    int size(); // сколько всего элементов

    Iterator<T> iteratorBackwards();

    Iterator<T> getBackwardIterator();
}
