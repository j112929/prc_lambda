package Hankerrank.amazon;/* package codechef; // don't place package name! */

import java.util.Objects;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
//        Scanner cin = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        while (true) {
//            String in = cin.nextLine();
//            if (in.equals("0")) {
//                break;
//            }
//            int ans = minSwaps(in);
//            sb.append(ans != -1 ? ans : "Impossible");
//            sb.append("\n");
//        }
//        System.out.print(sb.toString());
        String inp =
//                "01010110";//1
//                "01011001";//1
//                "1110";//-1
//                "0110001";//2
                "0100101";//2
//                "101000";//1
        System.out.println("original:"+inp);
        System.out.println(minSwaps1(inp));
    }
    public static boolean isPalindrome(String x) {
        return Objects.equals(x, new StringBuilder(x).reverse().toString());
    }

    public static boolean isValid(String s) {
        int[] counter = new int[2];
        for (char a : s.toCharArray()) {
//            System.out.println(a-'0');
            counter[a-'0']++;
        }
        int odd = 0;
        for (int i : counter) {
            if (i % 2 == 1) {
                odd++;
            }
        }
        //奇数个字符的数量最多只能有1个 才满足回文
        return odd <= 1;
    }
    //只判断需要交换的字符个数
    public static int minSwaps1(String inp) {
        int n = inp.length();
        int cnt0 = 0,cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if(inp.charAt(i)=='0') cnt0++;
            else cnt1++;
        }
        if(cnt1%2!=0 && cnt0%2!=0) return -1;
        boolean isOdd = cnt1 % 2 != 0 || cnt0 % 2 != 0;
        int c1=getCount1(inp.toCharArray(), isOdd, '0');
        int c2=getCount1(inp.toCharArray(), isOdd, '1');
        return Math.min(c1, c2);
    }

    private static int getCount1( char[] s,  boolean isOdd,  char exchangeChar) {
        int count = 0, n=s.length, mid=n/2;
        for (int l = 0; l < mid; l++) {
            if (s[l] != s[n - l-1]) {
                int exchangeInx = -1;
                if (s[l] != exchangeChar) {
                    if (n -l-2== mid && isOdd) {
                        swap(s, mid, n - l - 1);
                    }else {
                        exchangeInx = l;
                        for (int j = l + 1; j <= n - l - 1; j++) {
                            if(s[j] == exchangeChar){
                                swap(s, exchangeInx, j);
                                break;
                            }
                        }
                    }
                }
                if (s[n - l-1] != exchangeChar) {
                    if (l+1== mid && isOdd) {
                        swap(s, mid, l);
                    }else {
                        exchangeInx = n - l - 1;
                        for (int j = n - l - 2; j > -1; j--) {
                            if(s[j] == exchangeChar){
                                swap(s, exchangeInx, j);
                                break;
                            }
                        }
                    }
                }
                count++;
//                System.out.println(String.valueOf(s));
                if(isPalindrome(String.valueOf(s))){
                    break;
                }
            }
        }
        return count;
    }

    private static void swap(char[] s, int exchangeInx, int j) {
        char t = s[exchangeInx];
        s[exchangeInx] = s[j];
        s[j]=t;
    }


    //只能交换相邻的
    public static int minSwaps(String inp) {
        if (!isValid(inp)) {
            return -1;
        }
        if(isPalindrome(inp)) return 0;
        int n = inp.length();
        char[] s = inp.toCharArray();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            int left = i;
            int right = n - left - 1;
            while (left < right) {
                if (s[left] == s[right]) {
                    break;
                } else {
                    right--;
                }
            }
            if (left == right) {
                swap(s, left, left + 1);
                count++;
            } else {
                for (int j = right; j < n - left - 1; j++) {
                    swap(s, j, j + 1);
                    count++;
                }
            }
        }
        return count;
    }


}
