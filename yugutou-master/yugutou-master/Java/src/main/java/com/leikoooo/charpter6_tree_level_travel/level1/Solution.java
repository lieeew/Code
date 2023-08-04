package com.leikoooo.charpter6_tree_level_travel.level1;

import com.yugutou.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    @Test
    public void test() {


    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        // 创建队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                res.add(0, t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }

                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return res.get(res.size() - 1);
    }
}