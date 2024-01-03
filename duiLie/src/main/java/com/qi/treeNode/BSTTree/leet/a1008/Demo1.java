package com.qi.treeNode.BSTTree.leet.a1008;

import com.qi.treeNode.TreeNode;

/**
 * 根据前序遍历构造二叉搜索树
 */
public class Demo1 {
    /**
     * @param preorder 待添加数组的值。
     * @return 添加成功后的代码
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.value) {
            node.left = insert(node.left, val);
        } else if(node.value < val){
            node.right = insert(node.right, val);
        }
        return node;
    }
}
