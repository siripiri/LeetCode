package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T110_BalancedBinaryTree;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode node) {
        return maxDepth(node) == -1 ? false : true;
    }
    private int maxDepth(TreeNode node) {
        if(node == null)
            return 0;

        int left = maxDepth(node.left);
        if(left == -1) return -1;

        int right = maxDepth(node.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
