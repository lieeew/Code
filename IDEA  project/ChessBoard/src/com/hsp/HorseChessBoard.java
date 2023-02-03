package com.hsp;


import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/3 16
 * @Description:
 */
public class HorseChessBoard {
    private static int X = 6; // 表示col 列
    private static int Y = 6; // 表示crow 行
    private static int[][] chessBoard = new int[Y][X]; // 棋盘
    private static boolean[] visited = new boolean[X * Y]; // 记录位置是否走过
    private static boolean finished = false; // 记录马儿是否遍历完棋盘


    /**
     * 下一步可以走的全部位置
     */
    public static ArrayList<Point> next(Point curPoint) {
        // 创建一个ArraysList
        ArrayList<Point> ps = new ArrayList<>();

        // 创建一个point
        Point point = new Point();
        // 如果有下一个位置就point放入到ps之中
        // 判断5是否位置
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(point));
        }
        // 判断6是否位置
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(point)); //这里一定要new Point
        }
        // 判断0是否位置
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(point));
        }
        // 判断1是否位置
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y + 1) < Y) {
            ps.add(new Point(point));
        }
        // 判断2是否位置
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y + 2) < Y) {
            ps.add(new Point(point));
        }
        // 判断3是否位置
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) < Y) {
            ps.add(new Point(point));
        }
        // 判断4是否位置
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) < Y) {
            ps.add(new Point(point));
        }

        return ps;
    }


    /**
     * 编写最核心的算法
     */
    public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {
        chessBoard[row][col] = step;
        // 把这个位置, 设置为已经访问
        visited[row * X + col] = true;
        // 获取当前往下走的位置有哪些
        ArrayList<Point> ps = next(new Point(col, row));
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            // 判断该位置有没有被走过
            if (!visited[p.y * X + p.x]) {
                // 递归遍历
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }

        if (step < X * Y && !finished) {
            // 重置棋盘
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }

    /**
     *贪心算法进行排序
     */
    public static void sort(ArrayList<Point> ps) {
        ps.sort((o1, o2) -> next(o1).size() - next(o2).size());
    }

    public static void main(String[] args) {
        int row = 5;
        int col = 5;
        // 测试
        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("耗时 " + (end - start));
        for (int[] ints : chessBoard) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

    }

}
