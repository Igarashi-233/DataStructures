package com.bytedance;

public class ByteDance_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }

    static class Solution {
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1, res = 0;
            while (i < j) {
                res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
            }
            return res;
        }
    }
}
