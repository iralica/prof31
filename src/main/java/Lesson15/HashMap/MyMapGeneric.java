package Lesson15.HashMap;

public interface MyMapGeneric <K, V> {
    void put(K key, V value); // добавление значения по ключу
    V get(K key); // получение значения по ключу
    V remove(K key); // удаление пары по ключу
    boolean contains(K key); // содержится ли ключ в мапе
    int size(); // количество пар
}
