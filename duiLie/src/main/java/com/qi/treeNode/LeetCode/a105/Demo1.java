package com.qi.treeNode.leetCode.a105;

import com.qi.treeNode.TreeNode;

import java.util.Arrays;

/**
 * 根据前序中序遍历结果构造二叉树
 */
public class Demo1  {
    public TreeNode buildTree(int[] preOrder,int[] inOrder) {
        if (preOrder.length == 0) {
            return null;
        }
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                // 0 ~ i-1 子左树
                // i+1 ~ inOrder.length - 1 右子树
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                int[] preLeft = Arrays.copyOfRange(preOrder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, preLeft.length);
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }
}
