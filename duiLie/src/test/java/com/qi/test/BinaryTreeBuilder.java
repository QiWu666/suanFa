package com.qi.test;

import java.util.HashMap;

class TreeNode {
    char val;
    TreeNode left, right;

    public TreeNode(char val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeBuilder {

    public TreeNode buildTree(char[] inorder, char[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        HashMap<Character, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(char[] inorder, int inStart, int inEnd,
                                     char[] postorder, int postStart, int postEnd,
                                     HashMap<Character, Integer> inorderMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        char rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInorder = inorderMap.get(rootValue);
        int leftSubtreeSize = rootIndexInorder - inStart;

        root.left = buildTreeHelper(inorder, inStart, rootIndexInorder - 1,
                postorder, postStart, postStart + leftSubtreeSize - 1, inorderMap);
        root.right = buildTreeHelper(inorder, rootIndexInorder + 1, inEnd,
                postorder, postStart + leftSubtreeSize, postEnd - 1, inorderMap);

        return root;
    }

    public void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    public void printPostorder(TreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();

        char[] inorder = {'c','b','d','e','a','g','i','h','j','f'};
        char[] postorder = {'c','e','d','b','i','j','h','g','f','a'};

        TreeNode root = builder.buildTree(inorder, postorder);
        System.out.println("根节点的值: " + root.val);
        System.out.print("中序遍历：");
        builder.printInorder(root);
        System.out.println();

        System.out.print("后序遍历：");
        builder.printPostorder(root);
        System.out.println();
    }

    /*

                    A
                   / \
                  B   F
                 /   / \
                C   G   H
                       / \
                      I   J
     */
}
