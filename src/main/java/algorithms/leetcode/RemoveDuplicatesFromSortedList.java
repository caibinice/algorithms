package algorithms.leetcode;

public class RemoveDuplicatesFromSortedList {

/**
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2
 Example 2:

 Input: 1->1->2->3->3
 Output: 1->2->3
 */


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode lastNode = head;
        while (lastNode != null && lastNode.next != null) {
            if (lastNode.next.val == lastNode.val) {
                lastNode.next = lastNode.next.next;
            } else {
                lastNode = lastNode.next;
            }
        }
        return head;
    }


    /**
     * Version 2
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2->3->3->4->4->5
     * Output: 1->2->5
     * Example 2:
     * <p>
     * Input: 1->1->1->2->3
     * Output: 2->3
     */
    //暴力遍历法,O(n)time, O(1)space
    public ListNode deleteDuplicatesII(ListNode head) {
        if (head == null) return null;
        int currentVal = head.val;
        boolean first = true;
        while (head != null) {
            if (head.next == null) {
                if (first) {
                    break;
                } else {
                    if (currentVal == head.val) return null;
                    return head;
                }
            }
            if (head.val == head.next.val) {
                first = false;
                currentVal = head.val;
                head = head.next.next;
            } else if (currentVal == head.val) {
                if (first) break;
                currentVal = head.val;
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null || head.next == null) return head;
        int val = head.val;
        ListNode current = head.next;
        ListNode last = head;
        while (current != null) {
            if (val == current.val) {
                current = current.next;
                last.next = current;
            } else if (current.next == null || current.val != current.next.val) {
                last = current;
                current = current.next;
            } else {
                val = current.val;
                last.next = current.next;
                current = current.next;
            }
        }
        return head;
    }

    //先做一个假的head
    public ListNode deleteDuplicatesIIV2(ListNode head) {
        if (head == null) return null;
        ListNode FakeHead = new ListNode(0);
        FakeHead.next = head;
        ListNode pre = FakeHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return FakeHead.next;
    }

}
