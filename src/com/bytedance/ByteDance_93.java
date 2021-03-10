package com.bytedance;

import java.util.ArrayList;
import java.util.List;

public class ByteDance_93 {
    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();
        List<String> list = solution.restoreIpAddresses(s);
        System.out.println(list);
    }

    static class Solution {
        private List<String> res;
        private StringBuilder path;
        private String s;

        public List<String> restoreIpAddresses(String s) {
            this.res = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return res;
            }
            this.s = s;
            path = new StringBuilder();
            dfs(0, 3);
            return res;
        }

        // start 表示截取子串的起点
        // resNum 表示剩余的ip段个数
        private void dfs(int start, int resNum) {
            // 如果所有ip段都已经找完了，添加答案到集合中并返回
            if (resNum == -1 && start == s.length()) {
                // 删除最后添加的点号
                path.setLength(path.length() - 1);
                res.add(path.toString());
                return;
            }
            // 如果遍历完字符串还没有找完ip，提前返回
            if (start == s.length()) {
                return;
            }

            char[] c = s.toCharArray();
            int pathLen = path.length();
            int len = c.length;

            // 子串右边界范围必须同时满足两个条件，取范围的交集
            // 1. 根据数字最多不能超过三位，最少一位得出：[start + 1, start + 3]
            // 2. 根据剩余还需要拼接的ip地址个数得出：[len - 3 * resNum, len - resNum]
            int max = Math.min(start + 3, len - resNum);
            int min = Math.max(start + 1, len - 3 * resNum);
            for (int i = min; i <= max; i++) {
                // 第一个字符为0，剪支
                if (i > start + 1 && c[start] == '0') {
                    break;
                }

                // 当前的数字越界，剪支
                String sub = s.substring(start, i);
                int num = Integer.parseInt(sub);
                if (num > 255) {
                    break;
                }

                path.append(sub).append(".");
                dfs(i, resNum - 1);
                path.setLength(pathLen);
            }
        }
    }
}
