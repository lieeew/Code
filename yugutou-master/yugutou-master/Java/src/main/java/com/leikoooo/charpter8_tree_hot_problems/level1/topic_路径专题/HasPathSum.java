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

    Map<Integer, Object> map = new HashMap<>();

    /**
     * @param root      根节点
     * @param targetSum 路径总和
     * @return 返回是否含有对应的 路径总和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, 0);
        return map.containsKey(targetSum);
    }


    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        // 如果到达根节点
        if (root.right == null && root.left == null) {
            // 这里要把技计算出来的整到集合之中
            map.put(sum, null);
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
