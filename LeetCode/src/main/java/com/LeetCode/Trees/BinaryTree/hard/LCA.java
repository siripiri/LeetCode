package com.LeetCode.Trees.BinaryTree.hard;

import java.util.Stack;

import com.LeetCode.Trees.BinaryTree.Construct;
import com.LeetCode.Trees.BinaryTree.TreeNode;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> traverse = new Stack<>();
        Stack<TreeNode> store = new Stack<>();
        traverse.push(root);

        while(!traverse.isEmpty()) {
            TreeNode node = traverse.pop();
            if(node.left != null)
                traverse.push(node.left);
            if(node.right != null)
                traverse.push(node.right);
            store.push(node);
        }

        while(!store.isEmpty()) {
            TreeNode node = store.pop();
            if(hasTarget(node, p, q))
                return node;
        }

        return root;
    }
    

    private boolean hasTarget(TreeNode subTree, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = subTree;
        boolean pBool = false;
        boolean qBool = false;
        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr == p)
                pBool = true;
            if(curr == q)
                qBool = true;
            if(pBool && qBool)
                break;
            curr = curr.right;
        }
        return pBool && qBool;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
        Construct con = new Construct();
        TreeNode root1 = con.constructUsingArray(arr);
        con.printBinaryTreeArray(root1);
        
        LCA lca = new LCA();
        System.out.println(lca.hasTarget(root1.left, root1.left, root1.right.right));
    }
}
