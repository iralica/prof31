package Lesson8.MyDoubleLinkedList;

// 4. **** Сделать DoubleLinkedList класс на базе MyLinkedList -
// добавить ссылку на предыдущий элемент в каждый
// DoubleLinkedNode (prev, next ссылки на предыдущий и следующий элементы)
// и добавить ссылку DoubleLinkedNode tail (на конечный элемент) в класс;
// добавить методы void addLast(int), void removeLast() и int getLast()
// добавляющие, удаляющие и получающие последний элемент в списке.


import java.util.Iterator;

public class MyDoubleLinkedList implements MyDoubleLinkedListInterface {
    private static DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    static class DoubleLinkedNode {
        private int data;
        private DoubleLinkedNode next;
        private DoubleLinkedNode prev;

        public DoubleLinkedNode(int data) {
            this.data = data;
        }

        public DoubleLinkedNode(int data, DoubleLinkedNode next, DoubleLinkedNode prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public int getData() {
            return data;
        }

        public void setValue(int data) {
            this.data = data;
        }

        public DoubleLinkedNode getNext() {
            return next;
        }

        public void setNext(DoubleLinkedNode next) {
            this.next = next;
        }

        public DoubleLinkedNode getPrev() {
            return prev;
        }

        public void setPrev(DoubleLinkedNode prev) {
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
         String toString; {
            StringBuilder resPrint = new StringBuilder();
            DoubleLinkedNode node = head;
            resPrint.append("[");
            while (node != null) {
                resPrint.append(node.getData());
                node = node.getNext();
                if (node != null) {
                    resPrint.append(", ");
                }
            }
            resPrint.append("]");
            return resPrint.toString();
        }
    }

    @Override
    public int size() {
        int size = 0;
        DoubleLinkedNode node = head;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    @Override
    public void set(int index, int value) {

    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public void add(int index, int value) {

    }

    @Override
    public void addFirst(int value) {

    }

    @Override
    public void addLast(int value) {

    }

    @Override
    public int getFirst() {
        return 0;
    }

    @Override
    public int getLast() {
        return 0;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
