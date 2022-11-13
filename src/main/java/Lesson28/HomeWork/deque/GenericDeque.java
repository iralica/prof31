package Lesson28.HomeWork.deque;

import java.util.Iterator;

public interface GenericDeque <T> {
    void addFirst(T i); // ���������� � ������

    abstract T getFirst();
    int removeFirst() throws IndexOutOfBoundsException; // ��������� 1 �������� � ��������

    void addLast(T i); // ���������� � �����
    T getLast() throws IndexOutOfBoundsException; // ��������� ���������� �������� ��� ��������
  //  int removeLast() throws IndexOutOfBoundsException; // ��������� ���������� � ���������

    int size(); // ������� ����� ���������

    Iterator<T> iteratorBackwards();

    Iterator<T> getBackwardIterator();
}
