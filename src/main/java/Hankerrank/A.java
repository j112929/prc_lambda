package Hankerrank;

/**
 * HackerRank Question - Break a Palindrome
 * A palindrome reads the same from left or right, mom for example. There is a palindrome which must be modified, if possible. Change exactly one character of the string to another character in the range ascii[a-z] so that the string meets the following three conditions:
 * The new string is lower alphabetically than the initial string.
 * The new string is the lowest value string alphabetically that can be created from the original palindrome after making only one change.
 * The new string is not a palindrome.
 * Return the new string, or, if it not possible to create a string meeting the criteria, return the string IMPOSSIBLE.
 * Example
 * palindromeStr = 'aaabbaaa'
 * Possible strings lower alphabetically than 'aaabbaaa' after one change are ['aaaabaaa', 'aaabaaaa'].
 * 'aaaabaaa' is not a palindrome and is the lowest string that can be created from palindromeStr.
 * Function Description
 * Complete the function breakPalindrome in the editor below.
 * breakPalindrome has the following parameter(s):
 * string palindromeStr:  the original string
 * Returns:
 * string: the resulting string, or IMPOSSIBLE if one cannot be formed
 * <p>
 * case1
 * palindromeStr  = 'bab'
 * Sample Output
 * aab
 * Explanation
 * Possible strings lower alphabetically than 'bab' after one change are ['aab', 'baa'].
 * 'aab' is not a palindrome and is the lowest string that can be created from palindromeStr.
 * <p>
 * case2
 * palindromeStr  = 'aaa'
 * Sample Output
 * IMPOSSIBLE
 * Explanation
 * There are no strings lower alphabetically than 'aaa' after one change.
 * So, it is IMPOSSIBLE to create a string lower than 'aaa'.
 * <p>
 * case3
 * palindromeStr  = 'acca'
 * Sample Output
 * aaca
 * Explanation
 * Possible strings lower alphabetically than 'acca' after one change are ['abca', 'aaca', 'acba', 'acaa'].
 * 'aaca' is not a palindrome and is the lowest string that can be created from palindromeStr.
 */
public class A {
    public static void main(String[] args) {
        System.out.println(sol("aaa"));
    }

    public static String breakPalindrome(String palindrome) {

        if (palindrome.length() == 1) {
            return "";
        }

        int halfLength = palindrome.length() / 2;
        char[] letters = palindrome.toCharArray();

        for (int i = 0; i < halfLength; i++) {
            if (letters[i] != 'a') {
                letters[i] = 'a';
                return String.valueOf(letters);

            }
        }

        letters[palindrome.length() - 1] = 'b';
        return String.valueOf(letters);
    }

    public static String sol(String str) {
        char[] palindrome = str.toCharArray();
        int i, n = palindrome.length;
        char[] res = palindrome;
        if (n == 1) return "";
        for (i = 0; i < n; i++) {
            char ch = palindrome[i];
            int j = 0, val = ch - 'a';
            while (j < val) {
                res[i] = (char) (j + 97);
                if (res[i] != res[n - 1 - i] && res.length < palindrome.length) return res.toString();
                else res[i] = palindrome[i];
                j++;
            }
        }
        res[n - 1] = (char) ((palindrome[n - 1] - 'a') + 98);
        return res.toString();
    }
}
