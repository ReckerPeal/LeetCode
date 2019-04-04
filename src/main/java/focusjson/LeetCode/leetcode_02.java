package focusjson.LeetCode;

import java.util.List;

public class leetcode_02 {


    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode p = l1, q = l2, current = header;
        int carry = 0;
        while (p != null && q != null) {
            int sum = p.val + q.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            if (carry > 0) {
                current.next = new ListNode(carry);
            }
        }
        return header.next;
    }

    public static void main(String[] args) {
        leetcode_02 leetcode_02 = new leetcode_02();
        ListNode l1= new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2= new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode resut= leetcode_02.addTwoNumbers(l1,l2);
        System.out.println(resut);
    }

}
