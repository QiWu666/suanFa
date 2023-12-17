package com.qi.treeNode.leetCode.a103;

import com.qi.quene.LinkListQueue;
import com.qi.treeNode.TreeNode;

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
        LinkListQueue<TreeNode> queue = new LinkListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        while (!queue.empty()) {
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                System.out.print(node + " ");

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
        }
    }
}
