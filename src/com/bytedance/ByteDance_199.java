package com.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ByteDance_199 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, null, 5, null, 4};
        TreeNode tree = TreeNode.constructTree(arr);
        Solution solution = new Solution();
        ArrayList<Integer> list = solution.rightSideView(tree);
        System.out.println(list);
    }

    static class Solution {
        public ArrayList<Integer> rightSideView(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (i == size - 1) {
                        list.add(node.val);
                    }
                }
            }
            return list;
        }
    }
}
