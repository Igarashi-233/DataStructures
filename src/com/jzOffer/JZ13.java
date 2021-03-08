package com.jzOffer;


import java.util.ArrayList;

public class JZ13 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Solution solution = new Solution();
        solution.reOrderArray(array);
    }

    static class Solution {
        public void reOrderArray(int[] array) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int j : array) {
                if (j % 2 == 1) {
                    list1.add(j);
                } else {
                    list2.add(j);
                }
            }
            list1.addAll(list2);
            list1.toArray();
            System.out.println(list1);
        }
    }


}
