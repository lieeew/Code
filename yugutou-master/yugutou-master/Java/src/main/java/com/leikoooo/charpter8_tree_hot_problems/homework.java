package com.leikoooo.charpter8_tree_hot_problems;

import com.yugutou.tools.TreeNode;

import javax.swing.plaf.SliderUI;


/**
 * @author leikooo
 */
public class homework {

    /**
     * 删除二叉树的叶节点
     */
    public TreeNode deleteLeafNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            node.left = null;
        }
        if (node.right != null && node.right.left == null && node.right.right == null) {
            node.right = null;
        }

        deleteLeafNode(node.left);
        deleteLeafNode(node.right);

        return node;
    }

    public int search(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int search(int[] a, int low, int height, int key) {
        if (low <= height) {
            int mid = (height + low) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                search(a, height, mid - 1, key);
            } else {
                search(a, mid + 1, height, key);
            }
        }
        return -1;
    }
}
