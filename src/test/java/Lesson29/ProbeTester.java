package Lesson29;
import Lesson24.HomeWork.Car1;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

//import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.*;


public class ProbeTester {
    @Test
    public void testProbeMessage()
    {
        assertThat(Probe.getMessage(3), anyOf(is("Hello"), is("World")));
        assertThat(Probe.getMessage(33), anyOf(is("Hello"), is("World")));
        assertThat(Probe.getMessage(23), is("Hello"));
        assertThat(Probe.getMessage(3), is("World"));
        // хотя бы одно условие сработалао
        assertThat(Probe.getMessage(), anyOf(is("Hello"), is("World"))); // для бепараметризованного

        // все условия должны сработать
        assertThat(Probe.getMessage(23), allOf(startsWith("He"), endsWith("lo")));



    }
    @Test
    public void carTest()
    {
        assertThat(Probe.getCar(), instanceOf(Car1.class));
        assertThat((Car1) Probe.getCar(), hasProperty("price", closeTo(20_000, 0.1)));

}
    @Test
    public void collectionTest()
    {
        List<String> names = List.of("Max", "Dima", "Alex", "Marina");
        // напишите тест который проверит что в names есть элементы Dima и Alex
        // до 21:36
        //assertThat(names, allOf(hasItem("Dime"), hasItem( "Alex")));
        assertThat(names, Matchers.hasItems("Dima", "Alex"));
    }


}
