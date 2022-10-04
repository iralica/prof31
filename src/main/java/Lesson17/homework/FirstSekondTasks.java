package Lesson17.homework;
//напишите метод для кодирования строк. Строка состоит только из маленьких латинских букв.
// Пример: "aaaabbcccdaaa" -> "4a2b3c1d3a"
// * напишите метод для декодирования такой строки


import java.util.Collections;

public class FirstSekondTasks {
    public static void main(String[] args) {
        String str = "aaaabbcccdaaa";
        String str1 = "d";
        System.out.println(encode(str1));
        System.out.println(encode(str));
    }
    public static String encode(String s)
    {
        if (s.length() == 0)
            return "";
        if (s.length() == 1)
            return 1 + s;
        StringBuilder encoded = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else {
                encoded.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        if (count > 0)
            encoded.append(count).append(s.charAt(s.length() - 1));
        return encoded.toString();
    }

    public static String encodeTwo(String input){
        StringBuilder b = new StringBuilder();

        char[] letters = input.toCharArray();
        int counter = 0;
        char prev = letters[0];
        char curr = letters[0];
        for (char c: letters)
        {
            curr = c;
            if(curr != prev) {
                b.append(counter).append(prev);
                counter = 1;
            }
            else {
                counter++;
            }
            prev = curr;
        }
        b.append(counter).append(curr);
        return b.toString();
    }


    public static String decode(String s){
        if (s.length() == 0) {
            return "Строка пустая";
        }
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < s.length(); i+=2) {                            // прыгаем через один
            decoded.append(String.join                                     // concatenates the given elements with the delimiter
                    ("", Collections.nCopies                       //return an immutable list which contains n copies of given object
                            (Character.getNumericValue(s.charAt(i)),       // returns the int value of the specified character
                                    String.valueOf(s.charAt(i + 1)))));    //valueOf (char c) — возвращает строковое представление аргумента char.
        }
        return decoded.toString();
    }
    public static String decodeTwo(String crypto){
        // разбиваем на символы
        // в цикле если символ цифра, добавляем его в строку с цифрами
        // если символ буква, преобразовываем строку с цифрами в int
        // в цикле добавляем в builder нужное количество букв
        StringBuilder r = new StringBuilder(); // результат
        String d = "";
        char[] letters = crypto.toCharArray();
        for (char c : letters)
        {
            if(!Character.isDigit(c))
            {
                int numberOfLetters = Integer.parseInt(d);
                // r.append(String.valueOf(c).repeat(Math.max(0, numberOfLetters)));
                for(int j = 0; j < numberOfLetters; j++)
                    r.append(c);
                d = "";
            }
            else
            {
                d += c;
            }
        }
        return r.toString();


    }
}
