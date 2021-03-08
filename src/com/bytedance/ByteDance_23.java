package com.bytedance;

public class ByteDance_23 {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {2, 6};
        ListNode list1 = ListNode.createLinkedList(arr1);
        ListNode list2 = ListNode.createLinkedList(arr2);
        ListNode list3 = ListNode.createLinkedList(arr3);
        ListNode[] lists = {list1, list2, list3};
        Solution solution = new Solution();
        ListNode newList = solution.mergeKLists(lists);
        ListNode.printLinkedList(newList);
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null | lists.length == 0) {
                return null;
            }
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int mid = (left + right) / 2;
            ListNode l1 = merge(lists, left, mid);
            ListNode l2 = merge(lists, mid + 1, right);
            return merge2Lists(l1, l2);
        }

        private ListNode merge2Lists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val <= l2.val) {
                l1.next = merge2Lists(l1.next, l2);
                return l1;
            } else {
                l2.next = merge2Lists(l2.next, l1);
                return l2;
            }
        }
    }
}
