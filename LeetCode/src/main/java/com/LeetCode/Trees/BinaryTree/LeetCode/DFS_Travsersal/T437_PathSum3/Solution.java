package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T437_PathSum3;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        int[] count = new int[1];
        dfs(root, targetSum, 0, count);
        return count[0];
    }
    private void dfs(TreeNode root, int targetSum, int sum, int[] count) {
        if(root == null)
            return;
        if(sum > targetSum)
            sum = root.data;
        else if(sum == targetSum)
            count[0]++;
        dfs(root.left, targetSum, sum, count);
        dfs(root.right, targetSum, sum, count);
    }
}
