package Lesson22;

import java.io.Serializable;
// Напишите функции которые сериализуют и десериализуют экземпляр
// какого-нибудь класса в json-представление в текстовом файле и обратно
// Можно воспользоваться библиотекой Gson.
public class HomeWork22 {
    public static void main(String[] args) {

    }
}

class Cat implements Serializable {
    public String name;
    public int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
