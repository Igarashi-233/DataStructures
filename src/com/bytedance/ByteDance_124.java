package com.bytedance;

public class ByteDance_124 {
    public static void main(String[] args) {
        Integer[] arr = {-10, 9, 20, null, null, 15, 7};
        TreeNode tree = TreeNode.constructTree(arr);
        Solution solution = new Solution();
        int maxPathSum = solution.maxPathSum(tree);
        System.out.println(maxPathSum);
    }

    static class Solution {
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return max;
        }

        /**
         * 返回经过root的单边分支最大和， 即Math.max(root, root+left, root+right)
         *
         * @param root
         * @return
         */
        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //计算左边分支最大值，左边分支如果为负数还不如不选择
            int leftMax = Math.max(0, dfs(root.left));
            //计算右边分支最大值，右边分支如果为负数还不如不选择
            int rightMax = Math.max(0, dfs(root.right));
            //left->root->right 作为路径与已经计算过历史最大值做比较
            max = Math.max(max, root.val + leftMax + rightMax);
            // 返回经过root的单边最大分支给当前root的父节点计算使用
            return root.val + Math.max(leftMax, rightMax);
        }
    }
}
