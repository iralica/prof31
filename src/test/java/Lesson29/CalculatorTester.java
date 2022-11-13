package Lesson29;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTester {
    private static Calculator calc;

    @BeforeClass // ���������� ������ ���� ��� ��� �������� ������
    // �� ���� �������� �������
    public static void before()
    {
        System.out.println("before");
        calc =  new Calculator();
    }

    @Test
    public void testmultiplyRwoNumbers(){
        System.out.println("testmultiplyRwoNumbers");
        assertEquals(calc.multiply(4, 5),20.0);
    }
    @Test
    public void testmultiplyByZero(){
        System.out.println("testmultiplyByZero");
        assertEquals("Should be 0.0", calc.multiply(0,5), 0.0);
        assertEquals("Should be 0.0", calc.multiply(4,0), 0.0);
    }
    @Before // ����������� ����� ������ ������
    public void init()
    {

        System.out.println("init");
    }
    @After // ����������� ����� ������� ������������ ������
    public void tearDown()
    {
        System.out.println("tearDown");
    }

    @Ignore("Currently don't working") // ���� ���������� �����-�� ���� ���������������
    @Test(expected = ArithmeticException.class) // ��������� � ����������� ����������
    public void divideThrowsException()
    {
        System.out.println("divideThrowsException");
        calc.divide(12, 0);
    }
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsArithmeticException()
    {
        System.out.println("throwsArithmeticException");
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Division by zero");
        calc.divide(12, 0);
    }


}
