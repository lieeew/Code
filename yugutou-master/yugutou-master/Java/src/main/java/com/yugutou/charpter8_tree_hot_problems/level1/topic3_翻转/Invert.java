package com.yugutou.charpter8_tree_hot_problems.level1.topic3_翻转;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.LinkedList;

/**
 * leetcode104 翻转问题
 */
public class Invert {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
//        bTree.root = bTree.buildBinaryTree();
        bTree.root = bTree.buildBinaryTree();

        TreeNode result = null;
        //LeetCode101 对称二叉树
        int testMethod = 1;
        switch (testMethod) {
            case 1:
                result = invertTree_1(bTree.root);
                break;
            case 2:
                result = invertTree_2(bTree.root);
                break;
            case 3:
                result = invertTree_3(bTree.root);
                break;
        }

        System.out.println(result.val);
    }

    /**
     * 方法1：递归-前序
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree_1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        TreeNode left = invertTree_1(root.left);
        TreeNode right = invertTree_1(root.right);
        return root;

    }

    /**
     * 方法2：递归-后序
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree_2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree_2(root.left);
        TreeNode right = invertTree_2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 方法3：迭代
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree_3(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        if (root == null)
            return null;

        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.remove();
                //这一行就是 精华所在
                swap(node.left, node.right); // 节点处理
                if (node.left != null)
                    que.add(node.left);
                if (node.right != null)
                    que.add(node.right);
            }
        }
        return root;
    }

    public static void swap(TreeNode left, TreeNode right) {
        TreeNode tmp = left;
        left = right;
        right = tmp;
    }
}
