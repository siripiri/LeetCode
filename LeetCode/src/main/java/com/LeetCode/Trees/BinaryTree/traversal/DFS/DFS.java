package com.LeetCode.Trees.BinaryTree.traversal.DFS;

import java.util.List;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public interface DFS {
    List<Integer> preOrder(TreeNode root);
    List<Integer> inOrder(TreeNode root);
    List<Integer> postOrder(TreeNode root);
}
