package com.LeetCode.Trees.BinaryTree;

public class BalancedBTree {
    private final Height height;

    BalancedBTree(Height height) {
        this.height = height;
    }

    public boolean isBalanced(TreeNode node) {
        return maxDepth(node) == -1 ? false : true;
    }

    private int maxDepth(TreeNode node) {
        if(node == null)
            return 0;

        // recursively height of left subTree
        int leftSubTree = maxDepth(node.left);
        // if leftTree is Unbalanced return -1
        if(leftSubTree == -1) return -1;

        // recursively height of right subTree
        int rightSubTree = maxDepth(node.right);
        // if rightTree is unbalanced return -1
        if(rightSubTree == -1) return -1;

        // check for balance
        if(Math.abs(leftSubTree-rightSubTree) > 1) return -1;

        // return height of the tree
        return Math.max(leftSubTree, rightSubTree)+1;
    }
    

    /*
     *  Check for all nodes if left and right subtree height is atmost 1
     */
    public boolean isBalanced1(TreeNode node) {
        if(node == null)
            return true;
        
        // check for height
        int leftSubTree = this.height.heightRecursive(node.left);
        int rightSubTree = this.height.heightRecursive(node.right);

        if(Math.abs(leftSubTree-rightSubTree) > 1)
            return false;

        // Traverse
        boolean left = isBalanced(node.left);
        boolean right = isBalanced(node.right);

        // If any node fails then return false;
        if(!left || !right) return false;

        // all left and right is tree so return true
        return true;

    }
}
