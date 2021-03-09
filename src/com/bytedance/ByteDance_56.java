package com.bytedance;

import java.util.Arrays;
import java.util.Comparator;

public class ByteDance_56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution solution = new Solution();
        int[][] merge = solution.merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing(v -> v[0]));
            int[][] res = new int[intervals.length][2];
            int idx = -1;
            for (int[] interval : intervals) {
                if (idx == -1 || interval[0] > res[idx][1]) {
                    idx++;
                    res[idx] = interval;
                } else {
                    res[idx][1] = Math.max(interval[1], res[idx][1]);
                }
            }
            return Arrays.copyOf(res, idx + 1);
        }
    }
}

