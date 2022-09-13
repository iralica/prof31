package Lesson10.hs;

import java.util.HashSet;
import java.util.Set;

public class SetTester { //Hash set
    // если мы пранируем использовать хэшированные контейнеры
    // нужно в нашем классе заимлеменить equals() и hashCode()
    // у Object.hasCode() есть контракт
    // 1. На протяжении жизни объекта hashCode() для него должен выдавать один и тот-же int
    // 2. если o1.equals(o2) то o1.hashCode() == o2.hashCode()
    // то что o1.hashCode() == o2.hashCode() НЕ означает, что  o1.equals(o2) !!!
    // Vasys -> 239
    // Vasya -> 239

    // Petya -> 10
    // Masha -> 10
    Set<Point> points = new HashSet<>();




}

