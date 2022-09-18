package Lesson11;

import java.util.Iterator;

public interface CustomeDeque {

    void addFirst(int i);                                 // добавление в начало

    int getFirst() throws IndexOutOfBoundsException;      // запрос первого элемента без удаления

    int removeFirst() throws IndexOutOfBoundsException;   // получение первого элемента и его последующее удаление

    void addLast(int i);                                  // добавление в конец

    int getLast() throws IndexOutOfBoundsException;       // получить последний элемент в очереди без удаления

    int removeLast() throws IndexOutOfBoundsException;    // получить последний элемент с его последующим удалением

    int size();                                          // кол-во элементов в массиве - размер массива для пользователя

    Iterator<Integer> descendingIterator();
}

