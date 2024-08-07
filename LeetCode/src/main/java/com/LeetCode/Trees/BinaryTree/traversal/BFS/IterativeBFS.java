package com.LeetCode.Trees.BinaryTree.traversal.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class IterativeBFS implements BFS {

    @Override
    public void traverse(TreeNode root) {
        List<Integer> list = listTraverse(root);
        System.out.println(list);
    }

    @Override
    public List<Integer> listTraverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.data);

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return list;
    }

    @Override
    public List<List<Integer>> levelWiseTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            list.add(subList);
        }
        return list;
    }

    @Override
    public List<List<Integer>> zigZagTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                subList.add(node.data);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            if(level%2 == 0)
                list.add(subList);
            else
                list.add(subList.reversed());
            level++;
        }
        return list;
    }
    
}
