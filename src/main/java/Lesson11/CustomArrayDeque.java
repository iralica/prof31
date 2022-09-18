package Lesson11;


import java.util.Iterator;

public class CustomArrayDeque implements CustomeDeque {

    private int[] source;              // массив с содержимым
    private int size = 0;              // размер контейнера
    private int firstElementIndex = 0; // чтобы быстрее удалить или добавить элемент в начало

    private static final int CAPACITY = 4;

    public CustomArrayDeque() {
        source = new int[CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder  b = new StringBuilder();
        b.append("[");
        for(int i = 0; i < size; i++)
        {
            b.append(source[(firstElementIndex + i)% source.length]);
            if(i < size - 1)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
//        return Arrays.toString(source);
    }


    @Override
    public void addFirst(int value) {
        if (size == source.length) {
            // делаем новый массив в 2 раза больше и копируем элементы из старого в начало нового
            increaseCapacity();
        }
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
//        if(firstElementIndex == 0)
//            firstElementIndex = source.length - 1;
//        else
//            firstElementIndex = firstElementIndex - 1;

        source[firstElementIndex] = value;
        size++;
    }

    private void increaseCapacity() {
        int[] newSource = new int[source.length * 2];
        int j = 0;  // индекс в новом массиве
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
    public int getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return source[firstElementIndex];
    }

    @Override
    public int removeFirst() {
        // вернуть элемент по firstElementIndex и
        // увеличить на единицу firstElementIndex
        // уменьшить на единицу size
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int element = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return element;
    }

    @Override
    public void addLast(int value) {
        if (size == source.length) {
            // делаем новый массив в 2 раза больше и копируем элементы из старого в начало нового
            increaseCapacity();
           // source[(firstElementIndex + size) % source.length];
        }

    }

    @Override
    public int getLast() throws IndexOutOfBoundsException {
        return 0;
    }

    // @Override
    //public int getLast() {
       // if (size == 0) {
          //  throw new IndexOutOfBoundsException();
          //  return source[(size -1 + firstElementIndex)];
        //}

   // }

    @Override
    public int removeLast() {
        if(size == 0)
            throw new IndexOutOfBoundsException();
        int r = source[(size - 1 + firstElementIndex) % source.length];
        size--;
        return r;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Integer> descendingIterator() {
        int[] newSource = new int[source.length * 2];
        for (int i = size; i >=0 ; i--) {
            newSource[i] = source[i];
        }
        source = newSource;

        return null;
    }

}
