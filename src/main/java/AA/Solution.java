package AA;

public class Solution {
    /**
     * //     * @param s: Roman representation
     *
     * @return: an integer
     */
    public static String convertToTitle(int n) {
        // write your code here
        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if (n > 0 && n < 27) {
            return c[n - 1] + "";
        } else if (n > 26) {
            while (n > 26) {
                n = n / 26;
            }
            System.out.println(n);
            if (n > 1) {
                return c[n - 2] + "" + c[n - 1];
            } else {
                return "A" + c[n - 1];
            }
        }
        return "";
    }

    public static void main(String[] args) {
//        Character
        String i = convertToTitle(1000);
        System.out.println(i);
    }

}