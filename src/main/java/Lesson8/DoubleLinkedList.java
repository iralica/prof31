package Lesson8;

import Lesson7.list.MyList;
import org.w3c.dom.Node;

import java.util.Iterator;

public class DoubleLinkedList implements MyList {
    private DoubleLinkedNode head = null;
    private DoubleLinkedNode tail = null;
    private int size = 0;

    @Override
    public void add(int value) {
        if(tail == null) // нет ни одного элемента
        {
            DoubleLinkedNode node = new DoubleLinkedNode(value);
            // head = tail = node;
            head = node;
            tail = node;
        }
        else {
            DoubleLinkedNode node = new DoubleLinkedNode(value, tail, null);
//            tail.next = node;
            tail = node;
        }
        size++;
    }
    @Override
    public boolean isEmpty() {
        return (head == null);
    }
    @Override
    public void set(int index, int value) {
        DoubleLinkedNode node = getNodeByIndex(index);
        if(node != null)
            node.value = value;
    }

    @Override
    public void add(int index, int value) {
        if(size() == 0 && index == 0)
        {
            add(value);
            return;
        }
        if(index == 0)
        {
            DoubleLinkedNode newNode = new DoubleLinkedNode(value, null, head);
            head = newNode;
        }
        else if(index == size())
        {
            DoubleLinkedNode newNode = new DoubleLinkedNode(value, tail, null);
            tail = newNode;
        }
        else {
            DoubleLinkedNode node = getNodeByIndex(index);
            DoubleLinkedNode prev = node.prev;
            new DoubleLinkedNode(value, prev, node);
        }
        size++;
    }

    @Override
    public boolean contains(int value) {
        DoubleLinkedNode node = head;
        while (node != null)
        {
            if(node.value == value)
                return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public int get(int index) {
        DoubleLinkedNode node = getNodeByIndex(index);
        return node != null ? node.value : 0;
    }

    private DoubleLinkedNode getNodeByIndex(int index)
    {
        DoubleLinkedNode node = head;
        while (node != null && index > 0)
        {
            index--;
            node = node.next;
        }
        return node;
    }

    @Override
    public void remove(int index) {
        if(index == 0 && head != null)
        {
            head = head.next;
            if(head != null)
                head.prev = null;
        }
        else if(index == size() - 1 )
        {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            DoubleLinkedNode r = getNodeByIndex(index);
            DoubleLinkedNode p = r.prev;
            DoubleLinkedNode n = r.next;
            if( p != null)
                p.next = n;
            if(n != null)
                n.prev = p;
        }
        size--;
    }

    // void addLast(int), void removeLast() и int getLast()

    void addLast(int value)
    {

        add(value);
    }
    void removeLast()
    {
        remove(size() - 1);
    }
    int getLast()
    {
        return get(size() - 1);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        DoubleLinkedNode node = head;
        b.append("[");
        while (node != null)
        {
            b.append(node.value);
            if(node.next != null)
            {
                b.append(", ");
            }
            node = node.next;
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void addFirst(int value) {
        DoubleLinkedNode newNode = new DoubleLinkedNode(value);

        if(head == null) {  //если список пуст, начало и конец указывают на newNode
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
        }
        else {
            tail.next = (DoubleLinkedNode) newNode; //добавить новый Node в конец списка. tail->next установить в newNode
            newNode.prev = tail; // предыдущий в хвост
            tail = newNode; // становится новым tail
            tail.next = null; // tail's next point to null
        }
    }

    static class DoubleLinkedNode {
        int value;
        DoubleLinkedNode prev = null;
        DoubleLinkedNode next = null;

        public DoubleLinkedNode(int value) {
            this.value = value;
        }

        public DoubleLinkedNode(int value, DoubleLinkedNode prev, DoubleLinkedNode next) {
            this.value = value;
            this.prev = prev;
            if(prev != null)
                prev.next = this;
            this.next = next;
            if(next != null)
                next.prev = this;
        }
    }

    @Override
    public int getFirst() {
        return 0;
    }
    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            DoubleLinkedNode temp = head;

            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            System.out.println(temp.toString());
        }
    }
}
