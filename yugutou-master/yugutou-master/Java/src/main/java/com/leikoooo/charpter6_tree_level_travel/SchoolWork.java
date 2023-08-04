package com.leikoooo.charpter6_tree_level_travel;

import com.yugutou.tools.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-08-04 18:17
 * @Package com.leikoooo.charpter6_tree_level_travel
 * @Description 输出左视图
 */
public class SchoolWork {
    public List<Integer> findBottomLeftValue (TreeNode root) {
        List<Integer> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                if (i == 0) {
                    levelOrder.add(t.val);
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return levelOrder;
    }
}
