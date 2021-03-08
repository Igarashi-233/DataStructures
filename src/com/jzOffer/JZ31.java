package com.jzOffer;

import java.util.Scanner;

public class JZ31 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Solution solution = new Solution();
        int result = solution.NumberOf1Between1AndN_Solution(num);
        System.out.println(result);
    }

    static public class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            int digit = 1, res = 0;
            int high = n / 10, cur = n % 10, low = 0;
            while (high != 0 || cur != 0) {
                if (cur == 0) {
                    res += high * digit;
                } else if (cur == 1) {
                    res += high * digit + low + 1;
                } else {
                    res += (high + 1) * digit;
                }
                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;
        }
    }
}
