package com.qi.treeNode.BSTTree;

/**
 * Binary Search Tree 二叉搜索树
 */
// TODO P168,167
public class BSTTree1 {
    BSTNode root; // 根节点

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 查找关键字对应的值
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
    public Object get(int key) {
        return doGet(root, key);
    }

    private Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            return doGet(node.left, key); // 向左找
        } else if (node.key < key) {
            return doGet(node.right, key); // 向右找
        } else {
            return node.value;
        }
    }

    /**
     * 查找关键字对应的值，非递归
     *
     * @param key
     * @return
     */
    public Object doGetNoDiGui(int key) {
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (node.key < key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * @return 查找最小关键字对应值
     */
    public Object min() {
        return doMin(root);
    }

    public Object minNoDiGui() {
        if (root == null) {
            return null;
        }
        BSTNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    /**
     * 伪递归
     */
    private Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) { //最小的节点
            return node;
        }
        return doMin(node.left);
    }

    /**
     * @return 查找最大关键字对应值
     */
    public Object max() {
        return max(root);
    }

    public Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    /**
     * 存储关键字和对应值
     *
     * @param key   关键字
     * @param value 值
     */
    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node; // 4 7 8
            if (key < node.key) {
                node = node.left;
            } else if (node.key < key) {
                node = node.right; // 4->7 7->8 8->null
            } else {
                //1.key 有   -> 更新
                node.value = value;
                return;
            }
        }
        //2.key 没有 -> 新增
        if (key < parent.key) {
            BSTNode added = new BSTNode(key, value);
            parent.right = added;
        } else if (key > parent.key) {
            BSTNode added = new BSTNode(key, value);
            parent.left = added;
        }
    }

    /**
     * 查找关键字的前驱值
     *
     * @param key 关键字
     * @return 前驱值
     */
    public Object predecessor(int key) {
        BSTNode p = root;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                break;
            }
        }
        // 没找到节点
        if (p == null) {
            return null;
        }
        //  找到节点
        //  情况1：节点有左子树，此时前任就是左子树的最大值
        if (p.left != null) {
            return max(p.left);
        }
        //  情况2：节点没有左子树，若离它最近的、自左而来的祖先就是前任
        return null;
    }

    /**
     * 查找关键字的后继值
     *
     * @param key 关键字
     * @return 前驱值
     */
    public Object successor(int key) {
        return null;
    }

    /**
     * 根据关键字删除
     *
     * @param key 关键字
     * @return 被删除关键字对应值
     */
    public Object delete(int key) {
        BSTNode p = root;
        BSTNode parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (p.key < key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        if (p.left == null ) {
            // 情况1
            shift(parent, p, p.left);
        } else if (p.right == null) {
            // 情况2
            shift(parent, p, p.right);
        }else {
//            情况4
//            4.1被删除节点找后继
//            4.2处理后继的后事
//            4.3后继取代被删除节点

        }
        return p.value;
    }


    /**
     * 托孤方法
     * @param parent 被删除节点的父亲
     * @param deleted 被删除节点
     * @param child 被顶上去的节点
     */
    private void shift(BSTNode parent,BSTNode deleted,BSTNode child) {
        if (parent == null) {
            root = child;
        }else if (deleted == parent.left) {
            parent.left = child;
        } else if (deleted == parent.right) {
            parent.right = child;
        }
    }
}
