package com.leetcode.lru;

import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by bod on 8/14/14.
 */
public class LRUCache {
    Hashtable<Integer, Integer> indexer;
    Vector<Integer> list;
    int capacity;

    public LRUCache(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            indexer = new Hashtable<Integer, Integer>();
            list = new Vector<Integer>();
        }
    }

    public int get(int key) {
        synchronized (this) {
            if (indexer.contains(key)) {
                int index = indexer.get(key);
                return list.get(index);
            } else {
                return -1;
            }
        }
    }

    public void set(int key, int value) {
        synchronized (this) {
            if (indexer.contains(key)) {
                int index = indexer.get(key);
                list.remove(index);
                list.add(0, value);
            } else if (indexer.size() == capacity) {
                list.remove(capacity - 1);
                list.add(0, value);
                indexer.put(key, 0);
            }
        }
    }
}
