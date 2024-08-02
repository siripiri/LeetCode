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
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.data);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // left -> root -> right
    @Override
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    // left -> right -> root
    @Override
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }
    private void postOrder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.data);
        return;
    } 

    @Override
    public List<Integer> levelOrder(TreeNode root) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'levelOrder'");
    }
    
    public static void main(String[] args) {
        Construct con = new Construct();
        Traversal t = new RecursiveTraversal();

        int[] tree = new int[]{4,2,5,3,-1,7,6,-1,9,-1,-1,8,-1,1};
        TreeNode root = con.constructUsingArray(tree);

        log.info("Recursive PreOrder: {}", t.preOrder(root).toString());
        log.info("Recursive InOrder: {}", t.inOrder(root).toString());
        log.info("Recursive PostOrder: {}", t.postOrder(root).toString());
    }
}
