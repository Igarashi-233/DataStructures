package com.bytedance;

import java.util.ArrayList;
import java.util.List;

public class ByteDance_143 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4};
        ListNode head = ListNode.createLinkedList(x);
        Solution solution = new Solution();
        solution.reorderList(head);

        ListNode.printLinkedList(head);
    }

    static class Solution {
        public void reorderList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;
                if (i == j) {
                    break;
                }
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;
        }
    }
}
