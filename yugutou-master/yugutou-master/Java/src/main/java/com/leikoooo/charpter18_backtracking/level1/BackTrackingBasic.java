package com.leikoooo.charpter18_backtracking.level1;

import java.util.*;

/**
 * @author leikooo @Description LeetCode77 Given two integers n and k, return all possible
 *     combinations of k numbers chosen from the range [1, n]
 */
public class BackTrackingBasic {

  /**
   * 组合之后返回对应的集合
   *
   * @param n n
   * @param k k
   * @return
   */
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> resultList = new ArrayList<>();
    if (k <= 0 || n < k) {
      return resultList;
    }
    Deque<Integer> path = new ArrayDeque<>();
    dfs(n, k, 1, path, resultList);
    return resultList;
  }

  /**
   * 循环调用的方法
   *
   * @param n n
   * @param k k
   * @param beginIndex 开始回溯的索引
   * @param path 对应暂存集合
   * @param resultList 结果集合
   */
  public void dfs(
      int n, int k, int beginIndex, Deque<Integer> path, List<List<Integer>> resultList) {
    // 循环结束条件是 path.size() == k
    if (path.size() == k) {
      resultList.add(new ArrayList<>(path));
      return;
    }
    for (int i = beginIndex; i <= n; i++) {
      path.addLast(i);
      dfs(n, k, i + 1, path, resultList);
      path.removeLast();
    }
  }
}
