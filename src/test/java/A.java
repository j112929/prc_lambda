import java.util.ArrayList;
import java.util.List;

public class A {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
//         ListNode p =head;
        while (head != null) {
            // 把值存入数组
            vals.add(head.val);
            head = head.next;
        }
        int n = vals.size();
        // System.out.println(n);
        for (int i = 0; i < n / 2; i++) {
            if (!vals.get(i).equals(vals.get(n - 1 - i))) return false;
            //此处直接拿vals.get(i)，vals.get(n-1-i)对比哪怕值相等也会出错
            // 可能是==比较的是地址，故需重新赋值，如果有人晓得此处原理，欢迎告知
//             int a=vals.get(i) , b=vals.get(n-1-i);
//             // 如果a != b则不是回文
//             if(a != b){
//                 return false;
//             }
        }
        return true;
    }

    public class ListNode {
        public int val;
        public ListNode next;
    }
}
