package lesson11.deque;

import Lesson12.ExceptionTester;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DivideByZeroTrowsExeption {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void divideByZeroThrows() throws ExceptionTester.MyException {
        exception.expect(ExceptionTester.MyException.class);
        exception.expectMessage("Division by zero");
        ExceptionTester.divide(10, 0);
    }

}
