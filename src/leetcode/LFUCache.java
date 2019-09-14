package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    Map<Integer, Integer> valMap;                      // map A: key -> value map
    Map<Integer, Integer> countMap;                    // map B: key -> frequency map
    Map<Integer, LinkedHashSet<Integer>> freqListMap;  // map C: frequency -> (list of keys) map
    int capacity;
    int min;  // the least frequency in the map

    public LFUCache(int capacity) {
        valMap = new HashMap<>();
        countMap = new HashMap<>();
        freqListMap = new HashMap<>();
        this.capacity = capacity;
        min = 0;
    }

    public int get(int key) {
        System.out.println("get " + key);

        if (!valMap.containsKey(key)) return -1;

        int count = countMap.get(key);
        countMap.put(key, count + 1);

        // update map C: remove from count frequency list
        freqListMap.get(count).remove(key);
        // update map C: add to keys of count + 1 frequency
        if (freqListMap.get(count + 1) == null) {
            freqListMap.put(count + 1, new LinkedHashSet<>());
        }
        freqListMap.get(count + 1).add(key);

        // update min
        if (min == count && freqListMap.get(count).size() == 0) {
            freqListMap.remove(min);
            min++;
        }
        return valMap.get(key);
    }

    public void put(int key, int value) {
        System.out.println("put " + key);
        if (valMap.containsKey(key)) {
            valMap.put(key, value);  // update map A
            get(key);  // update map B, C
            return;
        }

        // evict
        if (valMap.size() == capacity) {
            int toEvictKey = freqListMap.get(min).iterator().next();
            evictKey(toEvictKey);
        }

        // add new
        valMap.put(key, value);  // add to map A
        min = 1;
        countMap.put(key, min);  // add to map B
        // add to map C
        LinkedHashSet<Integer> set = freqListMap.getOrDefault(min, new LinkedHashSet<>());
        set.add(key);
        freqListMap.put(min, set);
    }

    private void evictKey(int key) {
        valMap.remove(key);     // remove from map A
        countMap.remove(key);   // remove from map B

        // remove from map C
        LinkedHashSet<Integer> set = freqListMap.get(min);
        set.remove(key);
        if (set.size() == 0) {
            freqListMap.remove(min);
        } else {
            freqListMap.put(min, set);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */