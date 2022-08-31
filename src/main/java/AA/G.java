package AA;

public class G {

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int l = 0; l < n; l += 2 * k) {
            int r = l + k - 1;
            reverse(cs, l, Math.min(r, n - 1));
        }
        char c = '0';
        return
//                cs.toString().;
                String.valueOf(cs);
    }

    void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
    }
}
