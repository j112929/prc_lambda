package A;

public class LinkedList {
    public static LinkedListNode createLinkedList(int[] arr) {
        LinkedListNode node = new LinkedListNode();
        node.value = arr[0];
        for (int i = 1; i < arr.length; i++) {
            LinkedListNode tmpNode = new LinkedListNode();
            tmpNode.value = arr[i];
            node.next = tmpNode;
            node = node.next;
        }
        return node;
    }

    public static void display(LinkedListNode listHead) {
        while (listHead != null) {
            System.out.println(listHead.value);
            if (listHead.next == null) {
                break;
            }
            listHead = listHead.next;
        }
    }

    public static void insertAtTail(LinkedListNode list_head_1, LinkedListNode node1) {
        LinkedListNode tail = null;
        while (list_head_1.next != null) {
            tail = list_head_1.next;

            if (list_head_1.next.next == null) {
                list_head_1.next.next = node1;
            } else {
                list_head_1.next = list_head_1.next.next;
            }
        }
//        tail.next = node1;

    }
}
