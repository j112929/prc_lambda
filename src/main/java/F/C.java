package F;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {
    public static void main(String[] args) {
        String[] words = new String[]{"listen", "silent", "it", "is"};
        String[] sentences = new String[]{"listen it is silent"};
//        String[] words = new String[]{"bats","tabs","in","cat","act"};
//        String[] sentences = new String[]{"cat the bats", "in the act", "act tabs in"};

        //get every str in arr, convert to arr -> sort -> str
        //compare with map, if include this key, push this string


        Map<String, List<String>> map = new HashMap<>();
        List<String> tmpList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String oldStr = words[i];//listen
            //listen -> ['l','i','s','t','e','n'] -> ['e','i','l','n',s','t'] -> eilnst
            String sortedStr = sort(oldStr.split("")).toString().join("");
            if (map.containsKey(sortedStr)) {
                tmpList = map.get(sortedStr);
                tmpList.add(oldStr);//i=1,map = {'eilnst':["listen","silent"]}
            } else {
                tmpList = new ArrayList<>();//{'eilnst':["listen"]}
            }
            tmpList.add(oldStr);
            map.put(sortedStr, tmpList);
        }

        //calculate how many sentence
        //get every sentence -- "listen it is silent"

        List<Integer> countArr = new ArrayList<>();
        for (int i = 0; i < sentences.length; i++) {
            //str convert to arr, "listen it is silent" -> ["listen","it","is","silent"]
            String[] wordArr = sentences[i].split(" ");
            int curCount = 1;
            //get every word --  listen
            for (int j = 0; j < wordArr.length; j++) {
                String sortedStr = sort(wordArr[j].split("")).toString();
                if (map.containsKey(sortedStr)) {
                    curCount = map.get(sortedStr).size() * curCount;
                }
            }
            countArr.add(curCount);
        }
        System.out.println(countArr);
    }

    public static String[] sort(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareTo(words[j]) > 0)//words[i] is greater than words[j]
                {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        return words;
    }
}
