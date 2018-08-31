package algorithms.leetcode;

import algorithms.LinkedList.ListNode;

import java.util.HashSet;

public class LinkedListCycle {

    /**
     * Given a linked list, determine if it has a cycle in it.
     * <p>
     * Follow up:
     * Can you solve it without using extra space?
     */

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        set.add(head);
        while (head != null) {
            if (!set.add(head.next))
                return true;
            head = head.next;
        }
        return false;
    }

    //O(1) space
    public boolean hasCycleV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
