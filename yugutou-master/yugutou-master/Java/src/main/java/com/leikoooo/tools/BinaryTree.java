package com.leikoooo.tools;

import com.yugutou.tools.TreeNode;

public class BinaryTree {

    public com.yugutou.tools.TreeNode root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 方法1：比较粗糙的创建二叉树关系
     */
    public com.yugutou.tools.TreeNode buildBinaryTree() {
        com.yugutou.tools.TreeNode node = new com.yugutou.tools.TreeNode(3);
        node.left = new com.yugutou.tools.TreeNode(9);
        node.right = new com.yugutou.tools.TreeNode(20);
        node.right.right = new com.yugutou.tools.TreeNode(7);
        node.right.left = new com.yugutou.tools.TreeNode(15);
        return node;
    }

    /**
     * 用于搜索树的公共父结点问题
     * @return
     */

    public static com.yugutou.tools.TreeNode buildLowestCommonAncestor() {
        com.yugutou.tools.TreeNode node = new com.yugutou.tools.TreeNode(6);
        node.left = new com.yugutou.tools.TreeNode(2);
        node.right = new com.yugutou.tools.TreeNode(8);

        node.left.left = new com.yugutou.tools.TreeNode(0);
        node.left.right = new com.yugutou.tools.TreeNode(4);

        node.left.right.left = new com.yugutou.tools.TreeNode(3);
        node.left.right.right = new com.yugutou.tools.TreeNode(5);

        node.right.left = new com.yugutou.tools.TreeNode(7);
        node.right.right = new com.yugutou.tools.TreeNode(9);

        return node;

    }

    /**
     * 对称的二叉树
     *
     * @return
     */
    public com.yugutou.tools.TreeNode buildBinaryTree3() {
        com.yugutou.tools.TreeNode node = new com.yugutou.tools.TreeNode(3);
        node.left = new com.yugutou.tools.TreeNode(9);
        node.right = new com.yugutou.tools.TreeNode(9);
        node.right.right = new com.yugutou.tools.TreeNode(7);
        node.right.left = new com.yugutou.tools.TreeNode(15);

        node.left.right = new com.yugutou.tools.TreeNode(15);
        node.left.left = new com.yugutou.tools.TreeNode(7);

        return node;

    }

    /**
     * 建立搜索树
     */
    public com.yugutou.tools.TreeNode buildBSTTree() {
        com.yugutou.tools.TreeNode node = new com.yugutou.tools.TreeNode(4);
        node.left = new com.yugutou.tools.TreeNode(2);
        node.right = new com.yugutou.tools.TreeNode(7);
        node.left.left = new com.yugutou.tools.TreeNode(1);
        node.left.right = new com.yugutou.tools.TreeNode(3);
        return node;
    }

    /**
     * 构造一个相对复杂的二叉树
     *
     * @return
     */
    public com.yugutou.tools.TreeNode buildBinaryTreeComplex() {
        com.yugutou.tools.TreeNode node = new com.yugutou.tools.TreeNode(1);
        node.left = new com.yugutou.tools.TreeNode(2);
        node.left.left = new com.yugutou.tools.TreeNode(3);
        node.left.left.right = new com.yugutou.tools.TreeNode(4);
        node.left.left.right.right = new com.yugutou.tools.TreeNode(5);
        node.left.left.right.right.left = new com.yugutou.tools.TreeNode(6);
        node.left.left.right.right.left.left = new com.yugutou.tools.TreeNode(8);
        node.left.left.right.right.left.right = new com.yugutou.tools.TreeNode(8);

        node.right = new com.yugutou.tools.TreeNode(9);
        node.right.left = new com.yugutou.tools.TreeNode(10);
        node.right.right = new com.yugutou.tools.TreeNode(11);
        node.right.right.right = new com.yugutou.tools.TreeNode(12);
        node.right.right.right.left = new com.yugutou.tools.TreeNode(13);
        node.right.right.right.left.left = new com.yugutou.tools.TreeNode(15);
        node.right.right.right.left.right = new com.yugutou.tools.TreeNode(14);
        return node;

    }

    /**
     * 方法二： 根据大小来建立建二叉树
     *
     * @param node
     * @param data
     */
    public void buildTree(com.yugutou.tools.TreeNode node, int data) {
        if (root == null) {
            root = new com.yugutou.tools.TreeNode(data);
        } else {
            if (data < node.val) {
                if (node.left == null) {
                    node.left = new com.yugutou.tools.TreeNode(data);
                } else {
                    buildTree(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new com.yugutou.tools.TreeNode(data);
                } else {
                    buildTree(node.right, data);
                }
            }
        }
    }


    /**
     * 前序遍历
     *
     * @param node
     */
    public void preOrder(com.yugutou.tools.TreeNode node) {
        if (node != null) {
            System.out.print(node.val + "\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrder(com.yugutou.tools.TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + "\t");
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + "\t");
        }
    }

    public static void main(String[] args) {

        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        bTree.preOrder(bTree.root);
        System.out.println();
        bTree.inOrder(bTree.root);
        System.out.println();
        bTree.postOrder(bTree.root);


    }


}