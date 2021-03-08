package com.bytedance;

public class ByteDance_33 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        int search = solution.search(nums, 1);
        System.out.println(search);
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }

                if (target >= nums[0]) {
                    if (nums[mid] < nums[0]) {
                        nums[mid] = Integer.MAX_VALUE;
                    }
                } else {
                    if (nums[mid] >= nums[0]) {
                        nums[mid] = Integer.MIN_VALUE;
                    }
                }

                if (target >= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
