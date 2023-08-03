package com.leikoooo.charpter6_tree_level_travel.level2;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.*;

/**
 * LeetCode103 题，
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<List<Integer>> level = zigzagLevelOrder(bTree.root);
        System.out.println(level.toString());
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 创建返回的结果集合
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        // Flag to indicate the traversal direction
        boolean isLeftToRight = true;
        // 创建队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            // 循环遍历
            for (int i = 0, j = 1; i < size; i++, j++) {
                TreeNode t = queue.remove();
                if (isLeftToRight) {
                    temp.add(t.val);
                } else {
                    temp.add(0, t.val);
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            levelOrder.add(temp);
            isLeftToRight = !isLeftToRight;
        }
        return levelOrder;
    }
}

