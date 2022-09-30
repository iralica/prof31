package Lesson15.HashMap;

public class MyHashMap implements MyMap{
    private int size=0; // количество пар
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75; // size/source.lenght >= LOAD_FACTOR
    private Pair [] source = new Pair[INITIAL_CAPACITY];

    private static class Pair { // элемент
        String key; // ключ
        String value; // значение
        Pair next; // ссылка на следующий элемент в цепочке
        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    @Override
    public void put(String key, String value) {
        if(size > LOAD_FACTOR*source.length)
            resize();
        Pair pair = findPair(key); // поиск пары по ключу
        if(pair == null) // нужно вставить новую пару
        {
            int bucket = findBucket(key); // найдем номер ведра по ключу
            pair = new Pair(key, value, source[bucket]);
            source[bucket] = pair; // делаем новую пару корнем цепочки
            size++;
        }
        else {
            pair.value = value; // такая пара уже есть, просто меняем значение
        }
    }

    private int findBucket(String key)
    { // по ключу находим хэш и по хэшу находим бакет
        return Math.abs(key.hashCode()) % source.length;
    }

    // поиск пары по ключу
    private Pair findPair(String key)
    {
        // найдем ведро по ключу
        int bucket = findBucket(key);
        Pair currentPair = source[bucket]; // корень цепочки
        while (currentPair != null)
        {
            if(currentPair.key.equals(key))
                return currentPair;
            currentPair = currentPair.next; // следующая пара по цепочке
        }
        return null; // пара с ключом key не найдена
    }
    // перебалансировка массива - создание массива в два раза больше и перенос
    // туда всех элементов
    public void resize() {
        // нужно создать новый массив длины в два раза больше чем source
        // пробежаться по всем корневым элементам и перенести их
        // в нужные бакеты нового массива
        //int newCapacity = INITIAL_CAPACITY*2;
        //Pair [] resizedPair = new Pair [newCapacity];
        //for (int i = 0; i < INITIAL_CAPACITY; i++) {
         //   resizedPair[i] = this.source[i];
        //}
        //this.source = resizedPair;
        Pair [] newSource = new Pair[source.length * 2]; // новый массив
        for(Pair p : source) // корень текущего
        {
            Pair c = p;
            while (c != null) // текущая пара
            {
                Pair n  = c.next;
                int bucket = Math.abs(c.key.hashCode()) % newSource.length;
                c.next = newSource[bucket];
                newSource[bucket] = c;
                c = n;
            }
        }
        source = newSource;
    }

    @Override
    public String get(String key) {
        // найти значение в паре с ключом key
        Pair pair = findPair(key);
        if(pair == null)
            return null;
        return pair.value;
    }

    @Override
    public String remove(String key) {
        int bucket = findBucket(key);
        Pair currentPair = source[bucket]; // корень цепочки
        if(currentPair == null) return null;
        Pair prev = currentPair;
        while (currentPair != null) { // не нулевая пара
            if (currentPair.key != null && currentPair.key.equals(key)) {
                String valueReturn = currentPair.value;
                if (prev == currentPair) { //first element?
                    source[bucket] = currentPair.next;
                } else {
                    prev.next = currentPair.next;
                }
                size--;
                return valueReturn;
            }
            prev = currentPair;
            currentPair = currentPair.next;
        }
        return null;
    }

    @Override
    public boolean contains(String key) {
        int bucket = findBucket(key);               // найдем ведро по ключу
        Pair temp = source[bucket];// корень цепочки
        while (temp != null) {
            if ((temp.key == null && key == null)
                    || (temp.key.equals(key))) {
                return true;
            }
            temp = temp.next; //
        }
        return false;
    }
    @Override
    public String toString() {
        int s = size;
        StringBuilder b = new StringBuilder("[");
        for(Pair p : source)
        {
            Pair c = p;
            while (c != null)
            {
                b.append(c);
                if(--s >=0)
                {
                    b.append(", ");
                }
                c=c.next;
            }
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public int size () {
        return size;
    }



}
