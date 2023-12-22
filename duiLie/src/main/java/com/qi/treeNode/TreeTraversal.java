package com.qi.treeNode;

public class TreeTraversal {

    /**
     * 前序遍历
     */
    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + "\t"); // 值
        preOrder(node.left); // 左子树
        preOrder(node.right); // 右子树
    }

    /**
     * 中序遍历
     * @param node 节点
     */
    static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left); // 左子树
        System.out.print(node.value + "\t"); // 值
        inOrder(node.right); // 右子树
    }

    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left); // 左子树
        postOrder(node.right); // 右子树
        System.out.print(node.value + "\t"); // 值
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(new TreeNode(4), 2, null);
        TreeNode right = new TreeNode(new TreeNode(5), 3, new TreeNode(6));
        TreeNode node = new TreeNode(left, 1, right);
        preOrder(node);
        System.out.println();
        inOrder(node);
        System.out.println();
        postOrder(node);
    }
}
