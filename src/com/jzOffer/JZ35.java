package com.jzOffer;

public class JZ35 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        Solution solution = new Solution();
        int pairs = solution.InversePairs(array);
        System.out.println(pairs);
    }

    static public class Solution {
        private int cnt;

        private void MergeSort(int[] array, int start, int end) {
            if (start >= end)
                return;
            int mid = (start + end) / 2;
            MergeSort(array, start, mid);
            MergeSort(array, mid + 1, end);
            MergeOne(array, start, mid, end);
        }

        private void MergeOne(int[] array, int start, int mid, int end) {
            int[] temp = new int[end - start + 1];
            int k = 0, i = start, j = mid + 1;
            while (i <= mid && j <= end) {
                if (array[i] <= array[j])
                    temp[k++] = array[i++];
                else {
                    temp[k++] = array[j++];
                    cnt = (cnt + (mid - i + 1)) % 1000000007;
                }
            }
            while (i <= mid)
                temp[k++] = array[i++];
            while (j <= end)
                temp[k++] = array[j++];
            if (k >= 0)
                System.arraycopy(temp, 0, array, start, k);
        }

        public int InversePairs(int[] array) {
            MergeSort(array, 0, array.length - 1);
            return cnt;
        }
    }
}
