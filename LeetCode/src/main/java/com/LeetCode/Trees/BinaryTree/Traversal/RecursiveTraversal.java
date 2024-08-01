package com.LeetCode.Trees.BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.LeetCode.Trees.BinaryTree.Construct;
import com.LeetCode.Trees.BinaryTree.TreeNode;

public class RecursiveTraversal implements Traversal {
    private static final Logger log = LoggerFactory.getLogger(RecursiveTraversal.class);
    // root -> left -> right
    @Override
    public List<Integer> preOrder(TreeNode root) {
        return preOrder(root, new ArrayList<>());
    }

    private List<Integer> preOrder(TreeNode root, List<Integer> list) {
        if(root == null)
            return list;
        list.add(root.data);
        preOrder(root.left, list);
        preOrder(root.right, list);
        return list;
    }

    @Override
    public List<Integer> inOrder(TreeNode root) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inOrder'");
    }

    @Override
    public List<Integer> postOrder(TreeNode root) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postOrder'");
    }
    
    public static void main(String[] args) {
        Construct con = new Construct();
        Traversal t = new RecursiveTraversal();

        int[] tree = new int[]{4,2,5,3,-1,7,6,-1,9,-1,-1,8,-1,1};
        TreeNode root = con.constructUsingArray(tree);

        log.info("PreOrder Traversal: " + t.preOrder(root).toString());
    }
}
