package Lesson17.homework;
//напишите метод, который вернет true если в массиве присутствуют два числа,
// произведение которых даст нужное число. Пример [5,7,12, 2] , 10 -> true

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdTask {
    public static void main(String[] args) {
        int [] arr = new int[] {5, 7, 12, 2};
        System.out.println(test(arr, 10));
        System.out.println(testTwo(arr, 10));
        System.out.println(testTwo(arr, 60));
        System.out.println(search(arr, 60));
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
    public static boolean testTwo(int [] a, int b){
        // сортировка имеет сложность O(n*log(n)) дальнейший перебор вариантов O(n)
        // O(n*log(n)) + O(n) -> O(n*log(n))
        // 10
        // [2, 5, 7, 12]
        // 2*12 = 24
        // 2*7 = 14
        // 2*5 = 10
        Arrays.sort(a);
        int i = 0;
        int j = a.length - 1;
        while ((j - i) >= 1)
        {
            int mul = a[i] * a[j];
            if( mul == b)
                return true;
            else if(mul > b)
            {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }

    private static int search(int[] array, int z) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (array[mid] == z) {

                return mid;
            }
            if (array[mid] > z) {
                high = mid - 1;
            } else low = mid + 1;

        }
        return mid;
    }
}
