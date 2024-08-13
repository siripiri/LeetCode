package com.LeetCode.Trees.BinaryTree.hard.BuildTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.LeetCode.Trees.BinaryTree.Construct;
import com.LeetCode.Trees.BinaryTree.TreeNode;

public class Codec {
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        list.add(String.valueOf(root.data));
        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            
            if(currNode.left != null) {
                queue.add(currNode.left);
                list.add(String.valueOf(currNode.left.data));
            } else {
                list.add("#");
            }

            if(currNode.right != null) {
                queue.add(currNode.right);
                list.add(String.valueOf(currNode.right.data));
            } else {
                list.add("#");
            }
        }
        return list.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        data = data.substring(1, data.length()-1);

        String[] values = data.split(", ");
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        queue.add(root);
        int index = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                TreeNode currNode = queue.poll();

                if(index >= values.length)
                    break;

                if(!values[index].equals("#")) {
                    currNode.left = new TreeNode(Integer.valueOf(values[index]));
                    queue.add(currNode.left);
                }
                index++;

                if(index >= values.length)
                    break;

                if(!values[index].equals("#")) {
                    currNode.right = new TreeNode(Integer.valueOf(values[index]));
                    queue.add(currNode.right);
                }

                index++;
            }
        }
        return root;
    } 

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,-1,7,8,-1,10};
        Construct con = new Construct();
        TreeNode root = con.constructUsingArray(arr);
        con.printTree(root);

        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println("Serialize: " + data);
        TreeNode node = codec.deserialize(data);
        con.printTree(node);
    }
}
