package lesson4.reference;

import lesson2.inheritance.Person;
import org.junit.Test;

public class ReferenceTypeTest {
    @Test
    public void example(){
        Person p  = new Person("Max");
        System.out.println("Before modify: " + p.getName());
        modify(p);
        System.out.println("After modify: " + p.getName());
    }

    public static void modify(Person d)
    {
        d.setName("Alex");
        System.out.println("In modify: " + d.getName());
    }
}
