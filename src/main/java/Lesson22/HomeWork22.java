package Lesson22;

import Lesson13.homework.Employee;
import com.google.gson.Gson;

import java.io.*;

// Напишите функции которые сериализуют и десериализуют экземпляр
// какого-нибудь класса в json-представление в текстовом файле и обратно
// Можно воспользоваться библиотекой Gson.
public class HomeWork22 {
    public static void main(String[] args) {
        Employee employee = new Employee(22, 3500, 24, "Sergei K");
        //writeObjectToFile("kupsov.json", employee);
        Employee employee1 = getEmployeeFromFile("kupsov.json");
        System.out.println(employee1);
        Employee employee2 = getEmployeeFromFile("kupsov.json", Employee.class);
        System.out.println(employee2);

    }
    public static <T>  T getEmployeeFromFile(String filename, Class<T> clazz)
    {
        Gson gson = new Gson();
        T result = null;
        try(
                FileReader fileReader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {
            result = gson.fromJson(bufferedReader, clazz);
        }
        catch (Exception e)
        {
            System.err.println("exception: " + e.getMessage());
        }
        return result;
    }


    public static Employee getEmployeeFromFile(String filename)
    {
        Gson gson = new Gson();
        Employee employee = null;
        try(
                FileReader fileReader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {
            employee = gson.fromJson(bufferedReader, Employee.class);
        }
        catch (Exception e)
        {
            System.err.println("exception: " + e.getMessage());
        }
        return employee;
    }


    public static void writeObjectToFile(String filename, Object object)
    {
        Gson gson = new Gson();
        String obj = gson.toJson(object);
        File file = new File(filename);
        try (
                FileWriter fileWriter = new FileWriter(filename);
                PrintWriter printWriter = new PrintWriter(fileWriter)
        )
        {
            printWriter.println(obj);
        }
        catch (Exception e)
        {
            System.err.println("exception: " + e.getMessage());
        }

    }

}
