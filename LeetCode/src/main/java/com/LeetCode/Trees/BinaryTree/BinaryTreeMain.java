package com.LeetCode.Trees.BinaryTree;

import com.LeetCode.Trees.BinaryTree.traversal.DFS.DFS;
import com.LeetCode.Trees.BinaryTree.traversal.DFS.RecursiveDFS;

public class BinaryTreeMain {
    private static void print(String val) {
        System.out.println(val);
    }
    public static void main(String[] args) {
        Construct con = new Construct();
        DFS t = new RecursiveDFS();

        int[] tree1 = {1,2,3,4,5,6,7,-1,-1,8,-1,-1,-1,9,10};
        TreeNode root1 = con.constructUsingArray(tree1);
        con.printTree(root1);
        con.printBinaryTreeArray(root1);
    }
}
