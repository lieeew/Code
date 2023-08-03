package com.leikoooo.charpter6_tree_level_travel.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

  public static void main(String[] args) {
    // 创建一个 N 叉树
    Node root = new Node(1);
    root.children.add(new Node(2));
    root.children.add(new Node(3));
    root.children.get(0).children.add(new Node(4));
    root.children.get(0).children.add(new Node(5));
    root.children.get(1).children.add(new Node(6));
    root.children.get(1).children.add(new Node(7));

    // 使用队列遍历树
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    List<Integer> result = new ArrayList<>();

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      result.add(node.val);
      for (Node child : node.children) {
        queue.add(child);
      }
    }

    // 打印层序遍历
    System.out.println(result);
  }

}

class Node {

  int val;
  List<Node> children;

  public Node(int val) {
    this.val = val;
    this.children = new ArrayList<>();
  }

}
