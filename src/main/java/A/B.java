package A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {
    public static List<Integer> getMinDiff(List<String> a, List<String> b) {
        List<Integer> minDiffList = new ArrayList<>();
        if (a.size() == 0 || b.size() == 0) {
            return minDiffList;
        }
        for (int i = 0; i < b.size(); i++) {
            int difCount = 0;
            if (a.get(i).length() != b.get(i).length()) {
                difCount = -1;
            } else {
                for (int j = 0; j < a.get(i).length(); j++) {
                    if (b.get(i).indexOf(a.get(i).charAt(j)) == -1) {
                        difCount++;
                    }
                }
            }
        }
        return minDiffList;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>(Arrays.asList("abc"));
        List<String> b = new ArrayList<>(Arrays.asList("abe"));
        System.out.println(getMinDiff(a, b));
    }
}
