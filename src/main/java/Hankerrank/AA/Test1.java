package Hankerrank.AA;

import java.util.Arrays;

public class Test1 {
    static int[] arr = new int[]{4, 3, 7, 8, 6, 2, 1};

    static void zigZag() {
        // sort the array usinf the sort function
        // Arrays.
        // Arrays.sort(arr, Collections.reverseOrder());
        // traverse the array from 1 to N -1
        for (int i = 1; i <= arr.length - 2; i += 2) {
            // swap the current element with the next
            // element
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        zigZag();
        // print the complete array
        System.out.println(Arrays.toString(arr));
    }
}
