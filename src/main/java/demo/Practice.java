package demo;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        new ArrayList<Integer>() {
            {
                add(1);
            }
        };
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> valueResult = new HashMap<>();
        // map.entrySet().stream()
        // .sorted((Comparator<? super Map.Entry<String, Integer>>) Map.Entry
        // .comparingByValue().reversed())
        // .forEachOrdered(b->valueResult.put(b.getKey(), b.getValue()));
        Map<String, Integer> result = new HashMap<>();
        // map.entrySet().stream()
        // .sorted((Comparator<? super Map.Entry<String, Integer>>)
        // Map.Entry.comparingByKey().reversed())
        // .forEachOrdered(x->result.put(x.getKey(),x.getValue()));

        // List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // //然后通过比较器来实现排序
        // 降序排序
        Collections.sort(list, (o1, o2) -> {
            int r = o2.getValue().compareTo(o1.getValue());
            if (r == 0) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return r;
            }
        });

        // for(Map.Entry<String, Integer> entry : list){
        // entry.
        // map.get(entry);
        // }
    }

    public List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, (word1, word2) -> cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2)
                : cnt.get(word2) - cnt.get(word1));
        String[] objects = (String[]) rec.subList(0, k).stream().toArray();
        return rec.subList(0, k);
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = map.entrySet().stream()
                .filter(x -> x.getValue() != 2)
                .map(x -> x.getKey()).collect(Collectors.toList());
        return result.get(0);
        // for(Integer k:map.keySet()){
        // if
        // }
        // Map<Integer, Integer> map1 = map.entrySet().stream().filter(x -> x.getValue()
        // != 2).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        // Set<Integer> integers = map1.keySet();
        // integers.
        // map1.get(map1.keySet().);
        // return result.intValue();
    }

}
