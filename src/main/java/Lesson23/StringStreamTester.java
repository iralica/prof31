package Lesson23;
// https://www.oreilly.com/api/v2/epubs/9781449372477/files/httpatomoreillycomsourceoreillyimages1707640.png

import java.io.BufferedReader;
import java.io.StringReader;

// https://www.oreilly.com/api/v2/epubs/9781449372477/files/httpatomoreillycomsourceoreillyimages1707642.png
public class StringStreamTester {
    public static void main(String[] args) {
        String hello = "hello\nworld\nhow are you?";
        StringReader stringReader = new StringReader(hello);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        bufferedReader.lines().forEach(System.out::println);
    }
}
