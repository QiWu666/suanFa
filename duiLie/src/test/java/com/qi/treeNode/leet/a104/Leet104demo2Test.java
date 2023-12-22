package com.qi.treeNode.leet.a104;

import com.qi.treeNode.TreeNode;
import com.qi.treeNode.leetCode.a104.Leet104demo2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet104demo2Test {

    @Test
    public void testMaxDepth() {
        Leet104demo2 Leet104demo2 = new Leet104demo2();

        // Test case 1: node is null
        TreeNode node1 = null;
        int result1 = Leet104demo2.maxDepth(node1);
        Assertions.assertEquals(0, result1);

        // Test case 2: node has no children
        TreeNode node2 = new TreeNode(1);
        int result2 = Leet104demo2.maxDepth(node2);
        Assertions.assertEquals(1, result2);

        // Test case 3: node has left child only
        TreeNode node3 = new TreeNode(1);
        TreeNode node3_left = new TreeNode(2);
        node3.left = node3_left;
        int result3 = Leet104demo2.maxDepth(node3);
        Assertions.assertEquals(2, result3);

        // Test case 4: node has right child only
        TreeNode node4 = new TreeNode(1);
        TreeNode node4_right = new TreeNode(2);
        node4.right = node4_right;
        int result4 = Leet104demo2.maxDepth(node4);
        Assertions.assertEquals(2, result4);

        // Test case 5: node has both left and right children
        TreeNode node5 = new TreeNode(1);
        TreeNode node5_left = new TreeNode(2);
        TreeNode node5_right = new TreeNode(3);
        node5.left = node5_left;
        node5.right = node5_right;
        int result5 = Leet104demo2.maxDepth(node5);
        Assertions.assertEquals(2, result5);

        // Test case 6
        TreeNode node6 = new TreeNode(1);
        TreeNode node6_left = new TreeNode(new TreeNode(4), 2,null);
        TreeNode node6_right = new TreeNode(3);
        node6.left = node6_left;
        node6.right = node6_right;
        int result6 = Leet104demo2.maxDepth(node6);
        Assertions.assertEquals(3, result6);
    }
}
