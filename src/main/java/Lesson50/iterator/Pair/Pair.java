package Lesson50.iterator.Pair;



public class Pair<K extends Comparable<K>,V> implements Comparable<Pair<K,V>> {

    private K key;
    private V value;

    @Override
    public int compareTo(Pair<K, V> o) {
        // сравнение будет по ключу Comparable<Pair...
        // getKey()
        // o.getKey()
        return getKey().compareTo(o.getKey());
    }


    public  Pair (K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

