package com.qi.treeNode.BSTTree.leet.a701;

import com.qi.treeNode.TreeNode;

/**
 * 二叉搜索树
 * 新增节点（题目前提：val一定与树中节点不同）
 */
public class Demo1 {
    public TreeNode insertInToBST(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.value > val) {
            node.left = insertInToBST(node.left, val);
        } else if (node.value < val) {
            node.right = insertInToBST(node.right, val);
        }
        return node;
    }
}
