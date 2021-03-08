package com.jzOffer;

import java.util.ArrayList;

public class JZ33 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int uglyNumber = solution.GetUglyNumber_Solution(7);
        System.out.println(uglyNumber);
    }

    static public class Solution {
        public int GetUglyNumber_Solution(int index) {
            if (index < 7)
                return index;
            int p2 = 0, p3 = 0, p5 = 0;
            int[] num = new int[index];
            num[0] = 1;
            for (int i = 1; i < index; i++) {
                num[i] = Math.min(num[p2] * 2, Math.min(num[p3] * 3, num[p5] * 5));
                if (num[i] == num[p2] * 2)
                    p2++;
                if (num[i] == num[p3] * 3)
                    p3++;
                if (num[i] == num[p5] * 5)
                    p5++;
            }
            return num[index - 1];
        }
    }
}
