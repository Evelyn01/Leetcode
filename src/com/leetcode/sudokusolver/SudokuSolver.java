package com.leetcode.sudokusolver;

/**
 * Created by titan-developer on 10/25/14.
 * https://oj.leetcode.com/problems/sudoku-solver/
 *
 * Solution:
 * http://www.cnblogs.com/easonliu/p/3662904.html
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (scanPos(board, 0))
            return;
    }

    boolean check(char[][] board, int pos) {
        int v = pos / 9;
        int h = pos % 9;
        char target = board[v][h];

        //row
        for (int st = 0; st < 9; st++) {
            if (st != h) {
                if (target == board[v][st])
                    return false;
            }
        }

        //column
        for (int st = 0; st < 9; st++) {
            if (st != v) {
                if (target == board[st][h])
                    return false;
            }
        }

        //block
        int beginx = v / 3 * 3;
        int beginy = h / 3 * 3;
        for (int i = beginx; i < beginx + 3; i++) {
            for (int j = beginy; j < beginy + 3; j++) {
                if (i != v && j != h) {
                    if (target == board[i][j])
                        return false;
                }
            }
        }

        return true;
    }

    boolean scanPos(char[][] board, int pos) {//pos 0~80: vertical(v) -- pos/9; horizontal(h) -- pos%9
        if (pos == 81)
            return true;
        else {
            int v = pos / 9;
            int h = pos % 9;
            if (board[v][h] != '.') {
                return scanPos(board, pos + 1);
            } else {
                for (int i = 1; i <= 9; i++) {
                    board[v][h] = (char) ('0' + i);
                    if (check(board, pos)) {
                        if (scanPos(board, pos + 1))
                            return true;
                    }
                    board[v][h] = '.';
                }
            }
            return false;
        }
    }


}
