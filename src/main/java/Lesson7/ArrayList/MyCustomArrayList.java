package Lesson7.ArrayList;

import java.util.Iterator;

public class MyCustomArrayList implements AdvancedArrayList {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size = 0; // "видимый" для пользователя размер массива

    public MyCustomArrayList() {
        data = new int[INITIAL_CAPACITY];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    public int size() {
        return size;
    }

    public void append(int value) {
        if (size == data.length)
            increaseCapacity();
        data[size++] = value;
    }

    public void append(int[] a) {
        for (int i = 0; i < a.length; i++) {
            append(a[i]);
        }
    }

    private void increaseCapacity() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void printArray() {
    }

    public void remove(int i) {
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size();
            }

            @Override
            public Integer next() {
                if (position < size()) {
                    return get(position++);
                } else return null;
            }

            @Override
            public void remove() {
                MyCustomArrayList.this.remove(position);
            }
        };
    }
}
