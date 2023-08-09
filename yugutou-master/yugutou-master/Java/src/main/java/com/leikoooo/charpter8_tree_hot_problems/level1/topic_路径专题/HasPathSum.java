package com.leikoooo.charpter8_tree_hot_problems.level1.topic_路径专题;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * LeetCode 112
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
public class HasPathSum {
    @Test
    public void test() {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();

        boolean result1 = hasPathSum(bTree.root, 12);
        System.out.println(result1);

//        List<List<Integer>> pathSum = pathSum(bTree.root, 12);
//        System.out.println(pathSum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    /**
     * 进行迭代的方法
     *
     * @param root
     * @param sum
     */
    public boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return sum == root.val;
        }
        sum -= root.val;
        return dfs(root.left, sum) || dfs(root.right, sum);
    }
}
