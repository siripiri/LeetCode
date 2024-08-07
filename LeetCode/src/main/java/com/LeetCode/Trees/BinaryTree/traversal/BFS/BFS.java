package com.LeetCode.Trees.BinaryTree.traversal.BFS;

import java.util.List;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public interface BFS {
    void traverse(TreeNode root);
    List<Integer> listTraverse(TreeNode root);
    List<List<Integer>> levelWiseTraversal(TreeNode root);
    List<List<Integer>> zigZagTraversal(TreeNode root);
}
