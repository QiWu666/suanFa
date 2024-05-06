package com.qi.btree;

import java.util.Arrays;

public class Btree {
    static class Node{
        int[] keys; // 关键字
        Node[] children; // 孩子节点
        int keyNumber; // 关键字的有效长度
        boolean leaf = true; // 是否为叶子节点
        int t; // 最小度数(最小孩子数)

        public Node(int t) {
            this.t = t;
            this.children = new Node[t * 2];
            this.keys = new int[t * 2 - 1];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(children, 0, keyNumber));
        }
        // 多路查找
        Node get(int key){
            int i = 0;
            while (i < keyNumber) {
                if (keys[i] == key) {
                    return this;
                } else if (keys[i] > key) {
                    break;
                }
                i++;
            }
            // 执行到此时keys[i]>key 或 i==keyNumber
            if (leaf) {
                return null;
            }
            return children[i].get(key);
        }

        // 向指定索引处插入key
        void insertKey(int key, int index) {
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }

        // 向指定索引处插入child
        void insertChild(Node child, int index) {
            System.arraycopy(children, index, children, index + 1, keyNumber - index);
            children[index] = child;
            keyNumber++;
        }
    }
}
