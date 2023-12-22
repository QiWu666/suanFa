package com.qi.treeNode.leetCode.a104;

import com.qi.treeNode.TreeNode;

import java.util.concurrent.LinkedTransferQueue;

/**
 * 二叉树最大深度 -- 使用层序遍历
 */
public class Leet104demo3 {
    /*
        思路：
        1.使用层序遍历，层数即最大深度
     */
    public int maxDepth(TreeNode root) {
        LinkedTransferQueue<TreeNode> queue = new LinkedTransferQueue<>();
        queue.offer(root);
        int depth = 0;
//        int c1 = 1;
        while (!queue.isEmpty()) {
//            int c2 = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //System.out.print(poll.value + "\t");
                if (poll.left != null) {
                    queue.offer(poll.left);
//                    c2++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
//                    c2++;
                }
            }
            depth++;
//            c1 = c2;
            System.out.println();
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        System.out.println(new Leet104demo3().maxDepth(root));
    }
}
