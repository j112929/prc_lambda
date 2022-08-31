package AA;

import com.alibaba.fastjson.JSON;

public class F {
    public static void main(String[] args) {
//        Arrays.sort();
        Node n =
//                null;
                new Node();
//        n.val = 1;
        n.val = 3;
        n.next = new Node(4);
        n.next.next = new Node(1);
        long l = System.currentTimeMillis();
        n = new F().insert2(n, 0);
        long s = System.currentTimeMillis();
        System.out.println(JSON.toJSONString(n));
        System.out.println(s - l);
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            return new Node(insertVal);
        }
        if (head.next == null) {
            head.next = new Node(insertVal);
            return head;
        }
        Node tmp = head.next;
        while (tmp != null) {
            if (tmp.next == null) {
                tmp.next = new Node(insertVal);
                break;
            }
            tmp = tmp.next;
        }
        return head;

    }

    public Node insert2(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node max = null;
        Node cur = head;
        do {
            if (insertVal >= cur.val && insertVal <= cur.next.val) {

                cur.next = new Node(insertVal, cur.next);
                return head;
            }
            if (cur.next != null && cur.val > cur.next.val) {
                max = cur;
            }
            cur = cur.next;
        } while (cur != head && cur != null);
        max = max == null ? cur : max;
        max.next = new Node(insertVal, max.next);
        return head;

    }
}

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
