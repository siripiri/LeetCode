package com.LeetCode.Trees.BinaryTree.hard;

import java.util.LinkedList;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class MaxWidth {
    class Pair {
        int index;
        TreeNode node;
        public Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int maxCount = 0;
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxCount = Math.max(maxCount, queue.getLast().index - queue.getFirst().index + 1);

            for(int i=0; i<size; i++) {
                Pair nodePair = queue.removeFirst();
                
                if(nodePair.node.left != null) {
                    queue.add(new Pair(nodePair.index*2, nodePair.node.left));
                }

                if(nodePair.node.right != null) {
                    queue.add(new Pair(nodePair.index*2+1, nodePair.node.right));
                }
            }
        }
        return maxCount;
    }
}
