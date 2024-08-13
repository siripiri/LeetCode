package com.LeetCode.Trees.BinaryTree.hard;

import java.util.LinkedList;
import java.util.Queue;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class ChildrenSum {
    public int isSumProperty(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sum = node.data;
            int childSum = 0;

            if(node.left != null) {
                childSum += node.left.data;
                queue.add(node.left);
            }

            if(node.right != null) {
                childSum += node.right.data;
                queue.add(node.right);
            }

            if(!(node.left == null && node.right == null) && childSum != sum) {
                return 0;
            }
        }
        return 1;
    }
}
