package com.qi.treeNode.AVLTree2;

public class AVLTree {
    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //    为了方便null值的高度，定义一个高度的方法。
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    //    更新节点高度（新增、删除、旋转）
    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right));
    }

    //平衡因子(balance factor) = 左子树高度-右子树高度
    private int bf(AVLNode node) {
        return height(node.left) - height((node.right));
    }

    /**
     * 参数：要旋转的节点，返回值：新的根节点
     */
    private AVLNode rightRotate(AVLNode red) {
        AVLNode yellow = red.left;
        AVLNode green = yellow.right;
        // 上位
        yellow.right = red;
        // 换爹
        red.left = green;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    private AVLNode leftRotate(AVLNode red) {
        AVLNode yellow = red.right;
        AVLNode green = yellow.left;
        // 换爹
        red.right = green;
        // 上位
        yellow.left = red;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    // LR
    private AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    // RL
    private AVLNode rightLeftRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    /**
     * 检查节点是否失衡， 重新平衡代码
     */
    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        int bf = bf(node);
        if (bf > 1 && bf(node.left) >= 0) { // LL
            return rightRotate(node);
        } else if (bf > 1 && bf(node.left) < 0) { // LR
            return leftRightRotate(node);
        } else if (bf < -1 && bf(node.right) > 0) { // RL
            return rightLeftRotate(node);
        } else if (bf < -1 && bf(node.right) <= 0) { // RR
            return leftRotate(node);
        }
        return node;
    }

    AVLNode root;

    public void put(int key, Object value) {
        root = doPut(root, key, value);
    }

    private AVLNode doPut(AVLNode node, int key, Object value) {
        // 1. 找到空位，创建新节点
        if (node == null) {
            return new AVLNode(key, value);
        }
        // 2．key已存在，更新
        if (node.key == key) {
            node.value = value;
            return node;
        }
        // 3. 继续查找
        if (key < node.key) {
            node.left = doPut(node.left, key, value);
        } else {
            node.right = doPut(node.right, key, value);
        }
        updateHeight(node);
        return balance(node);
    }

    public void remove(int key) {
        root = doRemove(root, key);
    }

    private AVLNode doRemove(AVLNode node, int key) {
        if (node == null) {
            return null;
        }
//        2.没找到key
        if (key < node.key) {
            node.left = doRemove(node.left, key);
        } else if (node.key < key) {
            node.right = doRemove(node.right, key);
        } else {
            // 3．找到key 1）没有孩子2）只有一个孩子3）有两个孩子
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else{
                // TODO P191 删除情况
                // 有两个孩子 找后继节点
                AVLNode s = node.right;
                while (s.left != null) {
                    s = s.left;
                }
                // 后继节点处理好后事再来删除
                s.right = doRemove(s.right, s.key);
                s.left = node.left;
                node = s;
            }
        }
//        4. 更新高度
        updateHeight(node);
//        5. balance
        return balance(node);
    }
}
