package Lesson17.homework;
//напишите метод, который вернет true если в массиве присутствуют два числа,
// произведение которых даст нужное число. Пример [5,7,12, 2] , 10 -> true

import java.util.ArrayList;
import java.util.List;

public class ThirdTask {
    public static void main(String[] args) {
        int [] arr = new int[] {1, 7, 12, 10};
        System.out.println(test(arr, 10));
    }
    public static boolean test(int [] a, int b){
        if (a.length < 1) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length ; j++)
                if (a[i] * a[j] == b) {
                    return true;
                }
        }
        return false;
    }
}
