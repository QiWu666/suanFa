package com.qi.treeNode.BSTTree.leet.a938;

import com.qi.treeNode.TreeNode;

import java.util.LinkedList;

/**
 * 求范围和
 */
public class Demo1 {
    // 解法1.中序非递归实现 6ms
    public int rangeSumBST(TreeNode node, int low, int high) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
                if (pop.value >= high) {
                    break;
                }
                if (pop.value > low && pop.value < high) {
                    sum += pop.value;
                }
                p = pop.right;
            }
        }
        return sum;
    }

    public int rangeSumBST1(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.value < low) {
            return rangeSumBST1(node.right, low, high);
        }
        if (node.value > high) {
            return rangeSumBST1(node.left, low, high);
        }
        return node.value + rangeSumBST1(node.left, low, high) + rangeSumBST1(node.right, low, high);
    }
}
