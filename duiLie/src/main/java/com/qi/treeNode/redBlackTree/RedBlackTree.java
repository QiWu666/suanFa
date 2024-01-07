package com.qi.treeNode.redBlackTree;

/**
 * <h3>红黑树</h3>
 */
public class RedBlackTree {
    enum Color {
        RED, BLACK
    }

    private Node root;

    private static class Node {
        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, Object value, Node left, Node right, Node parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

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
            if (parent.isLeftChild()) {
                return parent.right;
            } else {
                return parent.right;
            }
        }

        //兄弟
        Node sibling() {
            if (parent == null) {
                return null;
            }
            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }
    }

    // 判断红、黑
    boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    boolean isBlack(Node node) {
        return node == null || node.color == Color.BLACK;
    }

    // 右旋 1. parent 的处理 2. 旋转后新根的父子关系
    private void rightRotate(Node pink) {
        Node parent = pink.parent;
        Node yellow = pink.left;
        Node green = yellow.right;
        if (green != null) {
            green.parent = pink;
        }
        yellow.right = pink;
        yellow.parent = pink.parent;
        pink.left = green;
        pink.parent = yellow;
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }

    }

    // 左旋
    private void leftRotate(Node pink) {
        Node parent = pink.parent;
        Node yellow = pink.right;
        Node green = yellow.left;
        if (green != null) {
            green.parent = pink;
        }
        yellow.left = pink;
        yellow.parent = parent;
        pink.right = green;
        pink.parent = yellow;
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    /**
     * 新增 或 更新
     */
    public void put(int key, Object value) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            parent = p;
            if (key > p.key) {
                p = p.right;
            } else if (p.key > key) {
                p = p.left;
            } else {
                p.value = value;
                return;
            }
        }
        Node inserted = new Node(key, value);
        if (parent == null) {
            root = inserted;
            return;
        } else if (parent.key > key) {
            parent.left = inserted;
        } else {
            parent.right = inserted;
        }
        inserted.parent = parent;
        fixRedRed(inserted);
    }

    void fixRedRed(Node x) {
        // case 1 插入节点是根节点，变黑即可
        if (x == root) {
            x.color = Color.RED;
            return;
        }
        // case 2 插入节点父亲是黑色，无需调整
        if (isBlack(x.parent)) {
            return;
        }
//        case 3 当红红相邻：叔叔为红时
//        需要将父亲、叔叔变黑、祖父变红，然后对祖父做递归处理
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandParent = parent.parent;
        if (isRed(uncle)) {
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandParent.color = Color.RED;
            fixRedRed(grandParent);
            return;
        }
        // case 4 叔叔是黑色
        if (parent.isLeftChild() && x.isLeftChild()) { // LL
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            rightRotate(grandParent);
        } else if (parent.isLeftChild()) { // LR
            leftRotate(parent);
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            rightRotate(grandParent);
        } else if (x.isLeftChild()) { // RL
            rightRotate(parent);
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            leftRotate(grandParent);
        } else { // RR
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            leftRotate(grandParent);
        }
    }

    /**
     * 删除 会用到李代桃僵技巧、遇到黑黑不平衡进行调整
     */
    public void remove(int key) {
        Node deleted = find(key);
        if (deleted == null) {
            return;
        }
        doRemove(deleted);
    }

    private void doRemove(Node deleted) {
        Node replace = findReplace(deleted);
        Node parent = deleted.parent;
        // 没有孩子
        if (replace == null) {
            // 根节点
            if (deleted == root) {
                root = null;
            } else if (parent != null)
            // 不是根节点 且没有孩子
            {
                if (isBlack(deleted)) {
                    // 复杂处理
                    fixDoubleBlack(deleted);
                } else {
                    // 红色节点 无需处理
                }
                if (deleted.isLeftChild()) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                deleted.parent = null;
            }
            return;
        }
        // 有一个孩子
        if (deleted.left == null || deleted.right == null) {
            // 根节点
            if (deleted == root) {
                root.key = replace.key;
                root.value = replace.value;
                root.left = root.right = null;
            } else {
                // 不是跟节点
                if (deleted.isLeftChild()) {
                    parent.left = replace;
                } else {
                    parent.right = replace;
                }
                deleted.left = deleted.right = deleted.parent = null;
                if (isBlack(deleted) && isBlack(replace)) {
                    // 复杂处理
                    fixDoubleBlack(replace);
                } else {
                    replace.color = Color.RED;
                }
            }
            return;
        }
        // 有两个孩子 case 0
        int t = deleted.key;
        deleted.key = replace.key;
        replace.key = t;

        Object v = deleted.value;
        deleted.value = replace.value;
        replace.value = v;
        doRemove(replace);
    }

    // 双黑意思是，少了一个黑
    private void fixDoubleBlack(Node node) {
        if (node == null) {
            return;
        }
        Node parent = node.parent;
        Node sibling = node.sibling();
        // case 3 兄弟节点是红色
        if (isRed(sibling)) {
            if (node.isLeftChild()) {
                leftRotate(parent);
            } else {
                rightRotate(parent);
            }
            parent.color = Color.RED;
            sibling.color = Color.BLACK;
            fixDoubleBlack(node);
            return;
        }
        if (sibling != null) {
            // 兄弟是黑色 且两个侄子都是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = Color.RED;
                if (isRed(parent)) {
                    sibling.color = Color.BLACK;
                } else {
                    fixDoubleBlack(parent);
                }
            }
            // 兄弟是黑色 侄子有红色
            else {
                // LL
                if (sibling.isLeftChild() && isRed(sibling.left)) {
                    rightRotate(parent);
                    sibling.left.color = Color.BLACK;
                    sibling.color = parent.color;
                    parent.color = Color.BLACK;
                }
                // LR
                else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    leftRotate(sibling);
                    rightRotate(parent);
                    sibling.right.color = parent.color;
                    parent.color = Color.BLACK;
                }
                //
/*                else if () {

                }*/
            }
        } else {
            fixDoubleBlack(parent);
        }
    }

    // 查找删除节点
    private Node find(int key) {
        Node p = root;
        while (p != null) {
            if (p.key > key) {
                p = p.right;
            } else if (key > p.key) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    // 查找剩余节点
    private Node findReplace(Node deleted) {
        if (deleted.left == null && deleted.right == null) {
            return null;
        }
        if (deleted.left == null) {
            return deleted.right;
        }
        if (deleted.right == null) {
            return deleted.left;
        }
        Node s = deleted.right;
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }
}
