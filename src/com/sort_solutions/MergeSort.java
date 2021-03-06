package com.sort_solutions;

import java.util.Arrays;

// 归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 10, 3, 2, 7, 16, 6, 1};
        System.out.println("归并排序前：" + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("归并排序后：" + Arrays.toString(arr));
    }

    /**
     * 递归使用归并排序，对arr[l...r]的范围进行排序（前闭区间，后闭区间）
     *
     * @param arr   待排序数组
     * @param left  数组左
     * @param right
     */
    private static void mergeSort(int[] arr, int left, int right) {
        //对于递归，要处理递归到底的判断，这里就是left>=right。
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right); //将左右两部分，利用临时数组进行归并
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param left
     * @param mid
     * @param right i:临时数组左边比较的元素下标；j:临时数组右边比较的元素的下标；k:原数组将要放置的元素下标
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] aux = new int[right - left + 1]; //临时辅助数组
        /*减去的left是原数组相对于临时数组的偏移量*/
        if (right + 1 - left >= 0)
            System.arraycopy(arr, left, aux, 0, right + 1 - left);

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) { //检查左下标是否越界
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) { //检查右下标是否越界
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] <= aux[j - left]) {
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }

}