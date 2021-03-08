package com.jzOffer;

import java.util.ArrayList;

public class JZ29 {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        Solution solution = new Solution();
        ArrayList<Integer> list = solution.GetLeastNumbers_Solution(array, 10);
        System.out.println(list);
    }

    static public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            quickSort(input, 0, input.length - 1);
            ArrayList<Integer> list = new ArrayList<>();
            if (k <= input.length) {
                for (int i = 0; i < k; i++) {
                    list.add(input[i]);
                }
            }
            return list;
        }

        public static void quickSort(int arr[], int _left, int _right) {
            int left = _left;
            int right = _right;
            int temp = 0;
            if (left <= right) {
                temp = arr[left];
                while (left != right) {
                    while (left < right && arr[right] >= temp) {
                        right--;
                    }
                    arr[left] = arr[right];
                    while (left < right && arr[left] <= temp) {
                        left++;
                    }
                    arr[right] = arr[left];
                }
                arr[left] = temp;
                quickSort(arr, _left, left - 1);
                quickSort(arr, right + 1, _right);
            }
        }
    }
}
