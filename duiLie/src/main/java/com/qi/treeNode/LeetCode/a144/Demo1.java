package com.qi.treeNode.leetCode.a144;

import com.qi.treeNode.TreeNode;

import java.util.LinkedList;
// TODO P151 背着写
public class Demo1 {


    public static void main(String[] args) {
        TreeNode left = new TreeNode(new TreeNode(4), 2, null);
        TreeNode right = new TreeNode(new TreeNode(5), 3, new TreeNode(6));
        TreeNode root = new TreeNode(left, 1, right);
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root; // 代表当前节点
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.println("去 " + current.value);
                stack.push(current); //压入栈，为了记住回来的路
                current = current.left;
            }else {
                TreeNode pop = stack.pop();
                System.out.println("回 "+pop);
                current = pop.right; // 最后一个弹出的元素（栈顶）的右孩子再次赋值
            }
        }
    }
}
