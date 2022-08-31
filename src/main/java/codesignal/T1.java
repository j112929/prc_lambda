package codesignal;

// import java.util.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'b', 'c', 'b', 'b'},
                {'b', 'a', 'c', 'd', 'a'},
                {'c', 'b', 'a', 'd', 'e'},
                {'b', 'a', 'c', 'd', 'e'},
                {'a', 'b', 'c', 'd', 'e'}
        };
        // aaaaa
        // bbbbb
        // cacca
        // bbcdb
        // aaade
        // bcdeb
        // cdecd
        // babab
        // bbbbb
        System.out.println(sol(matrix));
    }

    static int[] sol(char[][] matrix) {
        int n = matrix.length;
        String[] arr = new String[2 * n - 1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (n - i - 1 == 0) {
                for (int j = 0; j < n; j++) {
                    sb.append(matrix[j][j]);
                }
            } else {
                int r = n - 1 - i, c = 0;
                if (i > 4) {
                    r = 0;
                    c = i - (n - 1);
                }
                for (int j = 0; j < n; j++) {
                    sb.append(matrix[r][c]);
                    r = r + 1 > n ? r : r + 1;
                    c = c + 1 > n ? c : c + 1;
                }
            }
            arr[i] = sb.toString();
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                ans[i] = map.get(arr[i]);
            }
        }
        return ans;
    }
}
