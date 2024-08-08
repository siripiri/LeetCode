package com.LeetCode.Trees.BinaryTree.traversal.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

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
    class Pair {
        int rowIndex;
        int colIndex;
        TreeNode node;
        public Pair(int rowIndex, int colIndex, TreeNode node) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Pair rootPair = new Pair(0, 0, root);
        queue.add(rootPair);

        while(!queue.isEmpty()) {
            Pair nodePair = queue.poll();

            if(!map.containsKey(nodePair.colIndex)) {
                map.put(nodePair.colIndex, new TreeMap<>());
            }

            if(!map.get(nodePair.colIndex).containsKey(nodePair.rowIndex)){
                map.get(nodePair.colIndex).put(nodePair.rowIndex , (new PriorityQueue<>()));
            }

            map.get(nodePair.colIndex).get(nodePair.rowIndex).add(nodePair.node.data);

            if(nodePair.node.left != null) {
                Pair lefPair = new Pair(nodePair.rowIndex+1, nodePair.colIndex-1, nodePair.node.left);
                queue.add(lefPair);
            }

            if(nodePair.node.right != null) {
                Pair rightPair = new Pair(nodePair.rowIndex+1, nodePair.colIndex+1, nodePair.node.right);
                queue.add(rightPair);
            }
        }

        for(TreeMap<Integer , PriorityQueue<Integer>> column_map : map.values()){

            list.add(new ArrayList<>());

            for(PriorityQueue<Integer> node_values_min_heap : column_map.values()){

                while(!node_values_min_heap.isEmpty()){

                    list.get((list.size() - 1)).add(node_values_min_heap.poll());
                }
            }
        }
        return list;
    } 
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                subList.add(node.data);

                if(node.left != null)
                    queue.add(node.left);
                
                if(node.right != null)
                    queue.add(node.right);    
            }
            list.add(subList);
        }

        for(List<Integer> subList: list) {
            System.out.println(subList);
            res.add(subList.get(subList.size()-1));
        }

        return res;
    }
    
}
