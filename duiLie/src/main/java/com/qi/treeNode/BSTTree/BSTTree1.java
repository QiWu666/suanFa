package com.qi.treeNode.BSTTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Search Tree 二叉搜索树
 */
// TODO P168,167
public class BSTTree1 {
    public BSTNode root; // 根节点

    public static class BSTNode {
        int key;
        Object value;
        public BSTNode left;
        public BSTNode right;

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

    public Object min(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
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
        BSTNode ancestorFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                // 祖先自左而来的节点视为前驱
                ancestorFromLeft = p;
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
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    /**
     * 查找关键字的后继值
     *
     * @param key 关键字
     * @return 前驱值
     */
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p != null) {
            if (key < p.key) {
                // 祖先自右而来的节点视为后继
                ancestorFromRight = p;
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
        //  情况1：节点有右子树，此时前任就是左子树的最大值
        if (p.right != null) {
            return min(p.right);
        }
        //  情况2：节点没有右子树，若离它最近的、自右而来的祖先就是前任
        return ancestorFromRight != null ? ancestorFromRight.value : null;
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
        // 找到了当前节点p
        /*
            1.删除节点没有左孩于，将右孩子托孤给Parent
            2.删除节点没有右孩于，将左孩于托孤给Parent
            3.删除节点左右孩于都没有，已经被涵盖在情况1、情况2当中，把null托孤给
            Parent
            4.删除节点左右孩子都有
         */
        if (p == null) {
            return null;
        }
        if (p.left == null) {
            // 情况1
            shift(parent, p, p.right);
        } else if (p.right == null) {
            // 情况2
            shift(parent, p, p.left);
        } else {
//            情况4
//            4.1被删除节点找后继
            // s 后继节点
            BSTNode s = p.right;
            BSTNode sParent = p; // 后继父亲
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 后继节点即为 s
            if (sParent != p) {
                // 4.2 删除和后维不相邻,处理后继的后事
                shift(sParent, s, s.right); // 不可能有左孩子
                s.right = p.right;
            }
            // 4.3 后继取代被删除节点
            shift(parent, p, s); // TODO 不理解。
            s.left = p.left;
        }
        return p.value;
    }

    /**
     * @param node 起点
     * @param key  值
     * @return 删剩下的孩子（找到）或nuLL（没找到）
     */
    public BSTNode delete(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = delete(node.left, key);
            return node;
        }
        if (key > node.key) {
            node.right = delete(node.right, key);
            return node;
        }
        //情况1 - 只有右孩子
        if (node.left == null) {
            return node.right;
        }
        //情况2 - 只有左孩子
        if (node.right == null) {
            return node.left;
        }
        //情况3 - 有两个孩子
        return null;
    }


    /**
     * 托孤方法
     *
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else if (deleted == parent.right) {
            parent.right = child;
        }
    }

    /**
     * 找所有比key小的元素
     */
    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 走到这里代表根的子左树已经遍历完
            else {
                // 中序遍历 --> 左 值 右
                BSTNode pop = stack.pop();
                if (pop.key < key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    // 找>key的所有value
    public List<Object> greater(int key) {
/*        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 走到这里代表根的子左树已经遍历完
            else {
                // 中序遍历 --> 左 值 右
                BSTNode pop = stack.pop();
                if (pop.key > key) {
                    result.add(pop.value);
                }
                p = pop.right;
            }
        }
        return result;*/
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        // 反向中序遍历 --> 右 值 左 逆序排序
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            }
            // 走到这里代表根的子左树已经遍历完
            else {
                BSTNode pop = stack.pop();
                if (pop.key > key) {
                    result.add(pop.value);
                } else if (pop.key < key) {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    // 找>=key1且<=key2的所有值
    public List<Object> between(int key, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 走到这里代表根的子左树已经遍历完
            else {
                // 中序遍历 --> 左 值 右
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key >= key && pop.key <= key2) {
                    result.add(pop.value);
                }
                else if (pop.key > key2) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }
}
