package Hankerrank;

import java.util.ArrayList;
import java.util.List;

public class D {
    public static long getMinimumSum(List<Integer> arr) {
        int n = arr.size();
        long sum = 0L;
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            if (arr.get(i).intValue() < arr.get(j).intValue()) {
                for (int k = i + 2; k < n; k++) {
                    if (arr.get(j).intValue() > arr.get(k).intValue()) {
                        sum = arr.get(i).intValue() + arr.get(j).intValue() + arr.get(k).intValue();
                        // System.out.println(arr.get(i).intValue()+ ":"+ sum);
                        ans = Math.min(ans, sum);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
    }

    public static void splitHandle(String[] s, int[][] q, int[] ans) {
        int remainder = s.length % 5000;
        int quotient = s.length / 5000;
        int n = remainder != 0 ? quotient + 1 : quotient;
        List<String> tmp = null;
        for (int i = 0; i < n; i++) {
            List<String> value = new ArrayList<>();
            int start = i * 5000;
            int end = i == n - 1 ? s.length : (i + 1) * 5000;
            for (int j = start; j < end; j++) {
                int flag = 0;
                String str1 = s[q[i][0]];
                String str2 = s[q[i][1]];
                int minLen = Math.min(str1.length(), str2.length());
                // System.out.println("minLen:"+minLen);
                for (int k = 1; k <= minLen; k++) {
                    // System.out.println(i+":str1:"+str1.substring(0,j));
                    // System.out.println(i+":str2:"+str2.substring(0,j));
                    if (!str1.substring(0, j).equals(str2.substring(0, j))) {
                        // System.out.println("count:"+j);
                        break;
                    }
                    ans[i]++;
                    flag = 1;
                }
                if (flag == 0) ans[i] = 0;
            }
        }
    }

    public static List<String[]> averageAssign(String[] source) {
        List<String[]> result = new ArrayList<>();
        int remainder = source.length % 5000;
        int quotient = source.length / 5000;
        int n = remainder != 0 ? quotient + 1 : quotient;
        String[] value = null;
        for (int i = 0; i < n; i++) {
            int s = i * 5000;
            int e = i == n - 1 ? source.length : (i + 1) * 5000;
            value = new String[e - s];
            for (int j = s; j < e; j++) {
                value[j] = source[j];
            }
            result.add(value);
        }
        return result;
    }

    public static List<int[][]> averageAssign(int[][] source) {
        List<int[][]> result = new ArrayList<>();
        int remainder = source.length % 5000;
        int quotient = source.length / 5000;
        int n = remainder != 0 ? quotient + 1 : quotient;
        int[][] value = null;
        for (int i = 0; i < n; i++) {
            int s = i * 5000;
            int e = i == n - 1 ? source.length : (i + 1) * 5000;
            value = new int[e - s][2];
            for (int j = s; j < e; j++) {
                value[i] = source[j];
            }
            result.add(value);
        }
        return result;
    }

    public int[] queryLCP(String[] arr, int[][] q) {
        // write your code here
        int row = q.length;
//        int col = q[0].length;
        int[] ans = new int[row];

        if (row <= 5000) {
            for (int i = 0; i < q.length; i++) {
//                AtomicInteger flag = new AtomicInteger();
                int flag = 0;
                String str1 = arr[q[i][0]];
                String str2 = arr[q[i][1]];
                int minLen = Math.min(str1.length(), str2.length());
                // System.out.println("minLen:"+minLen);
//                int finalI = i;
                for (int j = 1; j <= minLen; j++) {
                    // System.out.println(i+":str1:"+str1.substring(0,j));
                    // System.out.println(i+":str2:"+str2.substring(0,j));
                    if (!str1.substring(0, j).equals(str2.substring(0, j))) {
                        // System.out.println("count:"+j);
                        break;
                    }
                    ans[i]++;
                    flag = 1;
//                        flag.getAndAdd(1);
                }
//                    if(flag.get() ==0) ans[i]=0;
                if (flag == 0) ans[i] = 0;
//                };

            }
        } else {
            List<String[]> splitStrList = averageAssign(arr);
            List<int[][]> splitIntList = averageAssign(q);
            for (int k = 0; k < splitIntList.size(); k++) {
                String[] subArr = splitStrList.get(k);
                int[][] subQ = splitIntList.get(k);
                Runnable r = () -> {
                    for (int i = 0; i < subQ.length; i++) {
                        int flag = 0;
                        String str1 = subArr[subQ[i][0]];
                        String str2 = subArr[subQ[i][1]];
                        int minLen = Math.min(str1.length(), str2.length());
                        // System.out.println("minLen:"+minLen);
                        for (int j = 1; j <= minLen; j++) {
                            // System.out.println(i+":str1:"+str1.substring(0,j));
                            // System.out.println(i+":str2:"+str2.substring(0,j));
                            if (!str1.substring(0, j).equals(str2.substring(0, j))) {
                                // System.out.println("count:"+j);
                                break;
                            }
                            ans[i]++;
                            flag = 1;
                        }
                        if (flag == 0) ans[i] = 0;
                    }
                };

            }
        }


        return ans;
    }
}
