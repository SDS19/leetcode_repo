package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class _146 {
    private LinkedHashMap<Integer,Integer> map;
    private final int CAPACITY;

    public _146(int capacity){
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value){
        map.put(key, value);
    }
}
