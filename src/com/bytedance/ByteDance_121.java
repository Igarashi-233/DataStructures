package com.bytedance;

public class ByteDance_121 {
    public static void main(String[] args) {
        int[] prices = {7, 5, 3, 1};
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                } else if (price - minPrice >= maxProfit) {
                    maxProfit = price - minPrice;
                }
            }
            return maxProfit;
        }
    }
}
