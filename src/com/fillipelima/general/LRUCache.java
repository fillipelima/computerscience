package com.fillipelima.general;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    LinkedList<Integer> list = new LinkedList<Integer>();
    private int capacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }else{
            updateLastUsed(key);
            return value;
        }
    }
    
    private void updateLastUsed(int key) {
        // Update last used
        list.remove(Integer.valueOf(key));
        list.addLast(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            updateLastUsed(key);
        }else{
            if (map.size() == capacity)
                map.remove(list.removeFirst());
            map.put(key, value);
            list.addLast(key);
        }
    }
}