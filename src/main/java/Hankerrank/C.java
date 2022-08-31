package Hankerrank;

/**
 * String Comparison
 * Given a pair of strings. The goal is to make them equal by doing one of the following operations at most once:
 * Select two characters,
 * char1
 * and
 * char2,
 * and replace all occurrences of
 * char1
 * in the first string with
 * char2
 * .
 * Select two characters,
 * char1
 * and
 * char2,
 * and replace all occurrences of
 * char1
 * in the second string with
 * char2
 * .
 * <p>
 * For example, the string "xxyz" can be converted to any of the following strings by performing the operation as mentioned above: "yyyz", "vvyz", "xxzz", "xxwz", etc. However, it cannot be converted to the string "yzyz" (Since all the occurrences of a character can be replaced by a single new character).
 * <p>
 * Note that doing both operations simultaneously is not allowed. For example, given two strings "xz" and "zx", we can not convert both the x's in the respective strings to 'z' to make them equal.
 * <p>
 * <p>
 * Given two arrays of n strings each, compare the strings present at the same indices in both the arrays and find if they can be made equal or not. Return an array of n strings, where the ith element would be YES if the strings at index i can be equalized; otherwise, the answer is NO.
 * EX1
 * Consider the array of strings to be:
 * firstStrings
 * = ["aaa", "abbc", "zyz"]
 * secondStrings
 * = ["bbb", "cccc", "zyx"]
 * <p>
 * Let us compare the strings at each index:
 * i = 0: firstStrings[0] = "aaa", secondStrings[0] = "bbb"
 * We can change all the occurrences of 'a' to 'b' in the first string in this case. Therefore, the answer is "YES".
 * i = 1: firstStrings[1] = "abbc", secondStrings[1] = "cccc"
 * There is no way in which we can make these strings identical. Therefore, the answer is "NO".
 * i = 2: firstStrings[2] = "zyz", secondStrings[2] = "zyx"
 * We can replace the only occurrence of 'x' in the second string with 'z' to make them identical. Therefore, the answer is "YES".
 * Hence, the answer corresponding to each pair of strings is ["YES," "NO," "YES"].
 */
public class C {
    public static void main(String[] args) {

    }

}
