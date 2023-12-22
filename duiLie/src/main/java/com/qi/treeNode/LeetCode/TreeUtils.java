package com.qi.treeNode.leetCode;

import com.qi.treeNode.TreeNode;

import java.util.LinkedList;

public class TreeUtils {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(new TreeNode(4), 2, null);
        TreeNode right = new TreeNode(new TreeNode(5), 3, new TreeNode(6));
        TreeNode root = new TreeNode(left, 1, right);
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root; // 代表当前节点
        TreeNode pop = null; // 最近一次弹栈的元素
        // TODO P151 无法理解
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current); // 压入栈，为了记住回来的路
                // 待处理左子树
                current = current.left;
            } else {
                TreeNode peek = stack.peek(); // 获取栈顶元素
                if (peek.right == null) {
                    pop = stack.pop();
                }
                // 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                }
                // 待处理左子树
                else {
                    current = peek.right; // 最后一个弹出的元素（栈顶）的右孩子再次赋值
                }
            }
        }
    }
}
