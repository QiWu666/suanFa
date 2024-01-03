package com.qi.treeNode.leet.a938;

import com.qi.treeNode.BSTTree.leet.a938.Demo1;
import com.qi.treeNode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRangeSumBST {
    @Test
    public void testRangeSumBST() {
        // 创建测试树
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(7);
        node.right = new TreeNode(16);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(6);
        node.right.left = new TreeNode(11);
        node.right.right = new TreeNode(12);
        Demo1 test1 = new Demo1();

        // 测试用例1：范围为[2, 5]
        int expected1 = 18;
        int actual1 = test1.rangeSumBST(node, 2, 10);
        assertEquals(expected1, actual1);

        // 测试用例2：范围为[4, 7]
        int expected2 = 11;
        int actual2 = test1.rangeSumBST(node, 4, 7);
        assertEquals(expected2, actual2);


    }
}