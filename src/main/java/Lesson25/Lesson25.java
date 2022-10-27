package Lesson25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson25 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("max");
        Pattern pattern1 = Pattern.compile("was\\."); // чтобы зацепить пунктуацию
        Pattern pattern2 = Pattern.compile("was|max"); // и и
        Pattern pattern3 = Pattern.compile("[23]"); // диапазон от 2 до 3
        Pattern pattern4 = Pattern.compile("[1-3][2-8]"); // диапазон от1-3 и второй диапазон
        Matcher matcher = pattern.matcher("Today's max temperature was 23 as max paint");
        Matcher matcher1 = pattern1.matcher("Today's max temperature was. 23 as max paint");
        Matcher matcher2 = pattern2.matcher("Today's max temperature was. 23 as max paint");
        //System.out.println(matcher.find()); // есть ли вхождения слова
        System.out.println(matcher.results().count()); // скольк раз встречался
        System.out.println(matcher1.results().count());
        System.out.println(matcher2.results().count());
        System.out.println(isIpV4Address("1.1.1.1")); //true
        System.out.println(isIpV4Address("1.a.1.1")); // false
        System.out.println(isIpV4Address("3333.22.33.1")); // false
        System.out.println(isIpV4Address("222.222.222.222")); //true
        System.out.println("----hex number----");
        System.out.println(isHexNumber("0xaf345")); // true
        System.out.println(isHexNumber("0XFCD")); // true
        System.out.println(isHexNumber("0x123")); // true
        System.out.println(isHexNumber("0123")); // false
        System.out.println(isHexNumber("0xGHE")); // false

    }

    public static boolean isIpV4Address(String address){
        return address.matches(("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));
    }
    public static boolean isPinCode(String code){
        return code.matches(("\\d{4}|\\d{6}"));
    }

    public static boolean isCarNumber(String number){
        return number.matches(("\\d{4} [A-Z]{2}}"));
    }
    public static boolean isHexNumber(String number){
        // 0xaf345
        // 0XFCD
        // 0x123
        // 0 + x или X + цифра или буквы A-F в нижнем или верхнем регистре

        return number.matches("0[xX][0-9A-Fa-f]+");
    }
    public static String getExtension(String filename)
    {
        // hello.png -> png
        // my.resume.1.doc -> doc
        String [] parts = filename.split("\\.");
        return parts[parts.length - 1];
    }

}
