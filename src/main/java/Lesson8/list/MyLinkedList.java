package Lesson8.list;

import Lesson7.list.MyList;

import java.util.Iterator;

//Дописать delete, iterator() и тесты
//* дописать remove в итераторе
//дописать методы void addFirst(int), void removeFirst(), int getFirst()
//                     добавляющие,         удаляющие и      получающие первый элемент в списке
public class MyLinkedList implements MyList {
    public static void main(String[] args) {
        // Node n = new MyLinkedList().new Node(); // внутренний не статический класс
        // Node n = new MyLinkedList.Node(); // внутренний статический класс
        MyLinkedList l = new MyLinkedList();
        System.out.println(l);
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
    }

    // Lists implementations. LinkedList.

    private Node head; // первый элемент списка

    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        Node n = head;
        b.append("[");
        while (n != null)
        {
            b.append(n.getValue());
            n = n.getNext();
            if(n != null)
            {
                b.append(", ");
            }
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public void add(int value) {
        // идти начиная с head до последнего (пока getNext() != null)
        if(head == null)
        {
            head = new Node(value);
            return;
        }
        Node n = head;
        while (n.getNext() != null)
        {
            n = n.getNext();
        }
        // потом добавить новый Node и сделать так, чтобы последний на новый ссылался
        n.setNext(new Node(value));
    }

    @Override
    public void set(int index, int value) {
        Node n = head;
        while (n != null)
        {
            if(index == 0) {
                n.setValue(value);
                return;
            }
            index--;
            n = n.getNext();
        }
    }

    @Override
    public void add(int index, int value) {
        Node n = head;
        Node one = null;
        Node two = null;

        while (n != null)
        {
            if(index == 1)
            {
                one = n;
                two = n.getNext();
                break;
            }
            index--;
            n = n.getNext();
        }
        if(one != null)
        {
            Node nw = new Node(value, two);
            one.setNext(
                    //new Node(value, two)
                    nw
            );
        }
    }

    @Override
    public boolean contains(int value) {
        Node n = head;
        while (n != null)
        {
            if(n.getValue() == value)
                return true;
            n = n.getNext();
        }
        return false;
    }

    @Override
    public int get(int index) {
        Node n = head;
        while (n != null)
        {
            if(index == 0)
                return n.getValue();
            index--;
            n = n.getNext();
        }
        return 0;
    }

    @Override
    public void remove(int index) { // delete
        // 0 - удаляем head
        // другие
        Node n = head;
        if(index == 0 && head != null)
        {
            head = n.getNext();
            return;
        }
        while (n != null) // не head
        {
            if(index == 1) // считаем до предыдущего элемента
            {
                Node toRemove = n.getNext();
                if(toRemove == null)
                    return;
                Node next = toRemove.getNext();
                n.setNext(next);
                return;
            }
            index--;
            n = n.getNext();
        }
    }

    @Override
    public int size() {
        int sz = 0; // size
        Node n = head;
        while (n != null)
        {
            sz++;
            n = n.getNext();
        }
        return sz;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private int position = -1;

            @Override
            public boolean hasNext() {
                // убедиться что следующая позиция после position лежить внутри size
                // после этой операции двинуть позицию вперед
                return position++ + 1 < size();
            }

            @Override
            public Integer next() {
                return get(position);
            }

            @Override
            public void remove() {
                MyLinkedList.this.remove(position--);
            }
        };
    }

    public int getFirst()
    {
        if (head == null) {
            throw new NullPointerException();
        }
        return head.getValue();
    }

    public void removeFirst()
    {
        if (head == null) {
            throw new NullPointerException();
        }
        if (head.getNext() == null) {
            head = null;
            return;
        }
        head = head.getNext();
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    @Override
    public void addFirst(int value)
    {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node n = new Node(value);
        n.setNext(head);
        head = n;
    }

    static class Node {
        private int value;
        private Node next = null;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
