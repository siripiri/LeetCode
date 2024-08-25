package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T124_BinaryTreeMaximiumPathSum;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }
    private int dfs(TreeNode root, int[] max) {
        if(root == null)
            return 0;
        int leftSubTree = dfs(root.left, max);
        int rightSubTree = dfs(root.right, max);

        max[0] = Math.max(max[0], leftSubTree+rightSubTree+root.data);

        return Math.max(leftSubTree, rightSubTree)+1;
    }
}
