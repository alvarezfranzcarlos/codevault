import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoLists {
    public ListNode getNext(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = getNext(l1.next, l2);
            return l1;
        } else {
            l2.next = getNext(l1, l2.next);
            return l2;
        }
    }

    public ListNode convertArrayToListNode(int[] array) {
        if (array == null || array.length == 0)
            return null;
        ListNode nodeZero = new ListNode(array[0]);
        ListNode currentNode = nodeZero;

        for (int i = 1; i < array.length; i++) {
            currentNode.next = new ListNode(array[i]);
            currentNode = currentNode.next;
        }

        return nodeZero;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] intArr1 = { 1, 3, 5, 7, 9, 11 };
        int[] intArr2 = { 2, 4, 5, 6, 8 };

        ListNode node1 = solution2.convertArrayToListNode(intArr1);
        ListNode node2 = solution2.convertArrayToListNode(intArr2);
        ListNode result = solution2.getNext(node1, node2);

        ListNode currentNode = result;
        while (currentNode != null) {
            System.out.println("convertArrayToListNode: " + currentNode.val);
            currentNode = currentNode.next;
        }
    }
}
