package com.qi.treeNode.leetCode.a104;

import com.qi.treeNode.TreeNode;

import java.util.LinkedList;

public class Leet104demo2 {
    public int maxDepth(TreeNode root) {
        TreeNode curr = root;
        TreeNode pop = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // 经历过的curr节点放到栈中
                stack.push(curr);

                // 判断深度的代码
                int size = stack.size(); // 获取栈的长度。
                if (size > max) {
                    max = size;
                }
                // 左子树不为空，让节点往左边走
                curr = curr.left;
            }else {
                // 树向回走
                // 如果左右子树都处理完成，就弹栈。
                // 获取栈顶元素
                TreeNode peek = stack.peek();
                // 栈的右子树为空或者栈的右子树处理完成
                if (peek.right == null || peek.right == pop) {
                    // 处理完成后 弹栈
                    pop = stack.pop();
                }
                // 右子树没有处理完,继续处理右子树
                else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }
}
