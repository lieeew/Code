package com.leikoooo.charpter8_tree_hot_problems.level1.topic_路径专题;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode257 二叉树的所有路径
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<String> result = binaryTreePaths(bTree.root);
        System.out.println(result);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private static void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            // 到达跟根节点
            res.add(path + root.val);
            return;
        }
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }
}
