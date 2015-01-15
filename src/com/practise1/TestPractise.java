package com.practise1;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        char[][] a = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'},

        };

        char[][] b = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
        };

        TestPractise testPractise = new TestPractise();
        testPractise.solve(b);
        for (char[] arr : b) {
            System.out.println(arr);
        }
        System.out.println();
    }

    private static void outputTree(List<TreeNode> treeNodes) {
        for (TreeNode root : treeNodes) {
            TreeNodePrinter.printNode(root);
            System.out.println("------------------");
        }
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i ++) {
            char c = board[i][0];
            if (c == 'O') {
                bfs(board, i, 0);
            }
            c = board[i][n - 1];
            if (c == 'O') {
                bfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < n; i ++) {
            char c = board[0][i];
            if (c == 'O') {
                bfs(board, 0, i);
            }
            c = board[m - 1][i];
            if (c == 'O') {
                bfs(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == '2') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void bfs(char[][] board, int i, int j) {
        board[i][j] = '2';
        int m = board.length, n = board[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(n * i + j);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / n;
            int y = pos % n;
            if (x > 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = '2';
                queue.add((x - 1) * n + y);
            }

            if (y > 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = '2';
                queue.add(x * n + y - 1);
            }

            if (x < m - 1 && board[x + 1][y] == 'O') {
                board[x + 1][y] = '2';
                queue.add((x + 1) * n + y);
            }

            if (y < n - 1 && board[x][y + 1] == 'O') {
                board[x][y + 1] = '2';
                queue.add(x * n + y + 1);
            }
        }
    }
}


