package Lesson17.homework;
//напишите метод для кодирования строк. Строка состоит только из маленьких латинских букв.
// Пример: "aaaabbcccdaaa" -> "4a2b3c1d3a"
// * напишите метод для декодирования такой строки


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

    public static String decode(String s){
        if (s.length() == 0) {
            return "Строка пустая";
        }
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < s.length(); i+=2) { // прыгаем через один

        }
        return s;
    }

}
