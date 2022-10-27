package Lesson24.HomeWork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

public class LongestWordInTextFile {
    public static void main(String[] args) {

    }

    public static String getLongestWord(String fileName) {
        String result = "";
        try (
                FileReader fileReader = new FileReader("lines.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            result =
                    bufferedReader.lines()
                            .flatMap(line -> Arrays.stream(line.split("\\s+"))) // заходит линия (предложение) выдает список слов
                            .max(Comparator.comparing(String::length)) // сравнивает строки по длине
                            .orElse(""); // если ничего там нет то вовзращает пустую строку

        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
        }
        return result;
    }

}
