package algorithms.leetcode;

import algorithms.LinkedList.ListNode;

public class RemoveLinkedListElements {

    /**
Remove all elements from a linked list of integers that have value val.
Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode curr = first;
        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return first.next;
    }

    //recursion
    public ListNode removeElementsV2(ListNode head, int val) {
        if(head == null) return null;
        ListNode next = removeElementsV2(head.next, val);
        if(head.val == val) return next;
        head.next = next;
        return head;
    }

}