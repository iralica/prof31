package Lesson6.homework;
//Напишите функцию, которая удаляет дубликаты из передаваемого в нее массива строк.

import java.util.Arrays;

public class RemoveArraysDuplicate {
    public static void main(String[] args) {
        int[] l1 = new int[]{25, 10, 3, 3, 3, 6, 8, 8, 8, 12, 15};
        Arrays.sort(l1);
        int length = l1.length;
        length = removeDuplicates(l1, length); // возвращает новый развемр массива
        for  ( int  i= 0 ; i<length; i++)
            System.out.print(l1[i]+ " ");
    }
    public static int removeDuplicates(int[] a, int n)
    {
        if (n==0 || n==1)
            return n;
        int j = 0;
        for (int i=0; i < n-1; i++)
            if (a[i] != a[i+1])
                a[j++] = a[i]; // заполняем новые параметры временного индекса
        a[j++] = a[n-1]; // ограничиваем новый массив размером старого
        return j;
    }
}
