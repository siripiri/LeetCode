package com.LeetCode.Trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.LeetCode.Trees.BinaryTree.basics.Height;

public class Construct {
    public TreeNode constructUsingArray(int[] arr) {
        TreeNode head = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int i=1;

        while(!queue.isEmpty() && i<arr.length) {
            TreeNode currNode = queue.remove();
            if(arr[i] != -1) {
                currNode.left = new TreeNode(arr[i]);
                queue.add(currNode.left);
            }
            i++;
            if(i<arr.length && arr[i] != -1) {
                currNode.right = new TreeNode(arr[i]);
                queue.add(currNode.right);
            }
            i++;
        }
        return head;
    }
    public void printTree(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, root);
        System.out.println(sb.toString());
    }

    private void traversePreOrder(StringBuilder sb, TreeNode root) {
        if(root == null) {
            return;
        }

        sb.append(root.data);
        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traversePreOrder(sb, root.left,pointerLeft, "", true);
        traversePreOrder(sb, root.right, pointerRight, "", false);
    }

    private void traversePreOrder(StringBuilder sb, TreeNode node, String pointer, String padding, boolean hasRight) {
        if(node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRight) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            padding = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            traversePreOrder(sb, node.left, pointerLeft, padding, node.right!=null);
            traversePreOrder(sb, node.right, pointerRight, padding, false);
        }
    }

    public void printBinaryTreeArray(TreeNode node) {
        List<List<String>> list = printBinaryTree(node);
        for(List<String> parentList: list) {
            System.out.println(parentList);
        }
    }

    class Pair {
        TreeNode node;
        int col;
        int row;
        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    private List<List<String>> printBinaryTree(TreeNode node) {
        Height h = new Height();
        int height = h.heightRecursive(node);
        int col = (int) Math.pow(2.0, height)-1;
        int row = height;
        List<List<String>> list= new ArrayList<>();

        for(int i=0; i<row; i++) {
            list.add(new ArrayList<>());
            for(int j=0; j<col; j++) {
                list.get(i).add("-");
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, 0, (col-1)/2));
        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            TreeNode currNode = pair.node;
            int currCol = pair.col;
            int currRow = pair.row;

            list.get(currRow).set(currCol, String.valueOf(currNode.data));

            if(currNode.left != null) {
                int rowLeft = currRow+1;
                int colLeft = (int) (currCol - Math.pow(2.0, height-currRow-2));
                queue.add(new Pair(currNode.left, rowLeft, colLeft));
            }

            if(currNode.right != null) {
                int rowRight = currRow+1;
                int colRight = (int) (currCol + Math.pow(2.0, height-currRow-2));
                queue.add(new Pair(currNode.right, rowRight, colRight)); 
            }
            
        }
        return list;
    }
}
