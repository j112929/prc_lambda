package A;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class A {
    public static int coutingAnologouArrays(int[] conDiff, int lower, int uppper) {
        if (conDiff.length == 1) {
            return 1;
        }
        return recursiveCouting(conDiff, lower, uppper, lower);
    }

    public static int recursiveCouting(int[] conDiff, int lower, int uppper, int initLower) {
        int[] arr = new int[conDiff.length + 1];
        arr[0] = lower;
        for (int i = 1; i < conDiff.length; i++) {
            arr[i] = arr[i - 1] - conDiff[i - 1];
            if (arr[i] > uppper) {
                return lower - initLower;
            }
        }
        lower++;
        return recursiveCouting(conDiff, lower, uppper, initLower);
    }

    public static int coutingAnologouArrays(Vector<Integer> conDiff, int lower, int uppper) {
        if (conDiff.size() == 1) {
            return 1;
        }
        return recursiveCouting(conDiff, lower, uppper, lower);
    }

    public static int recursiveCouting(Vector<Integer> conDiff, int lower, int uppper, int initLower) {
        Vector<Integer> arr = new Vector<Integer>();
        arr.add(lower);
        for (int i = 1; i < conDiff.size(); i++) {
            arr.add(arr.get(i - 1) - conDiff.get(i - 1));
            if (arr.get(i) > uppper) {
                return lower - initLower;
            }
        }
        lower++;
        return recursiveCouting(conDiff, lower, uppper, initLower);
    }

    public static int coutingAnologouArrays(List<Integer> conDiff, int lower, int uppper) {
        if (conDiff.size() == 1) {
            return 1;
        }
        return recursiveCouting(conDiff, lower, uppper, lower);
    }

    public static int recursiveCouting(List<Integer> conDiff, int lower, int uppper, int initLower) {
        List<Integer> arr = new ArrayList<>();
        arr.add(lower);
        for (int i = 1; i < conDiff.size(); i++) {
            arr.add(arr.get(i - 1) - conDiff.get(i - 1));
            if (arr.get(i) > uppper) {
                return lower - initLower;
            }
        }
        lower++;
        return recursiveCouting(conDiff, lower, uppper, initLower);
    }

    public static void main(String[] args) {
        //i.
//        Vector<Integer> v = new Vector<>();
//        v.add(-2);
//        v.add(-1);
//        v.add(-2);
//        v.add(5);
        //i.i
//        Integer[] a = new Integer[]{-2, -1, -2, 5};
//        List<Integer> list=new ArrayList<>(Arrays.asList(a));
//        Vector<Integer> v=new Vector<>(list);
        //ii.
        int[] v = new int[]{-2, -1, -2, 5};
        //iii.
//        Integer[] a = new Integer[]{-2, -1, -2, 5};
//        List<Integer> v=new ArrayList<>(Arrays.asList(a));
        int r = coutingAnologouArrays(v, 3, 10);
        System.out.println(r);
    }
}
