package Lesson8.MyDoubleLinkedList;

// 4. **** Сделать DoubleLinkedList класс на базе MyLinkedList -
// добавить ссылку на предыдущий элемент в каждый
// DoubleLinkedNode (prev, next ссылки на предыдущий и следующий элементы)
// и добавить ссылку DoubleLinkedNode tail (на конечный элемент) в класс;
// добавить методы void addLast(int), void removeLast() и int getLast()
//                     добавляющие,        удаляющие и        получающие последний элемент в списке.


import java.util.Iterator;

public class MyDoubleLinkedList implements MyDoubleLinkedListInterface {
    private DoubleLinkedNode head;
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
        DoubleLinkedNode doubleLinkedNode = head;
        while (doubleLinkedNode != null) {
            if (index == 0) {
                doubleLinkedNode.setValue(value);
                return;
            }
            index--;
            doubleLinkedNode = doubleLinkedNode.getNext();
        }
    }

    @Override
    public int get(int index) {
        DoubleLinkedNode node = head;
        while (node != null) {
            if (index == 0) {
                return node.getData();
            }
            index--;
            node = node.getNext();
        }
        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int contains(int index) {
        DoubleLinkedNode node = head;
        while (node != null) {
            if (index == 0) {
                return node.getData();
            }
            index--;
            node = node.getNext();
        }
        return node.getData();
    }

    @Override
    public void add(int index, int position) {

    }

    @Override
    public void addFirst(int value) {
        if (head == null && tail == null) {
            head = new DoubleLinkedNode(value);
            tail = head;
            return;
        }
        if (size() == 1 /*&& head.equals(tail)*/) {
            head = new DoubleLinkedNode(value);
            tail.setPrev(head);
            head.setNext(tail);
            return;
        }
        DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode(value);
        head.prev = doubleLinkedNode;
        doubleLinkedNode.setNext(head);
        head = doubleLinkedNode;
    }

    @Override
    public void addLast(int value) {
// проверяем, есть ли вообще объекты в листе
        if (head == null && tail == null) {
            head = new DoubleLinkedNode(value);
            tail = head;
            return;
        }
        // определяем условия добавления 1-ого элемента
        if (size() == 1 /*&& head.equals(tail)*/) {
            tail = new DoubleLinkedNode(value);
            head.setNext(tail);
            tail.setPrev(head);
            return;
        }
        // определяем условия добавления 2-ого и последующих элементов
        DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode(value);
        tail.next = doubleLinkedNode;
        doubleLinkedNode.setPrev(tail);
        tail = doubleLinkedNode;
    }

    @Override
    public int getFirst() {
        return head.getData();
    }

    @Override
    public int getLast() {
        return tail.getData();
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
