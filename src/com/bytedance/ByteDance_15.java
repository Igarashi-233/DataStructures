package com.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteDance_15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = solution.threeSum(nums);
        System.out.println(list);
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            int length = nums.length;
            if (length < 3) {
                return list;
            }
            // 排序
            Arrays.sort(nums);

            for (int i = 0; i < length; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int L = i + 1;
                int R = length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0) {
                        list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        L++;
                        R--;
                    } else if (sum < 0) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
            return list;
        }
    }

}

