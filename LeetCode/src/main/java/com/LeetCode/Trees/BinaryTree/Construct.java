package com.LeetCode.Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Construct {
    public TreeNode constructUsingArray(int[] arr) {
        TreeNode head = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int i=1;

        while(!queue.isEmpty() && i<arr.length) {
            TreeNode currNode = queue.remove();
            if(arr[i] != -1) {
                currNode.left = new TreeNode(arr[i]);
                queue.add(currNode.left);
            }
            i++;
            if(i<arr.length && arr[i] != -1) {
                currNode.right = new TreeNode(arr[i]);
                queue.add(currNode.right);
            }
            i++;
        }
        return head;
    }
}
