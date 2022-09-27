package Lesson15.HashMap;

public class MapTester {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("Moldova", "Cishinau");
        map.put("Hungary", "Budapest");
        map.put("Germany", "Berlin");

        System.out.println(map.get("Moldova"));
        System.out.println(map.contains("Moldova"));
        map.remove("Moldova");
        map.put("Hungary", "Budapest");
        map.put("Germany", "Berlin");
        //System.out.println();
        map.resize();
        System.out.println(map.size());
    }


}
