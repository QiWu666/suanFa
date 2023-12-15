package com.qi.treeNode;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
