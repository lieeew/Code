package com.leikoooo.charpter6_tree_level_travel.level2;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode102 题目要求：
 * 给你一个个二叉树，请你返回其按层序遍历得到的节点值。
 * (即逐层地，从左到右访问所有节点)。
 */
public class Level102Order {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<List<Integer>> level = level102Order(bTree.root);
        System.out.println(level.toString());
    }

    public static List<List<Integer>> level102Order(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 结果
        List<List<Integer>> res = new ArrayList<>();
        // 队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                temp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}

