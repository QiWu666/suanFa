package com.qi.treeNode.twothreetree;

import java.util.Arrays;

public class BTree {
    static class Node {
        int[] keys; // 关键字
        Node[] children; // 孩子节点
        int keyNumber; // 有效关键字数目
        boolean leaf = true; // 是否为叶子节点
        int t; // 最小度数 (最小孩子数)

        public Node(int t) {
            this.t = t;
            this.children = new Node[t * 2];
            this.keys = new int[t * 2 - 1];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }

        // 多路查找
        Node get(int key) {
            int i = 0;
            while (i < keyNumber) {
                if (keys[i] == key) {
                    return this;
                }
                if (keys[i] > key) {
                    break;
                }
                i++;
            }
            if (leaf) {
                return null;
            }
            return children[i].get(key);
        }

        // 向指定索引处插入 key
        void insertKey(int key, int index) {
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }

        // 向指定索引处插入 child
        void insertChildren(Node child, int index) {
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            children[index] = child;
        }
    }

    Node root;
    int t; // 度数 通常指的是一个节点的子节点的数量
    final int MIN_KEYS_NUMBER;
    final int MAX_KEYS_NUMBER;

    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MAX_KEYS_NUMBER = t * 2 - 1;
        MIN_KEYS_NUMBER = t - 1;
    }

    public BTree() {
        this(2);
    }

    // 1. 是否存在
    boolean contains(int key) {
        return root.get(key) != null;
    }

    // 2. 新增
    public void put(int key) {
        doPut(root, key);
    }

    private void doPut(Node node, int key) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] == key) {
                return; // 找到了
            }
            if (node.keys[i] > key) {
                break; // 找到了插入位置,即为此时的i
            }
            i++;
        }
        if (node.leaf) {
            node.insertKey(key,i);
        } else {
            doPut(node.children[i], key);
        }
    }
    // 3. 删除
}
