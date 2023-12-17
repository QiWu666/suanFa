package com.qi.treeNode.leetCode.a104;

import com.qi.quene.LinkListQueue;
import com.qi.treeNode.TreeNode;

import java.util.LinkedList;

/**
 * TODO P117 没实现
 */
public class Demo1 {
    public static void main(String[] args) {
                /*
                1
               / \
              2   3
             /\   /\
            4  5 6  7
         */
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, new TreeNode(5)), 1, new TreeNode(new TreeNode(6), 3, new TreeNode(7)));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        boolean isOddLevel = true; // 奇数层: true
        while (!queue.isEmpty()) {
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                System.out.print(node + " ");
                if (isOddLevel) {
                    // 在奇数层处理节点
                } else {
                    // 在偶数层处理节点
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            System.out.println();
            c1 = c2;
            isOddLevel = !isOddLevel;
        }
    }
}
