package codesignal;

/**
 * Task2
 * <p>
 * You are given an array of strings words consisting of lowercase English letters, and a string letters consisting of distinct lowercase English letters. For each word in the words array, your task is to calculate the number of unique letters from letters string that appear in that word (not including duplicates). Return an array of integers where the ith element corresponds to the number of unique letters in letters which appear in words[i].
 * Example
 * For words = ["hi", "bye", "bebe"] and letters = "iye", the output should be solution(words, letters) = [1, 2, 1].
 * Explanation:
 * The first word "hi" contains 1 unique letter from letters - "i".
 * The second word "bye" contains 2 unique letters from letters - "y" and "e".
 * The third word "bebe" contains 1 unique letter from letters - "e". Although "e" appears twice in "bebe", only unique letters should count, so it is only counted once.
 * The answer is [1, 2, 1].
 * For words = ["helloworld"] and letters = "aip", the output should be solution(words, letters) = [0].
 * The only word "helloworld" does not contain any letters which match letters, so the answer is [0].
 */
public class Task2 {
    public static void main(String[] args) {
        String[] words = {"hi", "bye", "bebe"};
        String letters = "iye";
        int[] sol = sol(words, letters);
        for (int i = 0; i < sol.length; i++) {
            System.out.println(sol[i]);
        }
    }

    public static int[] sol(String[] words, String letters) {
        int[] ans = new int[words.length];
        char[] charArray = letters.toCharArray();
        //letters
        for (int i = 0; i < letters.length(); i++) {
            //words
            for (int j = 0; j < words.length; j++) {
                if (words[j].contains(charArray[i] + "")) {
                    ans[j]++;
                }
            }
        }
        return ans;
    }
}
