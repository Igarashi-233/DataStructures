package com.sort_solutions;

import java.util.Arrays;

// 选择排序
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 10, 3, 2, 7, 16, 6, 1};
        System.out.println("选择排序前：" + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("选择排序后：" + Arrays.toString(arr));

    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j])
                    k = j;
            }
            if (i != k) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }


}