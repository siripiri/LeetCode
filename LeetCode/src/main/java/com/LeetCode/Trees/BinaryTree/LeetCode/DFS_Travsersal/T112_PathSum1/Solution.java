package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T112_PathSum1;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }
    private boolean dfs(TreeNode root, int targetSum, int sum) {
        if(root == null)
            return false;
        sum += root.data;
        if(root.left == null && root.right == null) {
            if(targetSum == sum)
                return true;
            else
                return false;
        }
        return dfs(root.left, targetSum, sum) || dfs(root.right, targetSum, sum);
    }
}
