package Lesson15.HashMap;

public class MyGenericHashMap<K, V> implements MyMapGeneric<K,V>{
    private int size = 0; // количество пар в контейнере
    private static final int INITIAL_CAPACITY = 4; // начальный размер массива
    private static final double LOAD_FACTOR = 0.75; // коэффициент загруженности
    // если size/source.length >= LOAD_FACTOR то нужно перебалансировать
    // для равномерного распределения элементов чтобы не было длинных цепочек

    private Pair<K,V> [] source = new Pair[INITIAL_CAPACITY]; // массив для хранения "голов" цепочек

    public int capacity()
    {
        return source.length;
    }

    private static class Pair<K,V> { // элемент
        K key; // ключ
        V value; // значение
        Pair<K,V> next; // ссылка на следующий элемент в цепочке
        public Pair(K key, V value, Pair<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{"+key+":"+value+"}";
        }
    }

    @Override
    public void put(K key, V value) {
        if(size > LOAD_FACTOR*source.length)
            resize();
        Pair<K,V> pair = findPair(key); // поиск пары по ключу
        if(pair == null) // нужно вставить новую пару
        {
            int bucket = findBucket(key); // найдем номер ведра по ключу
            pair = new Pair<>(key, value, source[bucket]);
            source[bucket] = pair; // делаем новую пару корнем цепочки
            size++;
        }
        else {
            pair.value = value; // такая пара уже есть, просто меняем значение
        }
    }

    private int findBucket(K key)
    { // по ключу находим хэш и по хэшу находим бакет
        return Math.abs(key.hashCode()) % source.length;
    }

    // поиск пары по ключу
    private Pair<K,V> findPair(K key)
    {
        // найдем ведро по ключу
        int bucket = findBucket(key);
        Pair<K,V> currentPair = source[bucket]; // корень цепочки
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
    private void resize()
    {
        // нужно создать новый массив длины в два раза больше чем source
        // пробежаться по всем корневым элементам и перенести их
        // в нужные бакеты нового массива
        Pair<K,V> [] newSource = new Pair[source.length * 2]; // новый массив
        for(Pair<K,V> p : source) // корень текущего
        {
            Pair<K,V> c = p;
            while (c != null) // текущая пара
            {
                Pair<K,V> n  = c.next;
                int bucket = Math.abs(c.key.hashCode()) % newSource.length;
                c.next = newSource[bucket];
                newSource[bucket] = c;
                c = n;
            }
        }
        source = newSource;
    }

    @Override
    public String toString() {
        int s = size-1;
        StringBuilder b = new StringBuilder("[");
        for(Pair<K,V> p : source)
        {
            Pair<K,V> c = p;
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
    public V get(K key) { // найти значение в паре с ключом key
        Pair<K,V> pair = findPair(key);
        if(pair == null)
            return null;
        return pair.value;
    }

    @Override
    public V remove(K key) {
        int bucket = findBucket(key);
        Pair<K,V> c = source[bucket];
        if(c == null)
            return null;
        if(c.key.equals(key))
        {
            source[bucket]  = c.next;
            size--;
            return c.value;
        }
        while (c.next != null)
        {
            if(c.next.key.equals(key))
            {
                Pair<K,V> toDelete = c.next;
                c.next = toDelete.next;
                size--;
                return toDelete.value;
            }
            c = c.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        // найти пару с ключом key
        // Pair p = findPair(key);
        return findPair(key) != null;
    }

    @Override
    public int size() {
        return size;
    }
}