package A;

class BinarySearch {
    static int binarySearchRec(int[] a, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        //求中间的下标
        int mid = (high + low) / 2;
        if (a[mid] == key) {
            return mid;
        } else if (key < a[mid]) {
            //小于中间值，从左边搜
            return binarySearchRec(a, key, low, mid - 1);
        } else {
            //大于中间值，从右边搜
            return binarySearchRec(a, key, mid + 1, high);
        }
    }

    static int binSearch(int[] a, int key) {
        return binarySearchRec(a, key, 0, a.length - 1);
    }

    static int binSearch1(int[] A, int key) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (A[mid] == key) {
                return mid;
            }
            if (key < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
        int[] inputs = {10, 49, 99, 110, 176};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("binSearch(arr, " + inputs[i] + ") = " + binSearch(arr, inputs[i]));
        }
    }
}