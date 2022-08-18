package Lesson6;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Max Kotkov", new Address("Main street", "12")));
        people.add(new Person("Semen Petrov", new Address("Fleet street", "1")));
        people.add(new Person("Maria Ivnova", new Address("Light street", "44")));

        System.out.println(getAddress(people));

    for (Address a: getAddress(people)){
        System.out.println(a);
    }
    }
    public static List<Address> getAddress(List<Person> persons){

        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
          Person p = persons.get(i);
          addresses.add(p.address);
            }
        return addresses;
    }
}
