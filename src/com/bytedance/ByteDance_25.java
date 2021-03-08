package com.bytedance;

public class ByteDance_25 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4};
        Solution solution = new Solution();
        ListNode head = ListNode.createLinkedList(x);
        // 反转前
        System.out.println("反转前");
        ListNode.printLinkedList(head);

        ListNode newHead = solution.reverseKGroup(head, 3);
        // 反转后
        System.out.println("反转后");
        ListNode.printLinkedList(newHead);
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy;
            ListNode end = dummy;

            while (true) {
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                pre.next = reverseListNode(start);
                start.next = next;
                pre = start;
                end = start;
            }
            return dummy.next;
        }

        private ListNode reverseListNode(ListNode start) {
            ListNode cur = start;
            ListNode pre = null;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}
