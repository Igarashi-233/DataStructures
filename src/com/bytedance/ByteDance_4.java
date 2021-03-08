package com.bytedance;

public class ByteDance_4 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4};
        int[] nums2 = new int[]{1, 2};
        Solution solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length = nums1.length + nums2.length;
            int pre = -1, p = -1;
            int start1 = 0, start2 = 0;
            for (int i = 0; i <= length / 2; i++) {
                pre = p;
                // start2 == nums2.length 为了避免nums2越界
                if (start1 < nums1.length && (start2 == nums2.length || nums1[start1] <= nums2[start2])) {
                    p = nums1[start1++];
                } else if (start2 < nums2.length) {
                    p = nums2[start2++];
                }
            }
            return (length % 2 == 0) ? (p + pre) / 2.0 : p;
        }
    }
}
