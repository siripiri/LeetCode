package com.LeetCode.Trees.BinaryTree;

import com.LeetCode.Trees.BinaryTree.traversal.BFS.IterativeBFS;
public class BinaryTreeMain {
    public static void main(String[] args) {
        Construct con = new Construct();
        IterativeBFS bfs = new IterativeBFS();

        // int[] tree1 = {1,2,3,4,5,6,7,-1,-1,8,-1,-1,-1,9,10};
        // TreeNode root1 = con.constructUsingArray(tree1);
        // con.printTree(root1);
        // con.printBinaryTreeArray(root1);

        int[] tree2 = {1,2,3,4,6,5,7};
        TreeNode root2 = con.constructUsingArray(tree2);
        System.out.println(bfs.rightSideView(root2));
        //con.printBinaryTreeArray(root2);
        //bfs.traverse(root2);
        //System.out.println(bfs.verticalTraversal(root2));


        // int[] tree3 = {4,2,5,3,-1,7,6,-1,9,-1,-1,8,-1};
        // TreeNode root3 = con.constructUsingArray(tree3);
        // System.out.println(t.postOrder(root3));

    }
}
