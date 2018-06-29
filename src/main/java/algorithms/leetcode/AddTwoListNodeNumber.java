package algorithms.leetcode;

public class AddTwoListNodeNumber {

    /**
     *
     给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     示例：
     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     */

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {

        ListNode(int x) {
            val = x;
        }

        int val;
        ListNode next;
    }

    //两个逆序链表表示的整数相加 如 3->1->5 + 2->1->6 = 5->2->1->1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l2 == null) {
            return l1;
        }
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2.val;
        int total = val1 + val2;
        int mod = total / 10;
        ListNode sum = new ListNode(total - mod * 10);
        if (mod > 0) {
            if (l2.next == null) {
                l2.next = new ListNode(mod);
            } else {
                l2.next.val += 1;
            }
        }
        sum.next = addTwoNumbers(l1 == null ? null : l1.next, l2.next);
        return sum;
    }

    //官方解答
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        //test code
    }
}
