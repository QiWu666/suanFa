package com.qi.treeNode;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode left, int value, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
