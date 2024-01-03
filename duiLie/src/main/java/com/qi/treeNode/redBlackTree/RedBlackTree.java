package com.qi.treeNode.redBlackTree;

/**
 * <h3>红黑树</h3>
 */
public class RedBlackTree {
    enum Color{
        RED,BLACK
    }
    private Node root;
    private static class Node{
        int key;
        Object value;
        Node left;
        Node right;
        Node parent; // 父亲节点
        Color color = Color.RED; // 颜色

        // 是否是左孩子
        boolean isLeftChild() {
            // parent.left 检查当前节点是否是其父节点的左孩子
            return parent != null && parent.left == this;
        }

        //叔叔
        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }
            parent.isLeftChild();
            return null;

        }
        //兄弟
    }

}
