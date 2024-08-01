package com.LeetCode.Trees.BinaryTree.Traversal;

import java.util.List;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public interface Traversal {
    List<Integer> preOrder(TreeNode root);
    List<Integer> inOrder(TreeNode root);
    List<Integer> postOrder(TreeNode root);
}
