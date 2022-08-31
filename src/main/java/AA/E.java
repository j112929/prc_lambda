package AA;

import java.util.Arrays;

public class E {

    /*static boolean nestedAnagrams(String s, String t) {
        String[] s1 = s.split(" ");
        String[] s2 = t.split(" ");
        boolean f1 = true;

        for(String ss1 :s1){
            for (String ss2 : s2) {
                for (int i = 0; i< ss2.toCharArray().length;i++) {
                    char c1 = ss2.toCharArray()[i];
                    if (!ss1.contains(c1 + "")) {
                        f1 = false;
                    }
                    if(i ==  (ss2.toCharArray().length -1) ){
                        if(f1 && ss1) {
                            return true;
                        }else{
                            f1 = true;
                        }
                    }
                }
            }



        }

        return f1;



    }*/

    /*static boolean nestedAnagrams(String s, String t) {
        // Create a count array and initialize
        // all values as 0
        char[] s1 = s.replace(" ","").toCharArray();
        char[] t1 = t.replace(" ","").toCharArray();


        int[] count = new int[256];
        // int i;

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for(int i = 0; i < s1.length; i++)
        {
            count[s1[i] - 'a']++;
            count[t1[i] - 'a']--;
        }

        // If both strings are of different
        // length. Removing this condition
        // will make the program fail for
        // strings like "aaca" and "aca"
        if (s1.length != t1.length){
            return false;
        }

        // See if there is any non-zero
        // value in count array
        for(int i = 0; i < 256; i++){
            if (count[i] != 0)
            {
                return false;
            }
        }
        return true;
    }*/
    static boolean nestedAnagrams(String s, String t) {

        String[] s1 = s.split(" ");
        String[] t1 = t.split(" ");
        int mismatch = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[0].length() != t1[i].length()) {
                mismatch++;
            }
        }
        if (mismatch == s1.length) {
            return false;
        }

        if (s1[0].length() == t1[0].length() && s1.length <= 2) {
            if (s1[0].length() != t1[0].length() && s1[0].length() != t1[1].length()) {
                return false;
            }
            for (int i = 0; i < t1.length; i++) {
                for (char c : t1[i].toCharArray()) {
                    if (!s1[0].contains(c + "")) {
                        return false;
                    }
                }
            }

            char[] str1 = s.replace(" ", "").toCharArray();
            char[] str2 = t.replace(" ", "").toCharArray();

            int[] count1 = new int[1000];
            Arrays.fill(count1, 0);
            int[] count2 = new int[1000];
            Arrays.fill(count2, 0);
            int i;

            // For each character in input strings,
            // increment count in the corresponding
            // count array
            for (i = 0; i < str1.length && i < str2.length; i++) {
                count1[str1[i]]++;
                count2[str2[i]]++;
            }

            // If both strings are of different length.
            // Removing this condition will make the program
            // fail for strings like "aaca" and "aca"
            if (str1.length != str2.length) {
                return false;
            }

            // Compare count arrays
            for (i = 0; i < 1000; i++) {
                if (count1[i] != count2[i]) {
                    return false;
                }
            }
            return true;
        } else {
            boolean f1 = true;
            for (String ss1 : s1) {
                for (String ss2 : t1) {
                    for (int i = 0; i < ss2.toCharArray().length; i++) {
                        char c1 = ss2.toCharArray()[i];
                        if (!ss1.contains(c1 + "")) {
                            f1 = false;
                        }
                        if (i == (ss2.toCharArray().length - 1)) {
                            if (f1) {
                                return true;
                            } else {
                                f1 = true;
                            }
                        }
                    }
                }
            }
            return f1;
        }
    }

    /*static boolean nestedAnagrams(String s, String t) {
        char[] str1 = s.replace(" ", "").toCharArray();
        char[] str2 = t.replace(" ", "").toCharArray();
        // Get lengths of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2) {
            return false;
        }

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }

        return true;
    }*/


    public static void main(String[] args) {
        String s = "aa bb";//grpctprutsmiwprhls ahurpe  | ygsimuzpdopaceydpz m |aa bb
        String t = "ab ab";//gthreipthrprmsprlpwu usca  | zmpyu pamdzyegsdciop |ab ab
//        s.charAt();
        System.out.println(nestedAnagrams(s, t));

    }

}
