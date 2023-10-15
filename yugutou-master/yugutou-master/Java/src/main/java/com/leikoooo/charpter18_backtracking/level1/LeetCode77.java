package com.leikoooo.charpter18_backtracking.level1;

import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-10-07 9:29 @Package com.leikoooo.charpter18_backtracking.level1 @Description 给定两个整数
 *     n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。例如，输入n=4，k=2，则输出： [[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]]
 */
public class LeetCode77 {
  @Test
  void test() {
    combine(10, 2);
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (k <= 0 || n < k) {
      return res;
    }

    // 用户返回结果
    Deque<Integer> path = new ArrayDeque<>();
    dfs(n, k, 1, path, res);
    return res;
  }

  public void dfs(
      int n, int k, int startIndex, Deque<Integer> path, List<List<Integer>> resultList) {
    // 递归终止条件是：path 的长度等于 k
    if (path.size() == k) {
      resultList.add(new ArrayList<>(path));
      return;
    }

    // 针对一个结点，遍历可能的搜索起点，其实就是枚举
    for (int i = startIndex; i <= n; i++) {
      // 向路径变量里添加一个数，就是上图中的一个树枝的值
      path.addLast(i);
      // 搜索起点要加1是为了缩小范围，下一轮递归做准备，因为不允许出现重复的元素
      dfs(n, k, i + 1, path, resultList);
      // 递归之后需要做相同操作的逆向操作,具体后面继续解释
      path.removeLast();
    }
  }
}
