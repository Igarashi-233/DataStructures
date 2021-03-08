package com.leetcode;

import java.util.PriorityQueue;

public class LC215 {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        Solution solution = new Solution();
        int kthLargest = solution.findKthLargest(array, 4);
        System.out.println(kthLargest);
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Java 默认为小顶堆
            for (int i = 0; i < k; i++) {
                minHeap.add(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (nums[i] <= minHeap.peek()) {
                    // 若 nums[i] 大于等于堆顶元素，弹出堆顶元素并将 nums[i] 入堆
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
            return minHeap.peek();
        }
    }
}
