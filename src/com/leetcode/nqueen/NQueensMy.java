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

        int[][] table = new int[n][n];

        scanTable(table, 0);

        return list;
    }

    private boolean scanTable(int[][] table, int pos) {
        int size = table.length;
        if (pos == size * size) {
            return true;
        }

        int i = pos / size;
        int j = pos % size;

        if (table[i][j] > 0) {
            return scanTable(table, pos + 1);
        } else {
            table[i][j] = 1;
            if (checkQueens(table, pos)) {
                if (scanTable(table, pos + 1))
                    return true;
            }
            table[i][j] = 0;
        }
        return false;
    }

    protected boolean checkQueens(int[][] table, int pos) {
        int size = table.length;

        int i = pos / size;
        int j = pos % size;


        //check row
        for (int m = 0; m != j && m < size; m ++) {
            if (table[i][m] > 0)
                return false;
        }

        //check column
        for (int m = 0; m != i && m < size; m ++) {
            if (table[m][j] > 0)
                return false;
        }

        //check diagonal, left-top
        if (i > 0 && j > 0 && table[i - 1][j - 1] > 0) {
            return false;
        }

        //check diagonal, left-bottom
        if (i < size - 1 && j > 1 && table[i + 1][j - 1] > 0) {
            return false;
        }

        //check diagonal, right-top
        if (i > 0 && j < size - 1 && table[i - 1][j + 1] > 0) {
            return false;
        }

        //check diagonal, right-bottom
        if (i < size - 1 && j < size - 1 && table[i + 1][j + 1] > 0) {
            return false;
        }

        return true;
    }
}
