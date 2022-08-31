package A;


class Reverse {
    public static LinkedListNode reverse(LinkedListNode head) {
        // no need to reverse if head is null
        // or there is only 1 node.
        if (head == null || head.next == null) {
            return head;
        }
//    LinkedListNode reversedList = reverse(head.next);
//
//    head.next.next = head;
//    head.next = null;
//    return reversedList;

        LinkedListNode reversedList = head;
        while (head.next != null) {
            //先把第二个给了临时节点的第一个
            LinkedListNode temp = head.next;
            //第三个给了第二个
            head.next = head.next.next;
            //第一个给了临时节点的第二个:头结点挂在第二个后边
            temp.next = reversedList;
            //临时节点给了逆转后的节点
            reversedList = temp;
        }
        return reversedList;
    }

    public static void main(String[] args) {
        LinkedListNode listHead = null;
        int[] arr = {7, 14, 21, 28};
        listHead = LinkedList.createLinkedList(arr);

        System.out.print("Original: ");
        LinkedList.display(listHead);

        listHead = reverse(listHead);
        System.out.print("After Reverse: ");
        LinkedList.display(listHead);
    }
}  