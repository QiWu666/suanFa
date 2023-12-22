package com.qi.queue.test.treeNode.leet.a111;

import com.qi.treeNode.TreeNode;
import com.qi.treeNode.leetCode.a111.Demo1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Leet111Demo1Test {

    @Test
    public void testMinDepth() {
        // 创建测试对象
        Demo1 demo1 = new Demo1();

        // 创建测试数据
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(16);
        TreeNode node8 = new TreeNode(18);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;

        // 测试
        int result = demo1.minDepth(root);

        // 断言
        assertEquals(3, result);
    }
}
