package algorithms.leetcode;

import algorithms.LinkedList.ListNode;

import java.util.LinkedList;
import java.util.List;

public class RemoveNthNodeFromEndofList {

    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     * <p>
     * Example:
     * <p>
     * Given linked list: 1->2->3->4->5, and n = 2.
     * <p>
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * <p>
     * Given n will always be valid.
     * <p>
     * Follow up:
     * <p>
     * Could you do this in one pass?
     */
    //O(n)time, O(n) space，one pass,直接用List记录遍历的节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new LinkedList<>();
        while (head != null) {
            ListNode tmp = head;
            list.add(tmp);
            head = head.next;
        }
        int size = list.size();
        if (size <= 1) return null;
        int index = size - n;
        ListNode next = null;
        if (index < size - 1) next = list.get(index + 1);
        if (index > 0) list.get(index - 1).next = next;
        return index == 0 ? list.get(1) : list.get(0);
    }

    //双指针法，one pass .第一个指针先往前走n步，然后两个指针同时往前走，
    // 直到第二个指针走到末尾，则第一个指针就在倒数第n个位置
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

