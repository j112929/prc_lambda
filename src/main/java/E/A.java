package E;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class A {
    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        int n = operations.size() - 1;
        int max = Integer.MIN_VALUE;
        Deque<String> stack = new LinkedList<String>();
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            String str = operations.get(n);
            String[] arr = str.split(" ");
            if (arr.length > 1) {
                System.out.print(arr[0]);
                System.out.println(arr[1]);
                list.add(Integer.valueOf(arr[0]));
                list.add(Integer.valueOf(arr[1]));
            } else {
                System.out.println(arr[0]);
                list.add(Integer.valueOf(arr[0]));
            }
//            if(!stack.isEmpty()) {
//                System.out.println(stack.peek());
//            }


            n--;
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
