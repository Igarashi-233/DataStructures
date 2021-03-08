package com.jzOffer;

import java.util.*;

public class JZ27 {
    public static void main(String[] args) {
        String str = "abc";
        Solution solution = new Solution();
        ArrayList<String> list = solution.Permutation(str);
        System.out.println(list);

    }

    static class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> list = new ArrayList<>();
            char[] strArray = str.toCharArray();
            PermHelper(strArray, list, 0);
            return new ArrayList<>(new TreeSet<>(list));
        }

        public void PermHelper(char[] cs, ArrayList<String> list, int num) {
            if (num == cs.length - 1) {
                list.add(new String(cs));
            }

            for (int i = num; i < cs.length; i++) {
                if (i == num || cs[i] != cs[num]) {
                    swap(cs, i, num);
                    PermHelper(cs, list, num + 1);
                    swap(cs, i, num);
                }
            }
        }

        public void swap(char[] c, int i, int j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }
}
