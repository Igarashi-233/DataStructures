package com.sort_solutions;

import java.util.Arrays;

// 插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 10, 3, 2, 7, 16, 6, 1};
        System.out.println("插入排序前：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("插入排序后：" + Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        //为什么i是从1开始呢，因为第0个元素只有一个，本来就有序
        for (int i = 1; i < arr.length; i++) {
            //寻找arr[i]合适的插入位置;j保存元素temp应该插入的位置
            int temp = arr[i], j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }
}