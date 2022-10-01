package leetcode;

import java.util.BitSet;

public class C {
    public static void main(String[] args) {

    }
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        BitSet bit=new BitSet(n);
        for(int i=2;i*i<n;i++){
            if(!bit.get(i)){
                for(int j=i*i;j<n;j+=i){
                    bit.set(j);
                }
            }
        }
        return n-2-bit.cardinality();//排除n和1
    }

    public ListNode reverseGroup(ListNode head, int k){
        if(head==null || head.next ==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next !=null){
            //from 0-》k-1
            for (int i = 0; i < k&&end!=null ; i++) {
                end=end.next;
            }
            if(end == null) break;
            //第(k+1) node
            ListNode next = end.next;
            end.next = null;

            //1th node
            ListNode start = pre.next;
            //start从正序变成倒序， pre.next = 第n个
            ListNode result;
            if(start ==null || start.next ==null) {
                result = start;
            } else {
                ListNode pre1 = null, cur = start, next1 = null;
                while (cur != null) {
                    next1 = cur.next;
                    // 下-》上-》中
                    cur.next = pre1;//交换下一个和上一个
                    pre1 = cur;//交换上一个和当前
                    cur = next1;//交换当前和下一个
                }
                result = pre1;
            }
            pre.next = result;
            // 下-》上-》中
            start.next = next;// kth -》 2th

            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
