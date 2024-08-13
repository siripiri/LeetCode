package com.LeetCode.Trees.BinaryTree.hard;

import java.util.ArrayList;
import java.util.List;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class NodePath {
    private boolean solve(TreeNode root, TreeNode target, List<Integer> list) {
        if(root == null)
            return false;
        list.add(root.data);
        if(solve(root.left, target, list) || solve(root.right, target, list))
            return true;
        list.remove(list.size()-1);
        return false;
    }
    public List<Integer> getPath(TreeNode root, TreeNode target) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        solve(root, target, list);
        return list;
    }
}
