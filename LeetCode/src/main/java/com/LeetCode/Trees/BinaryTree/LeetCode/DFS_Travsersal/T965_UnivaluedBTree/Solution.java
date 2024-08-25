package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T965_UnivaluedBTree;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.data;
        return dfs(root, val);
    }
    private boolean dfs(TreeNode root, int val) {
        if(root == null)
            return true;
        if(val != root.data)
            return false;
        return dfs(root.left, val) && dfs(root.right, val);
    }
}
