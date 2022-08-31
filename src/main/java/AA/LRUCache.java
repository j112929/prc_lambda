package AA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LRUCache {


    Map<Integer, Integer> vMap;
    Map<Integer, Integer> cMap;// 不同的key： 相同的频
    Map<Integer, List<Integer>> fMap;// 相同的频 ： 不同的key
    int cap;
    int minFreq;

    public LRUCache(int capacity) {
        this.cap = capacity;
        vMap = new HashMap<>();
        cMap = new HashMap<>();
        fMap = new HashMap<>();
//        minFreq = 1;
        fMap.put(1, new ArrayList<Integer>());
    }

    public int get(int k) {
        if (!vMap.containsKey(k)) {
            return -1;
        }
        int freq = cMap.get(k);
        fMap.get(freq).remove(Integer.valueOf(k));
        if (freq == minFreq && fMap.get(freq).size() == 0) {
            minFreq++;
        }
        cMap.put(k, ++freq);
        if (fMap.get(freq) == null) {
            fMap.put(freq, new ArrayList<Integer>());
        }
        fMap.get(freq).add(k);
        return vMap.get(k);
    }

    public void put(int k, int v) {
        if (vMap.containsKey(k)) {
            vMap.put(k, v);
            get(k);
        }

        if (vMap.size() >= cap) {
            Integer lowkey = fMap.get(minFreq).get(0);
            fMap.get(minFreq).remove(lowkey);
            vMap.remove(lowkey);
            cMap.remove(lowkey);
        }
        vMap.put(k, v);
        minFreq = 1;
        cMap.put(k, 1);
//        System.out.println(fMap.get(1));
        fMap.get(1).add(k);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */