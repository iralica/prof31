package Lesson25.HomeWork;
//Напишите метод, который удаляет из строки все гласные в любом регистре
// Напишите метод, который проверяет, что строка является телефонным номером - номер начинается с опционального плюса а дальше 6 цифр
// Если в строке встречается число без десятичной точки , то добавьте к этому числу ".0" .
// Пример: "расходы 20 доходы 50.3" -> "расходы 20.0 доходы 50.3"

public class HomeWork25 {
    public static void main(String[] args) {
        String str = "A writing consisting of multiple glyphs, characters, symbols or sentences";
        System.out.println(remVowel(str));

        System.out.println(isPhoneNumber("+777823"));
        System.out.println(isPhoneNumber("+777828"));
        System.out.println(isPhoneNumber("0777823"));//false
    }
    // Task1
    static String remVowel(String str)
    {
        return str.replaceAll("[aeiouAEIOU]", "");
    }
    //Task2
    public static boolean isPhoneNumber(String number){
        return number.matches(("\\D\\d{6}"));
    }


}
