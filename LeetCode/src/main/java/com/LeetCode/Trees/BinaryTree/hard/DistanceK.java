package com.LeetCode.Trees.BinaryTree.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.LeetCode.Trees.BinaryTree.Construct;
import com.LeetCode.Trees.BinaryTree.TreeNode;

public class DistanceK {
    private void getParentNodes(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
    }
    private List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visitedNode = new HashMap<>();
        int currLevel = 0;

        getParentNodes(parentMap, root);
        queue.add(target);
        visitedNode.put(target, true);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(currLevel == k)
                break;
            currLevel++;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null && visitedNode.get(node.left) == null) {
                    visitedNode.put(node.left, true);
                    queue.add(node.left);
                }

                if(node.right != null && visitedNode.get(node.right) == null) {
                    visitedNode.put(node.right, true);
                    queue.add(node.right);
                }

                if(parentMap.get(node) != null && visitedNode.get(parentMap.get(node)) == null) {
                    visitedNode.put(parentMap.get(node), true);
                    queue.add(parentMap.get(node));
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
        Construct con = new Construct();
        TreeNode root = con.constructUsingArray(arr);
        con.printBinaryTreeArray(root);

        DistanceK k = new DistanceK();
        System.out.println(k.distanceK(root, root.left, 2));
    }
}
