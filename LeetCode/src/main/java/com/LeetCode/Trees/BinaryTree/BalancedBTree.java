package com.LeetCode.Trees.BinaryTree;

public class BalancedBTree {
    private final Height height;

    BalancedBTree(Height height) {
        this.height = height;
    }

    public boolean isBalanced(TreeNode node) {
        if(node == null)
            return true;
        
        int leftSubTree = this.height.heightRecursive(node.left);
        int rightSubTree = this.height.heightRecursive(node.right);

        if(Math.abs(leftSubTree-rightSubTree) > 1)
            return false;

        boolean left = isBalanced(node.left);
        boolean right = isBalanced(node.right);

        // If any node fails then return false;
        if(!left || !right) return false;

        // all left and right is tree so return true
        return true;

    }
}
