package Lesson23;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

//Напишите функцию, которая принимает на вход путь к директории и строку фрагмент названия и
// распечатывает только файлы в имени которых есть этот фрагмент
public class HomeWork2 {
    public static void main(String[] args) {
        String dir = "src";
        String pattern = "r";
        File d = new File(dir);
        String[] files = d.list((dir1, name) -> name.contains(pattern));
        Arrays.stream(files)
                .forEach(
                        System.out::println
                );
    }

    //Напишите функцию которая принимает на вход
    // путь к директории и распечатывает файлы и директории рекурсивно.

    public static void printDirectory(String path)
    {
        File d = new File(path);
        String absolutePath = d.getAbsolutePath();
        String sep = File.separator; //     /    \
        String [] files = d.list();
        for(int i=0 ; i < files.length; i++)
        {
            String fileName = files[i];
            File f = new File(absolutePath + sep + fileName);
            System.out.println(f.getAbsolutePath());
            if(f.isDirectory())
                printDirectory(f.getAbsolutePath());
        }
    }

}
