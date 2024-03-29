package Lesson28.HomeWork.deque;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericArrayDeque <T> implements GenericDeque<T>{

    private T[] source;           // ������ � ����������
    private int size = 0;              // ������ ����������
    private int firstElementIndex = 0; // ����� ������� ������� ��� �������� ������� � ������

    private static final int CAPACITY = 4;

    public GenericArrayDeque() {
        source = (T[]) new Object[CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i < size; i++) {
            b.append(source[(firstElementIndex + i) % source.length]);
            if (i < size - 1)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public void addFirst(T value) {
        if (size == source.length) {
            increaseCapacity();
        }
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
        source[firstElementIndex] = value;
        size++;
    }



    private void increaseCapacity() {
        T[] newSource = (T[]) new Object[source.length * 2];
        int j = 0;  // ������ � ����� �������
        for (int i = firstElementIndex; i < source.length; i++) {
            newSource[j++] = source[i];
        }
        for (int i = 0; i < firstElementIndex; i++) {
            newSource[j++] = source[i];
        }
        firstElementIndex = 0;
        source = newSource;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return source[firstElementIndex];
    }

    @Override
    public int removeFirst() throws IndexOutOfBoundsException {
        return 0;
    }

   /* @Override
    public T removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        T element = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return element;
    }*/


    @Override
    public void addLast(T value) {
        if (size == source.length) {
            increaseCapacity();
        }
        source[(firstElementIndex + size) % source.length] = value;
        size++;
    }

    // My version addLast()
    // @Override
    public void addLastVer2(T value) {
        if (size == source.length) {
            increaseCapacity();
        }
        size++;
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        source[lastElementIndex] = value;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        return (T) source[lastElementIndex];
    }

   /* @Override
    public T removeLast() {
        // ������� �������� �������� �� ���������� �������,
        // ��������� �� ������� size
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int lastElementIndex = (size + firstElementIndex - 1) % source.length;
        T element = source[lastElementIndex];
        size--;
        return element;
    }*/

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iteratorBackwards() {
        return new Iterator<>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position++ < size();
            }

            @Override
            public T next() {
                return source[((size + firstElementIndex) % source.length) - position];
            }
        };
    }

    @Override
    public Iterator<T> getBackwardIterator() {
        return new Iterator<>() {
            private int position = size;

            @Override
            public boolean hasNext() {
                return --position >= 0;
            }

            @Override
            public T next() {
                if (position < 0 || position >= size) {
                    throw new NoSuchElementException();
                }
                return source[(firstElementIndex + position) % source.length];
            }
        };
    }

    public BackwardIterator getBigToSmall() {
        return new BackwardIterator();
    }

    private class BackwardIterator implements Iterator<T> {

        private T[] data = (T[]) new Object[size];
        private int position = size;

        public BackwardIterator() {
            for (int i = 0; i < size; i++) {
                data[i] = source[(firstElementIndex + i) % source.length];
            }
            Arrays.sort(data);
        }

        @Override
        public boolean hasNext() {
            return --position >= 0;
        }

        @Override
        public T next() {
            if (position < 0 || position >= size) {
                throw new NoSuchElementException();
            }
            return data[position];
        }
    }
}
