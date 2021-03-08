package com.bytedance;

import java.util.Arrays;

public class ByteDance_31 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 5};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            for (int i = len - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, len);
                    for (int j = i; j < len; j++) {
                        if (nums[j] > nums[i - 1]) {
                            int tmp = nums[i - 1];
                            nums[i - 1] = nums[j];
                            nums[j] = tmp;
                            return;
                        }
                    }
                }
            }
            Arrays.sort(nums);
        }
    }
}
