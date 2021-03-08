package com.sort_solutions;

import java.util.Arrays;

// 冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 10, 3, 2, 7, 16, 6, 1};
        System.out.println("冒泡排序前：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("冒泡排序后：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr 待排数组
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //比较交换
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    /**
     * @param arr 原数组
     * @param i   需要交换的数组元素下标
     * @param j   需要交换的数组元素下标
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}