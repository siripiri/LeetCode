package com.LeetCode.Trees.BinaryTree.basics;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Basics {
    // Is Same Tree
    public boolean isSame(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return true;

        if(p.data != q.data)
            return false;
        
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    // Is Symmetric Tree
    public boolean isSymmetric(TreeNode node) {
        if(node == null) {
            return true;
        }
        return isSymmetricSubTree(node.left, node.right);
    }
    private boolean isSymmetricSubTree(TreeNode leftSubTree, TreeNode rightSubTree) {
        if(leftSubTree == null && rightSubTree == null)
            return true;
        if(leftSubTree == null || rightSubTree == null)
            return false;
        
        if(leftSubTree.data != rightSubTree.data)
            return false;
        
        return isSymmetricSubTree(leftSubTree.left, rightSubTree.right) && 
        isSymmetricSubTree(leftSubTree.right, rightSubTree.left);
    }

    // Invert Binary Tree
    public TreeNode invertBTree(TreeNode node) {
        if(node == null)
            return null;
        
        //swap
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        // call left and right
        invertBTree(node.left);
        invertBTree(node.right);

        return node;
    }

    


}
