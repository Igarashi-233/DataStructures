package com.sort_solutions;

import java.util.Arrays;
import java.util.LinkedList;

// 快速排序
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 10, 3, 2, 7, 16, 6, 1};
        System.out.println("快速排序前：" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1); //递归版本
        //noRecQuickSort(arr, 0, arr.length-1); //非递归版
        System.out.println("快速排序后：" + Arrays.toString(arr));
    }

    /**
     * 快速排序
     *
     * @param arr   排序的数组
     * @param left  数组的前针
     * @param right 数组后针
     */
    private static void quickSort(int[] arr, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int key = arr[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (arr[j] >= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (arr[i] <= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j)
                swap(arr, i, j);
        }

        arr[left] = arr[i];
        arr[i] = key;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


    /**
     * 非递归版快排
     */
    private static void noRecQuickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        //使用栈结构来存储一分为2的起始下标位置
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(right); //压栈
        stack.push(left);
        while (!stack.isEmpty()) {
            int l = stack.pop(); //出栈
            int r = stack.pop();
            int k = partitionSort(arr, l, r);
            //将原来递归中，左部分的起始下标压入栈存储
            if (l < k - 1) {
                stack.push(k - 1);
                stack.push(l);
            }
            if (k + 1 < r) {
                stack.push(r);
                stack.push(k + 1);
            }
        }
    }

    private static int partitionSort(int[] arr, int left, int right) {
        int key = arr[left], i = left, j = right;
        while (i < j) {
            while (arr[j] >= key && i < j) j--;
            while (arr[i] <= key && i < j) i++;
            if (i < j) swap(arr, i, j);
        }
        arr[left] = arr[i];
        arr[i] = key;
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}