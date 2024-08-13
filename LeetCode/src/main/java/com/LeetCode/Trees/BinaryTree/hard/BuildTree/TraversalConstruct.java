package com.LeetCode.Trees.BinaryTree.hard.BuildTree;

import java.util.HashMap;
import java.util.Map;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class TraversalConstruct {
    public TreeNode preInConstruct(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inOrder.length; i++)
            inorderMap.put(inOrder[i], i);
        return solvePre(inOrder, 0, inOrder.length-1, preOrder, 0, preOrder.length-1, inorderMap);
    }
    private TreeNode solvePre(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd, Map<Integer, Integer> inMap) {
        if(inStart > inEnd || preStart > preEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int rootIndex = inMap.get(root.data);
        int numsLeft = rootIndex - inStart;

        root.left = solvePre(inOrder, inStart, rootIndex - 1, preOrder, preStart + 1, preStart + numsLeft, inMap);
        root.right = solvePre(inOrder, rootIndex + 1, inEnd, preOrder, preStart + numsLeft + 1, preEnd, inMap);
        return root;
    }
    public TreeNode postInConstruct(int[] postOrder, int[] inOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<inOrder.length; i++)
            inMap.put(inOrder[i], i);
        return solvePost(inOrder, 0, inOrder.length-1, inOrder, 0, postOrder.length-1, inMap);
    }
    private TreeNode solvePost(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        if(postStart > postEnd || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(postOrder[postEnd]);

        int inRootIndex = inMap.get(postOrder[postEnd]);
        int numsLeft = inRootIndex - inStart;

        root.left = solvePost(inOrder, inStart, inRootIndex-1, postOrder, postStart, postStart + numsLeft - 1, inMap);
        root.right = solvePost(inOrder, inRootIndex+1, inEnd, postOrder, postStart + numsLeft, postEnd - 1, inMap);

        return root;
    }
}
