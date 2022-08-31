package Hankerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Reverse Array Queries
 * For a given array of integers, perform operations on the array. Return the resulting array after all operations have been applied in the order given. Each operation contains two indices. Reverse the subarray between those zero-based indices, inclusive.
 * <p>
 * Example 1
 * arr = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
 * operations = [[0, 9], [4, 5], [3, 6], [2, 7], [1, 8], [0, 9]]
 * return [9, 1, 7, 3, 5, 4, 6, 2, 8, 0]
 * <p>
 * Ex2
 * The original array arr = [1, 2, 3].
 * Reverse arr[0] through arr[2]: arr' = [3, 2, 1].
 * Reverse arr'[1] through arr[2]: arr'' = [3, 1, 2].
 * Reverse arr''[0] through arr''[2]: arr''' = [2, 1, 3].
 * <p>
 * Ex3
 * The original array arr = [5, 2, 5, 1].
 * Reverse arr[1] through arr[2]: arr' = [5, 5, 2, 1].
 * Reverse arr'[1] through arr[1]: arr'' = [5, 5, 2, 1].
 * <p>
 * Ex4
 * 10
 * 640
 * 26
 * 276
 * 224
 * 737
 * 677
 * 893
 * 87
 * 422
 * 30
 * 10
 * 2
 * 0 9
 * 2 2
 * 5 5
 * 1 6
 * 5 6
 * 5 9
 * 0 8
 * 6 7
 * 1 9
 * 3 3
 * <p>
 * return
 * 87
 * 422
 * 30
 * 737
 * 224
 * 677
 * 893
 * 640
 * 26
 * 276
 */
public class B {
    public static void main(String[] args) {
        int[] arr1 = {10, 640, 26, 276, 224, 737, 677, 893, 87, 422, 30};
        int[][] arr2 = {{0, 9}, {2, 2}, {5, 5}, {1, 6}, {5, 6}, {5, 9}, {0, 8}, {6, 7}, {1, 9}, {3, 3}};
        List<Integer> arr = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<List<Integer>> operations = Arrays.stream(arr2).map(a1 -> Arrays.stream(a1).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        List<Integer> integers = performOperations(arr, operations);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }


    }

    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {


        for (int i = 0; i < operations.size(); i++) {
            List<Integer> op = operations.get(i);
            if (op.get(0).intValue() == op.get(1).intValue()) continue;
//            for (int i = 0; i < operations.size(); i++) {


            Integer tmp = arr.get(op.get(1));
            arr.set(op.get(1).intValue(), arr.get(op.get(0)));
            arr.set(op.get(0).intValue(), tmp);
//                System.out.println(tmp + "," + arr.get(op.get(0)));
//            }
            // Write your code here

        }
        return arr;
    }
}
