package Hankerrank;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>((int) (1 * 1.25));
        System.out.println();
        List<ListNode> lists = new ArrayList<>();
//        Collections.sort(lists);
        Collections.sort(lists, (o1, o2) -> Integer.compare(o1.val, o2.val));
//        int a= 010;//8
        int a = 0x000F;
        int b = 0x2222;
//        int b = 07;
        System.out.println(a & b);
//        System.out.println(b);
// /* //// */
        /* /* */
        System.out.println(0x02);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<Integer>(deque);

        new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }};
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }


    }
}
