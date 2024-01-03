package com.qi.treeNode.avlTree;

/**
 * AVL树
 * 二叉搜索树在插入和删除时，节点可能失衡
 * 如果在插入和删除时通过旋转，始终让二叉搜索树保持平衡，称为自平衡的二叉搜索树
 * AVL是自平衡二叉搜索树的实现之一
 */
public class AVLTree {
    static class AVLNode {
        int key;
        Object value;
        int height;
        AVLNode left;
        AVLNode right;

        public AVLNode(int key) {
            this.key = key;
        }

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

    /**
     * 求节点的高度
     */
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 更新节点高度（新增、删除、旋转）
     */
    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    //平衡因子(balance factor) = 左子树高度 - 右子树高度
    private int bf(AVLNode node) {
        // 0 , 1 , -1 平衡的
        // >1 , <-1   不平衡
        // bf>1时，表示左边太高
        // bf<-1时，表示右边太高
        return height(node.left) - height(node.right);
    }

    /**
     * 向右旋转代码 参数值：是要旋转的节 返回值：新的根节点
     */
    private AVLNode rightRotate(AVLNode red) {
        AVLNode yellow = red.left;
        AVLNode green = yellow.right;
        red.left = green; // 上位
        yellow.right = red; // 换爹
        updateHeight(red);
        updateHeight(yellow);
        return yellow;

    }
    private AVLNode leftRotate(AVLNode red) {
        AVLNode yellow = red.right;
        AVLNode green = yellow.left;
        yellow.left = red;
        red.right = green;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    /**
     * 先左旋左子树，再右旋根节点
     */
    private AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    /**
     * 先右旋右子树，再左旋根节点
     */
    private AVLNode rightLeftRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    // 检查节点是否失衡，重新平衡代码
    public AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        int bf = bf(node);
        if (bf > 1 && bf(node.left) >= 0) { // LL
            return leftRotate(node);
        } else if (bf > 1 && bf(node.right) < 0) { // LR
            return leftRightRotate(node);
        } else if (bf < -1 && bf(node.left) > 0) { // RL
            return rightLeftRotate(node);
        } else if (bf < -1 && bf(node.right) <= 0) { // RR
            return rightRotate(node);
        }
        return node;
    }

    AVLNode root;
    public void put(int key, Object value) {
        root = doPut(root, key, value);
    }

    private AVLNode doPut(AVLNode node, int key, Object value) {
        // 1.找到空位，创建新节点
        if (node == null) {
            return new AVLNode(key, value);
        }
        // 2.key 已存在，更新
        if (key == node.key) {
            node.value = value;
        }
        // 3.继续查找
        if (key < node.key) {
            node.left = doPut(node.left, key, value);
        } else {
            node.right = doPut(node, key, value);
        }
        updateHeight(node);
        return balance(node);
    }

    public void remove(int key) {
        root = doRemove(root, key);
    }

    private AVLNode doRemove(AVLNode node, int key) {
        //1.node ==null
        if (node == null) {
            return null;
        }
        //2.没找到key
        if (key < node.key) {
            node.left = doRemove(node.left, key);
        } else if (node.key < key) {
            node.right = doRemove(node.right, key);
        }else {
            //3.找到key    1）没有 2）只有一个孩子 3）有两个孩子
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }else {
                // 有两个孩子
                // TODO P191
            }
        }
        //4.更新高度
        updateHeight(node);
        //5.balance
        return balance(node);
    }

}
