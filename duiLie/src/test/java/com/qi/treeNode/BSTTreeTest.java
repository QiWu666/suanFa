package com.qi.treeNode;

import com.qi.treeNode.BSTTree.BSTTree1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BSTTreeTest {

    private BSTTree1 bstTree1;

    @BeforeEach
    public void setUp() {
        bstTree1 = new BSTTree1();
    }

    @Test
    public void testLess() {
        // Test case 1: empty tree
        List<Object> result = bstTree1.less(5);
        Assertions.assertEquals(0, result.size());

        // Test case 2: key not found in tree
        BSTTree1.BSTNode node1 = new BSTTree1.BSTNode(10,"d");
        BSTTree1.BSTNode node2 = new BSTTree1.BSTNode(5,"b");
        BSTTree1.BSTNode node3 = new BSTTree1.BSTNode(3,"a");
        BSTTree1.BSTNode node4 = new BSTTree1.BSTNode(7,"c");
        BSTTree1.BSTNode node5 = new BSTTree1.BSTNode(15,"e");
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        bstTree1.root = node1;
        result = bstTree1.less(10);
        List<Object> list = bstTree1.greater(5);
        list.forEach(System.out::println);

        // Test case 3: key found in tree
        System.out.println(result = bstTree1.between(3, 10));
    }
}

