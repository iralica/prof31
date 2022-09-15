package Lesson12;

public class ExceptionTester {
    // Trowable
    // Eror
    // Exeption
    // RuntimeExeption
    public static void main(String[] args) {

        // Exception (исключение) это спецальная ситуация или ошибка
        // которая возникала в процессе работы программы
        // выбрасываются JVM либо кодом

        // Error выбрасывается JVM
        // например OutOfMemoryError
        // выполнение программы невозможно
        // перехватить нельзя


        // RuntimeException
        // пример IndexOutOfBounds ArithmeticException
        // ошибка програмиста
        // unchecked (не проверяемые) - перехватить можно, но нужно ли?
        // необходимости обрабатывать их нет

        // исключения производные от
        // Exception нужно обрабатывать
        // checked (проверяемые) - нужно ли перехватывать используя try-catch либо пробрасывать дальше

        System.out.println(divide(14,2));
            System.out.println(divide(3,8));
            System.out.println(divide(10,0));



        }

        public static int divide(int a , int b)
        {
            if(b == 0)
               //throw new MyException("Division by zero");

            return a;
            return a;
        }

        public static class MyException extends Exception {
            public MyException() {
                super();

            }
            MyException(String message)
            {
                super(message);
            }
        }

}
