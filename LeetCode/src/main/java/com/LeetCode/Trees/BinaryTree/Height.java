package com.LeetCode.Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Height {
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            height++;
        }
        return height;
    }
    public int heightRecursive(TreeNode root) {
        if(root == null)
            return 0;
        int left = heightRecursive(root.left);
        int right = heightRecursive(root.right);
        return Math.max(left, right)+1;
    }
    
}
