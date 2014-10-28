package com.leetcode.nqueen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 10/27/14.
 */
public class NQueensMy {

    public static void main(String[] strings) {

        NQueensMy nQueensMy = new NQueensMy();
        List<String[]> list = nQueensMy.solveNQueens(4);


        for (String[] queens : list) {
            for (String b : queens) {
                System.out.print(b + ", ");
            }
            System.out.println("");
        }
    }

    public List<String[]> solveNQueens(int n) {
        List<String[]> list = new ArrayList<String[]>();

        if (n < 4) {
            return list;
        }

        boolean[][] board = new boolean[n][n];

        boolean isSucc = scanBoard(board, 0);

        if (isSucc) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    System.out.print(board[x][y] + ", ");
                }
                System.out.println();
            }
        }

        return list;
    }

    private boolean scanBoard(boolean[][] board, int col) {
        int size = board.length;
        if (col >= size) {
            return true;
        }

        //try to put on each row
        for (int i = 0; i < size; i++) {
            if (checkQueensLeftSide(board, i, col)) {
                board[i][col] = true;
                if (scanBoard(board, col + 1))
                    return true;
                board[i][col] = false;
            }
        }

        return false;
    }

    protected boolean checkQueensLeftSide(boolean[][] board, int row, int col) {
        int size = board.length;

        /* Check this row on left side */
        for (int i = 0; i < col; i++) {
            if (board[row][i])
                return false;
        }

        /* Check upper diagonal on left side */
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }

        /* Check lower diagonal on left side */
        for (int i = row, j = col; j >= 0 && i < size; i++, j--) {
            if (board[i][j])
                return false;
        }

        return true;
    }
}
