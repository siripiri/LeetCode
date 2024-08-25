package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T113_PathSum2;

import java.util.ArrayList;
import java.util.List;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result, 0);
        return result;
    }
    public void dfs(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result, int sum) {
        if(root == null)
            return;
        int len = list.size();
        list.add(root.data);
        sum += root.data;
        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                result.add(new ArrayList<>(list));
            }
        } else {
            dfs(root.left, targetSum, list, result, sum);
            dfs(root.right, targetSum, list, result, sum);
        }
        while(list.size() > len)
            list.remove(list.size());
    }
}
