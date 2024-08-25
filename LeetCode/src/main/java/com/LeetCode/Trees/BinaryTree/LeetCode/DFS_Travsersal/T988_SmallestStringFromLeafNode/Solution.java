package com.LeetCode.Trees.BinaryTree.LeetCode.DFS_Travsersal.T988_SmallestStringFromLeafNode;

import java.util.ArrayList;
import java.util.List;

import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Solution {
    public String smallestFromLeaf(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int[] minSum = new int[1];
        dfs(root, minSum, new ArrayList<>(), res, 0);
        System.out.println(res);
        return "";
    }
    private void dfs(TreeNode node, int[] minSum, List<Integer> list, List<Integer> result, int sum) {
        if (node == null)
            return;
        int len = list.size();
        sum += node.data;
        list.add(node.data);
        if(node.left == null && node.right == null) {
            if(sum < minSum[0]) {
                minSum[0] = sum;
                result = new ArrayList<>(list);
            }
        }
        dfs(node.left, minSum, list, result, sum);
        dfs(node.right, minSum, list, result, sum);
        while(list.size() > len)
            list.remove(list.size()-1);
    }
}
