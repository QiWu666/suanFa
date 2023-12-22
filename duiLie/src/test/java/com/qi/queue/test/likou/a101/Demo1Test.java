package com.qi.queue.test.likou.a101;

import com.qi.treeNode.TreeNode;
import com.qi.treeNode.leetCode.a101.Demo1;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Demo1Test {

    @Test
    void isSymmetric_testCase1() {
        Demo1 demo1 = new Demo1();
        TreeNode root = null; // Input null root
        assertFalse(demo1.isSymmetric(root));
    }

    @Test
    void isSymmetric_testCase2() {
        Demo1 demo1 = new Demo1();
        TreeNode root = new TreeNode(1); // Input root with value 1
        assertTrue(demo1.isSymmetric(root));
    }

    @Test
    void isSymmetric_testCase3() {
        Demo1 demo1 = new Demo1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); // Input root with value 1 and left child with value 2
        assertTrue(demo1.isSymmetric(root));
    }

    @Test
    void isSymmetric_testCase4() {
        Demo1 demo1 = new Demo1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2); // Input root with value 1 and both left and right children with value 2
        assertTrue(demo1.isSymmetric(root));
    }

    @Test
    void isSymmetric_testCase5() {
        Demo1 demo1 = new Demo1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3); // Input root with value 1 and left child with value 2 and right child with value 3
        assertFalse(demo1.isSymmetric(root));
    }

    @Test
    void isSymmetric_testCase6() {
        Demo1 demo1 = new Demo1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4); // Input root with value 1 and left child with value 2, right child with value 3, and left child of left child with value 4
        assertFalse(demo1.isSymmetric(root));
    }

    @Test
    void isSymmetric_testCase7() {
        Demo1 demo1 = new Demo1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5); // Input root with value 1 and left child with value 2, right child with value 3, left child of left child with value 4, and right child of left child with value 5
        assertFalse(demo1.isSymmetric(root));
    }
}
