package com.qi.treeNode.BSTTree.leet.a98;

import com.qi.treeNode.TreeNode;

import java.util.LinkedList;

/**
 * 判断是否为合法的二叉搜索树
 */
public class Demo1 {
    /**
     * 解法1. 中序遍历非递归实现
     */
    public boolean isValidBST1(TreeNode node) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE; // 代表上一个值
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
                if (prev >= pop.value) {
                    return false;
                }
                prev = pop.value;
                // 右
                p = pop.right;
            }
        }
        return true;
    }

    /**
     * 解法2. 中序遍历递归实现
     */
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean a = isValidBST(node.left);
        // 值
        if (node.value > prev) {
            return false;
        }
        prev = node.value;
        boolean b = isValidBST(node.right);
        return a && b;
    }

    /**
     * 解法4：上下限递归实现
     */
    public boolean doValid4(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.value<=min || node.value>=max) {
            return false;
        }
        return doValid4(node.left, min, node.value) && doValid4(node, node.value, max);
    }
}
