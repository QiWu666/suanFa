package com.qi.treeNode.leetCode.a101;

import com.qi.treeNode.TreeNode;

/**
 * 对称二叉树
 */
public class Demo1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 代码执行到这里 肯定有left/right 一个值不为空
        if (left == null || right == null) {
            return true;
        }
        if (left.value != right.value) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

}
