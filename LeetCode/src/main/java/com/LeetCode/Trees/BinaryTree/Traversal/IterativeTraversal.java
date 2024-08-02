package com.LeetCode.Trees.BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.LeetCode.Trees.BinaryTree.Construct;
import com.LeetCode.Trees.BinaryTree.TreeNode;

public class IterativeTraversal implements Traversal {

    private static final Logger log = LoggerFactory.getLogger(IterativeTraversal.class);

    @Override
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.data);

            // Push right node first so that left can process before right (LIFO)
            if(node.right != null)
                stack.push(node.right);
            if(node .left != null)
                stack.push(node.left);
        }
        return list;
    }

    @Override
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()) {
            // Pushing all node into stack until it reached leaf node
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            // root element
            current = stack.pop();
            list.add(current.data);
            // moving to right subTree
            current = current.right;
        }
        return list;
    }

    @Override
    public List<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> traverse = new Stack<>();
        Stack<Integer> store = new Stack<>();
        List<Integer> list = new ArrayList<>();
        traverse.push(root);
        while(!traverse.isEmpty()) {
            TreeNode node = traverse.pop();
            if(node.left != null)
                traverse.push(node.left);
            if(node.right != null)
                traverse.push(node.right);
            store.push(node.data);
        }
        while(!store.isEmpty())
            list.add(store.pop());
        return list;
    }

    @Override
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        list.add(root.data);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node.left != null) {
                list.add(node.left.data);
                queue.add(node.left);
            }
            if(node.right != null) {
                list.add(node.right.data);
                queue.add(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Construct con = new Construct();
        Traversal t = new IterativeTraversal();

        int[] tree = new int[]{4,2,5,3,-1,7,6,-1,9,-1,-1,8,-1,1};
        TreeNode root = con.constructUsingArray(tree);

        log.info("Iterative preOrder: {}", t.preOrder(root).toString());
        log.info("Iterative inOrder: {}", t.inOrder(root).toString());
        log.info("Iterative postOrder: {}", t.postOrder(root).toString());
    }
}
