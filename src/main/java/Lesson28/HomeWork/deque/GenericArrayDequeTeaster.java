package Lesson28.HomeWork.deque;

public class GenericArrayDequeTeaster {
    public static void main(String[] args) {
        GenericArrayDeque<Integer> deque =new GenericArrayDeque<>();
        deque.addLast(1);
        deque.addLast(0);
        deque.addLast(10);
        deque.addLast(11);
        System.out.println(deque);
    }
}
