package com.LeetCode.Trees.BinaryTree.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.LeetCode.Trees.BinaryTree.Construct;
import com.LeetCode.Trees.BinaryTree.TreeNode;

public class BurningTree {
    public int getMinTime(TreeNode root, int target) {
        int mintime = 0;
        if(root == null || (root.left == null && root.right == null))
            return mintime;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        int[] length = new int[1];
        TreeNode targetNode = getParentNodes(root, parentMap, target, length);
        Queue<TreeNode> queue = new LinkedList<>();
        if(targetNode == null)
            return mintime;
        queue.add(targetNode);
        Map<TreeNode, Boolean> isVisitedMap = new HashMap<>();
        isVisitedMap.put(targetNode, true);
        mintime = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null && isVisitedMap.get(node.left) == null) {           
                    isVisitedMap.put(node.left, true);
                    queue.add(node.left);
                }
    
                if(node.right != null && isVisitedMap.get(node.right) == null) {
                    isVisitedMap.put(node.right, true);
                    queue.add(node.right);
                }
    
                if(parentMap.get(node) != null && isVisitedMap.get(parentMap.get(node)) == null) {
                    isVisitedMap.put(parentMap.get(node), true);
                    queue.add(parentMap.get(node));
                }
            }

            mintime++;

            if(isVisitedMap.size() == length[0])
                break;
        }

        return mintime;
    }
    private TreeNode getParentNodes(TreeNode root, Map<TreeNode, TreeNode> parentMap, int target, int[] count) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode targetNode = null;
        while (!queue.isEmpty()) {
            count[0]++;
            TreeNode node = queue.poll();

            if(node.data == target) {
                targetNode = node;
            }
            
            if(node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }

            if(node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
        return targetNode;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,-1,7,8,-1,10};
        Construct con = new Construct();
        TreeNode root = con.constructUsingArray(arr);
        con.printBinaryTreeArray(root);
        con.printTree(root);

        BurningTree b = new BurningTree();
        System.out.println(b.getMinTime(root, 10));
    }
}
