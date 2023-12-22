package com.qi.treeNode.leetCode.a111;

import com.qi.treeNode.TreeNode;

import java.util.concurrent.LinkedTransferQueue;

/**
 * 二叉树最小深度
 */
public class Demo1 {
    /**
     * 层序遍历，遇到的第一个叶子节点所在层就是最小深度
     */
    public int minDepth(TreeNode root  ) {
        LinkedTransferQueue<TreeNode> queue = new LinkedTransferQueue<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right==null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
