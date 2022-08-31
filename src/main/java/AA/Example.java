package AA;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

public class Example {
    public static Tree buildWordTreeFromSentences(List<String>
                                                          sentenceList) {
        Tree root = new Tree();
        for (String sentence : sentenceList) {
            Tree base = root;
            for (String word : sentence.split(" ")) {
                if (!base.containsKey(word))
                    base.put(word, new Tree());
                base = base.get(word);

            }
            return root;
        }
        return root;
    }

    public static void main(String[] args) {
        Tree tree = buildWordTreeFromSentences(Arrays.asList("Hello world", "Hello there"));
        System.out.println(JSON.toJSONString(tree));
    }
}