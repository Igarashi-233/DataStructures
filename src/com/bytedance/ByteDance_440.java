package com.bytedance;

import java.util.Scanner;

public class ByteDance_440 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        Solution solution = new Solution();
        int kthNumber = solution.findKthNumber(n, k);
        System.out.println(kthNumber);
    }

    static class Solution {
        public int findKthNumber(int n, int k) {
            int cur = 1;
            k--;
            while (k > 0) {
                long count = 0, first = cur, next = cur + 1;
                while (first <= n) {
                    count += Math.min(next, n + 1) - first;
                    first *= 10;
                    next *= 10;
                }
                if (count > k) {
                    k--;
                    cur *= 10;
                } else {
                    k -= count;
                    cur++;
                }
            }
            return cur;
        }
    }
}
