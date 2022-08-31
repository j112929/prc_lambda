package Hankerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {
    //判断
    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (ch >= 97) ch = Character.toLowerCase(ch);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (ch >= 97) ch = Character.toLowerCase(ch);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}