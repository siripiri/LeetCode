package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T257_BinaryTreePaths;

import java.util.List;

import com.LeetCode.Trees.BinaryTree.Construct;
import com.LeetCode.Trees.BinaryTree.TreeNode;
import com.LeetCode.Trees.BinaryTree.traversal.DFS.DFS;
import com.LeetCode.Trees.BinaryTree.traversal.DFS.RecursiveDFS;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }
    private static void preOrder(TreeNode node, StringBuilder paths) {
        if(node == null)
            return;
        int len = paths.length();
        paths.append("->" + node.data);
        if(node.left == null && node.right == null){
            System.out.println(paths.toString());
        }
        else {
            preOrder(node.left, paths);
            preOrder(node.right, paths);
        }
        paths.setLength(len);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,-1,-1};
        Construct con = new Construct();
        TreeNode node = con.constructUsingArray(arr);
        con.printBinaryTreeArray(node);
        con.printTree(node);
        DFS dfs = new RecursiveDFS();
        System.out.println(dfs.preOrder(node));
        preOrder(node, new StringBuilder());
    }
}
