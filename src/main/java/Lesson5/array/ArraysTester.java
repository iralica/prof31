// дополнить
package Lesson5.array;

import java.util.Arrays;

public class ArraysTester {
    public static void main(String[] args) {
        //int [] a = new int[] {1,3,5,7};
        //String [] b = {"Apocalypse now", ""};


        //binarySearch


        int [] r = {1 ,4  ,13 ,33 ,37 ,41 ,50};
        System.out.println(
                Arrays.binarySearch(r, 41)
        );

        //случай когда этой цифры нет
        // -вернул  -2  = (- insertion point  -1)
        System.out.println(
                Arrays.binarySearch(r, 2)
        );

    }


}
