package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T129_SumRootToLeafNumbers;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Solution {
    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        dfs(root, 0, res);
        return res[0];
    }
    public void dfs(TreeNode root, int sum, int[] res) {
        if(root == null)
            return;

        sum = (sum*10) + root.data;

        if(root.left == null && root.right == null)
            res[0] += sum;

        dfs(root.left, sum, res);
        dfs(root.right, sum, res);
    }
}
